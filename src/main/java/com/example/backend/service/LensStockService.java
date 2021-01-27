package com.example.backend.service;

import com.example.backend.core.Service;
import com.example.backend.model.LensStock;

import java.util.List;

public interface LensStockService extends Service<LensStock> {
    void addLensStock(LensStock l);
    void updateLensStock(LensStock l);
    void deleteLensStock(String stockID);
    List<LensStock> stockList(String lensID,Integer page,Integer size);
    List<List<Integer>> cylFilter(String lensID);
    Integer lensStockTotal(String lensID);
}
