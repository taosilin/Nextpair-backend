package com.example.backend.web.model;

// 微信调用统一下单接口请求
public class WXPayRequest {
    public String openid;
    public String orderID;
    public String actualAmount;
}
