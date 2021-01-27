package com.example.backend.web;

import com.example.backend.core.Result;
import com.example.backend.core.ResultGenerator;
import com.example.backend.web.model.APPRequestBody;
import com.example.backend.web.model.WXLoginResult;
import org.apache.commons.codec.binary.Base64;
import org.json.JSONException;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;

import org.json.JSONObject;

@RestController
@RequestMapping("/app")
public class APPController {

    /**
     * 微信小程序登录获取
     * 获取session_key
     * @param
     * @return
     */

    // 微信小程序登录获取获取session_key
    @PostMapping("/initWxLogin")
    public Result initWxLogin(@RequestBody APPRequestBody appRequestBody) throws JSONException {

        // 测试数据code
        // js_code = "081ZQ3f91fr9VM1HYdb91y93f91ZQ3fU";
        // 微信获取session_key接口地址
        String wxLoginUrl = "https://api.weixin.qq.com/sns/jscode2session";
        // 接口参数
        String param = "appid=wx9e784305e6f48a50&secret=14eabcb594e6571429c7d67d0a505004&js_code=" + appRequestBody.jsCode + "&grant_type=authorization_code";
        // 调用获取session_key接口 请求方式get
        String jsonString = GetPostUntil.sendGet(wxLoginUrl, param);
        System.out.println(jsonString);
        // 因为json字符串是大括号包围，所以用JSONObject解析
        JSONObject json = new JSONObject(jsonString);
        // json解析session_key值
        String session_key = json.getString("session_key");
        String openid = json.getString("openid");

        WXLoginResult wxLoginResult = new WXLoginResult();
        wxLoginResult.session_key = json.getString("session_key");
        wxLoginResult.openid = json.getString("openid");

        System.out.println("session_key：" + session_key);

        // 返回给前端
        return ResultGenerator.genSuccessResult(wxLoginResult);
    }


    // 解密小程序用户敏感数据
    @ResponseBody
    @PostMapping(value = "/decodeUserInfo")
    public Result decodeUserInfo(@RequestBody APPRequestBody appRequestBody) throws UnsupportedEncodingException, InvalidAlgorithmParameterException, JSONException {
        //AESUtils微信获取手机号解密工具类
        AESUtils aes = new AESUtils();
        //调用AESUtils工具类decrypt方法解密获取json串
        byte[] resultByte = aes.decrypt(Base64.decodeBase64(appRequestBody.encryptedData), Base64.decodeBase64(appRequestBody.sessionKey), Base64.decodeBase64(appRequestBody.iv));
        //判断返回参数是否为空
        if (null != resultByte && resultByte.length > 0) {
            String jsons = new String(resultByte, "UTF-8");
            System.out.println(jsons);
            JSONObject json = new JSONObject(jsons);
            //json解析phoneNumber值
            String phoneNumber = json.getString("phoneNumber");
            System.out.println("phoneNumber：" + phoneNumber);
            return ResultGenerator.genSuccessResult(phoneNumber);
        }
        return ResultGenerator.genFailResult("session_key:失败");
    }
}
