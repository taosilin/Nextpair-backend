package com.example.backend.dao;

import com.example.backend.core.Mapper;
import com.example.backend.model.OrderFrame;
import com.example.backend.web.model.OrderFrameResult;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderFrameMapper extends Mapper<OrderFrame> {
    public void addOrderFrame(OrderFrame o);
    public List<OrderFrameResult> findOrderFrame(@Param("orderID") String orderID);
}
