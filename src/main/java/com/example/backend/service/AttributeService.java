package com.example.backend.service;

import com.example.backend.core.Service;
import com.example.backend.model.Attribute;
import com.example.backend.model.Value;
import com.example.backend.web.model.ValueList;

import java.util.List;

public interface AttributeService extends Service<Attribute> {
    void addAttribute(Attribute a);
    List<ValueList> attributeDetail(Attribute a);
    public void deleteAttribute(String attributeID);
}
