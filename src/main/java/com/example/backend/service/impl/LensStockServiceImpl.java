package com.example.backend.service.impl;

import com.example.backend.core.ServiceException;
import com.example.backend.dao.LensStockMapper;
import com.example.backend.model.LensStock;
import com.example.backend.service.LensStockService;
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
public class LensStockServiceImpl extends AbstractService<LensStock> implements LensStockService{
    @Resource
    private LensStockMapper lensStockMapper;

    public void addLensStock(LensStock l){
        lensStockMapper.addLensStock(l);
    }

    public void updateLensStock(LensStock l){
        lensStockMapper.updateLensStock(l);
    }

    public void deleteLensStock(String stockID){
        lensStockMapper.deleteLensStock(stockID);
    }

    public List<LensStock> stockList(String lensID,Integer page,Integer size){
        return lensStockMapper.stockList(lensID,page*size,size);
    }

    public List<List<Integer>> cylFilter(String lensID){
        List<List<Integer>> result = new ArrayList<>();
        Integer i;
        for (i=0;i>=-600;i=i-25){
            List<Integer> list = lensStockMapper.cylFilter(lensID, i.doubleValue()/100);
            result.add(list);
        }
        return result;
    }

    public Integer lensStockTotal(String lensID){
        return lensStockMapper.lensStockTotal(lensID);
    }
}
