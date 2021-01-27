package com.example.backend.web.model;

import com.example.backend.model.Product;
import com.example.backend.model.Spec;

import java.util.List;
public class ProductDetail {
    public Product product;
    public List<ValueList> attributes;
    public List<Spec> specs;
}
