package com.example.backend.web.model;

import java.util.Date;

//订单统计
public class OrderStatistics {
    public Date orderDate; //日期
    public Integer orderNum = 0; //订单量
    public Integer paymentOrderNum = 0; //付款订单量
    public Double paymentOrderAmount = 0.00; //付款金额
    public Double paymentRate = 0.00; //付款率
}
