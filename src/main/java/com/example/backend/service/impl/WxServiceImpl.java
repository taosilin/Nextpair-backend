package com.example.backend.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.example.backend.core.WXConfigUtil;
import com.example.backend.service.WxService;

import com.example.backend.web.model.WXPayRequest;
import com.github.wxpay.sdk.WXPay;
import com.github.wxpay.sdk.WXPayConstants;
import com.github.wxpay.sdk.WXPayUtil;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class WxServiceImpl implements WxService {

    private static Logger longger = LoggerFactory.getLogger("WxService");
    public static final String SPBILL_CREATE_IP = "129.211.168.202";
    public static final String NOTIFY_URL = "http://from2121.com:8443/order/notify";
    public static final String TRADE_TYPE = "JSAPI";

    @Override
    public String payBack(String resXml) {
        WXConfigUtil config = null;
        try {
            config = new WXConfigUtil();
        } catch (Exception e) {
            e.printStackTrace();
        }
        WXPay wxpay = new WXPay(config);
        String xmlBack = "";
        Map<String, String> notifyMap = null;
        try {
            notifyMap = WXPayUtil.xmlToMap(resXml);         // 调用官方SDK转换成map类型数据
            if (wxpay.isPayResultNotifySignatureValid(notifyMap)) {//验证签名是否有效，有效则进一步处理

                String return_code = notifyMap.get("return_code");//状态
                String out_trade_no = notifyMap.get("out_trade_no");//商户订单号
                if (return_code.equals("SUCCESS")) {
                    if (out_trade_no != null) {
                        // 注意特殊情况：订单已经退款，但收到了支付结果成功的通知，不应把商户的订单状态从退款改成支付成功
                        // 注意特殊情况：微信服务端同样的通知可能会多次发送给商户系统，所以数据持久化之前需要检查是否已经处理过了，处理了直接返回成功标志
                        //业务数据持久化
                        //log.info("微信手机支付回调成功订单号:{}", out_trade_no);
                        xmlBack = "<xml>" + "<return_code><![CDATA[SUCCESS]]></return_code>" + "<return_msg><![CDATA[OK]]></return_msg>" + "</xml> ";
                    } else {
                        //log.info("微信手机支付回调失败订单号:{}", out_trade_no);
                        xmlBack = "<xml>" + "<return_code><![CDATA[FAIL]]></return_code>" + "<return_msg><![CDATA[报文为空]]></return_msg>" + "</xml> ";
                    }
                }
                return xmlBack;
            } else {
                // 签名错误，如果数据里没有sign字段，也认为是签名错误
                //失败的数据要不要存储？
                //log.error("手机支付回调通知签名错误");
                xmlBack = "<xml>" + "<return_code><![CDATA[FAIL]]></return_code>" + "<return_msg><![CDATA[报文为空]]></return_msg>" + "</xml> ";
                return xmlBack;
            }
        } catch (Exception e) {
            //log.error("手机支付回调通知失败", e);
            xmlBack = "<xml>" + "<return_code><![CDATA[FAIL]]></return_code>" + "<return_msg><![CDATA[报文为空]]></return_msg>" + "</xml> ";
        }
        return xmlBack;
    }

    @Override
    public Map doUnifiedOrder(WXPayRequest wxPayRequest) throws Exception {
        try {
            longger.info("----------------->"+ JSONObject.toJSON(wxPayRequest));
            WXConfigUtil config = new WXConfigUtil();

            WXPay wxpay = new WXPay(config);

            Map<String, String> data = new HashMap<>();

            //生成商户订单号，不可重复
            data.put("appid", config.getAppID());

            data.put("mch_id", config.getMchID());

            data.put("nonce_str", WXPayUtil.generateNonceStr());

            //使用官方API请求预付订单
            data.put("sign", WXPayUtil.generateSignature(data, config.getKey(),
                    WXPayConstants.SignType.MD5));

            data.put("sign_type", WXPayConstants.MD5);

            String body = "2121眼镜";
            data.put("body", body);

            // 商品详情：商品详细描述，对于使用单品优惠的商户，该字段必须按照规范上传，详见“单品优惠参数说明”
            data.put("detail", "测试商品详情");

            //附加数据，在查询API和支付通知中原样返回，该字段主要用于商户携带订单的自定义数据
            data.put("attach", "测试附加数据");

            data.put("out_trade_no", wxPayRequest.orderID);

            data.put("fee_type", "CNY");

//            float actualAmount = Float.valueOf(wxPayRequest.actualAmount)*100;
            // 单位为分
            data.put("total_fee", wxPayRequest.actualAmount);

            //自己的服务器IP地址
            data.put("spbill_create_ip", SPBILL_CREATE_IP);

            //异步通知地址（请注意必须是外网）
            data.put("notify_url", NOTIFY_URL);

            //交易类型
            data.put("trade_type", TRADE_TYPE);

            // openid
            data.put("openid", wxPayRequest.openid);

            // 生成一次签名 sign
            Map<String, String> response = wxpay.unifiedOrder(data);

            System.out.println(response);
            if ("SUCCESS".equals(response.get("return_code"))) {//主要返回以下5个参数
                Map<String, String> param = new HashMap<>();

                param.put("appId", config.getAppID());

                param.put("nonceStr", response.get("nonce_str"));

                param.put("package", "prepay_id="+response.get("prepay_id"));

                param.put("signType", "MD5");

                param.put("timeStamp", System.currentTimeMillis() / 1000 + "");

                param.put("sign", WXPayUtil.generateSignature(param, config.getKey(),
                        WXPayConstants.SignType.MD5));

                //param.put("key", "Shanhaimianshikeji2121yanjing518");
                //param.put("prepayid", response.get("prepay_id"));
                //param.put("mch_id", response.get("mch_id"));

                return param;
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("下单失败");
        }
        throw new Exception("下单失败");
    }
}
