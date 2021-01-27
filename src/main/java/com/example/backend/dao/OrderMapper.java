package com.example.backend.dao;

import com.example.backend.core.Mapper;
import com.example.backend.model.Order;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface OrderMapper extends Mapper<Order> {
    public void addOrder(Order o);
    public Order findByOrderID(@Param("orderID") String orderID);
    public List<Order> findByUserID(@Param("userID") String userID);
    public List<Order> orderList(@Param("page")Integer page,@Param("size")Integer size);

    public void updateOrder(Order o);

    public void updateOrderState(@Param("orderID")String orderID,@Param("state")String state); // 修改订单状态
    public void payOrder(Order o); // 用户付款
    public void confirmOrder(Order o); // 用户下单

    public List<Order> stateFilter(@Param("state")String state,@Param("page")Integer page,@Param("size")Integer size);
    public Integer stateOrderNum(@Param("state")String state); // 查询某状态的订单数量
    public Integer orderTotal(); // 订单总数

    public List<Order> findByDate(@Param("orderTime") Date orderTime);
    public List<Order> findByPaymentDate(@Param("paymentTime") Date paymentTime);

    //今日订单
    public List<Order> todayOrder();

    //昨日订单
    public List<Order> yesterdayOrder();
}
