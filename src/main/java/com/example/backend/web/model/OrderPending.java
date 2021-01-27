package com.example.backend.web.model;

//待办预警
public class OrderPending {
    public Integer toBeReviewed; //待审核
    public Integer toBeProduced; //待生产
    public Integer toBeDelivered; //待发货
    public Integer refundApplication; //退款申请
    public Integer returnApplication; //退货申请
}
