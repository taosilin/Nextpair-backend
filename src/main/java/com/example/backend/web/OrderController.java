package com.example.backend.web;

import com.example.backend.core.Result;
import com.example.backend.core.ResultGenerator;
import com.example.backend.model.Order;
import com.example.backend.service.OrderService;
import com.example.backend.service.WxService;
import com.example.backend.web.model.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Resource
    private OrderService orderService;
    @Resource
    private WxService wxService;

    @PostMapping("/wx")
    public Map wxAdd(@RequestBody WXPayRequest wxPayRequest) throws Exception {
        return wxService.doUnifiedOrder(wxPayRequest);
    }

    @PostMapping("/notify")
    public String wxPayNotify(HttpServletRequest request) {
        String resXml = "";
        try {
            InputStream inputStream = request.getInputStream();
            //将InputStream转换成xmlString
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder sb = new StringBuilder();
            String line = null;
            try {
                while ((line = reader.readLine()) != null) {
                    sb.append(line + "\n");
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            } finally {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            resXml = sb.toString();
            String result = wxService.payBack(resXml);
            return result;
        } catch (Exception e) {
            System.out.println("微信手机支付失败:" + e.getMessage());
            String result = "<xml>" + "<return_code><![CDATA[FAIL]]></return_code>" + "<return_msg><![CDATA[报文为空]]></return_msg>" + "</xml> ";
            return result;
        }
    }





    @PostMapping("/add")
    public Result addOrder(@RequestBody AddOrderRequest addOrderRequest){
        orderService.addOrder(addOrderRequest);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result orderDetail(@RequestBody Order order){
        OrderRequest orderRequest = orderService.orderDetail(order.getOrderID());
        return ResultGenerator.genSuccessResult(orderRequest);
    }

    @PostMapping("/userlist")
    public Result userOrderList(@RequestBody Order order){
        List<OrderRequest> list = orderService.userOrderList(order.getUserID());
        return ResultGenerator.genSuccessResult(list);
    }

    @PostMapping("/list")
    public Result orderList(@RequestBody MyRequestBody myRequestBody){
        List<Order> list = orderService.orderList(myRequestBody.sortedBy, myRequestBody.page, myRequestBody.size);
        return ResultGenerator.genSuccessResult(list);
    }

    @PostMapping("/update")
    public Result updateOrder(@RequestBody Order o){
        orderService.updateOrder(o);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/updatestate")
    public Result updateOrderState(@RequestBody Order o){
        orderService.updateOrderState(o.getOrderID(),o.getState());
        return ResultGenerator.genSuccessResult();
    }

    //订单待办预警
    @PostMapping("/pending")
    public Result orderPending(){
        OrderPending orderPending = orderService.orderPending();
        return ResultGenerator.genSuccessResult(orderPending);
    }

//    @PostMapping("/findByDate")
//    public Result findByDate(@RequestBody String orderTime){
//        //日期格式转换
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        Date date = null;
//        try{
//            date = simpleDateFormat.parse(orderTime);
//        }catch (ParseException e){
//            e.printStackTrace();
//        }
//        List<Order> list = orderService.findByDate(date);
//        return ResultGenerator.genSuccessResult(list);
//    }

    @PostMapping("/state")
    public Integer stateOrderNum(@RequestBody Order order){
        return orderService.stateOrderNum(order.getState());
    }

    @PostMapping("/total")
    public Integer orderTotal(){
        return orderService.orderTotal();
    }

    //今日交易看板
    @PostMapping("/transaction")
    public Result transactionBoard(){
        TransactionBoard transactionBoard = orderService.transactionBoard();

        return ResultGenerator.genSuccessResult(transactionBoard);
    }

    //订单统计
    @PostMapping("/statistics")
    public Result orderStatistics(){
        List<OrderStatistics> list = orderService.orderStatistics();
        return ResultGenerator.genSuccessResult(list);
    }
}
