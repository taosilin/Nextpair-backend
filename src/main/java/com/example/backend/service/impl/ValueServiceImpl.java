package com.example.backend.service.impl;

import com.example.backend.core.ServiceException;
import com.example.backend.dao.ValueMapper;
import com.example.backend.model.Value;
import com.example.backend.service.ValueService;
import com.example.backend.core.AbstractService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@Service
@Transactional
public class ValueServiceImpl extends AbstractService<Value> implements ValueService{
    @Resource
    private ValueMapper valueMapper;

    public void addValue(Value v){
        valueMapper.addValue(v);
    }

    public List<Value> findByAttribute(String attributeID){
        return valueMapper.findByAttribute(attributeID);
    }

    public void deleteValue(String valueID){
        valueMapper.deleteValue(valueID);
    }
}
