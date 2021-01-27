package com.example.backend.service;

import com.example.backend.core.Service;
import com.example.backend.model.Refund;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface RefundService extends Service<Refund> {
    void addRefund(Refund r);
    List<Refund> refundList(Integer page,Integer size);
    Integer refundTotal();
    String saveImage(MultipartFile imageFile) throws Exception;
}
