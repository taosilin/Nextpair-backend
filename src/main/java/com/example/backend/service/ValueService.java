package com.example.backend.service;

import com.example.backend.core.Service;
import com.example.backend.model.Value;

import java.util.List;

public interface ValueService extends Service<Value> {
    void addValue(Value v);
    List<Value> findByAttribute(String attributeID);
    void deleteValue(String valueID);
}
