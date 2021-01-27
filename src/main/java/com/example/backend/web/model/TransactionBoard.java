package com.example.backend.web.model;

import java.util.Date;

//今日交易看板
public class TransactionBoard {
    public Integer paymentOrderNum = 0; //今日付款订单数量
    public Double paymentOrderAmount = 0.00; //今日付款订单金额
    public Integer yesterdayOrderNum = 0; //昨日付款订单数量
    public Double yesterdayOrderAmount = 0.00; //昨日付款订单金额
}
