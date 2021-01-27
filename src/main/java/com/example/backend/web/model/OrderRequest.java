package com.example.backend.web.model;

import com.example.backend.model.*;

import java.util.List;

public class OrderRequest {
    public Order order;
    public List<OrderProductResult> products;
    public List<OrderFrameResult> frames;
    public List<Refund> refunds;
    public Address address;
}
