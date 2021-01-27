package com.example.backend.service;

import com.example.backend.core.Service;
import com.example.backend.model.Order;
import com.example.backend.web.model.*;

import java.util.Date;
import java.util.List;

public interface OrderService extends Service<Order> {
    void addOrder(AddOrderRequest o);
    OrderRequest orderDetail(String orderID);
    List<OrderRequest> userOrderList(String userID);
    List<Order> orderList(String state,Integer page,Integer size);
    void updateOrder(Order o);

    void updateOrderState(String orderID,String state); // 修改订单状态

    OrderPending orderPending();
    List<Order> findByDate(Date orderTime);

    Integer stateOrderNum(String state);
    Integer orderTotal();

    TransactionBoard transactionBoard();//今日交易看板

    List<OrderStatistics> orderStatistics();//订单统计
}
