package com.example.backend.web.model;

import com.example.backend.model.Order;
import com.example.backend.model.OrderFrame;
import com.example.backend.model.OrderProduct;

import java.util.List;

public class AddOrderRequest {
    public Order order;
    public List<OrderFrame> orderFrames;
    public List<OrderProduct> orderProducts;
}
