package com.example.backend.service;

import com.example.backend.core.Service;
import com.example.backend.model.Spec;
import com.example.backend.web.model.StockWarning;
import org.springframework.web.multipart.MultipartFile;

public interface SpecService extends Service<Spec> {
    void addSpec(Spec s);
    void deleteSpec(String specID);
    void updateSpec(Spec s);
    StockWarning stockWarning(); // 库存不足的商品SKU
    String saveImage(MultipartFile imageFile) throws Exception;
}
