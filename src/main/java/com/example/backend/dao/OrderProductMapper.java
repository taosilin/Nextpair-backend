package com.example.backend.dao;

import com.example.backend.core.Mapper;
import com.example.backend.model.OrderProduct;
import com.example.backend.web.model.OrderProductResult;
import org.apache.ibatis.annotations.Param;

import java.util.List;
public interface OrderProductMapper extends Mapper<OrderProduct> {
    public void addOrderProduct(OrderProduct o);
    public List<OrderProductResult> findOrderProduct(@Param("orderID") String orderID);
}
