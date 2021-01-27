package com.example.backend.service.impl;

import com.example.backend.core.ServiceException;
import com.example.backend.dao.AttributeMapper;
import com.example.backend.dao.ValueMapper;
import com.example.backend.model.Attribute;
import com.example.backend.model.Value;
import com.example.backend.service.AttributeService;
import com.example.backend.core.AbstractService;

import java.util.ArrayList;
import java.util.List;

import com.example.backend.web.model.ValueList;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@Service
@Transactional
public class AttributeServiceImpl extends AbstractService<Attribute> implements AttributeService{
    @Resource
    private AttributeMapper attributeMapper;
    @Resource
    private ValueMapper valueMapper;

    public void addAttribute(Attribute a){
        attributeMapper.addAttribute(a);
    }

    public List<ValueList> attributeDetail(Attribute a){
        List<Attribute> attributes = attributeMapper.attributeList(a.getProductID());
        List<ValueList> list = new ArrayList<>();
        for (Attribute attribute:attributes){
            ValueList valueList = new ValueList();
            valueList.attribute = attribute;
            valueList.values = valueMapper.findByAttribute(attribute.getAttributeID());
            list.add(valueList);
        }
        return list;
    }

    public void deleteAttribute(String attributeID){
        attributeMapper.deleteAttribute(attributeID);
        valueMapper.deleteByAttribute(attributeID);
    }
}
