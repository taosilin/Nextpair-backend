package com.example.backend.service.impl;

import com.example.backend.core.ServiceException;
import com.example.backend.dao.RefundMapper;
import com.example.backend.model.Refund;
import com.example.backend.service.RefundService;
import com.example.backend.core.AbstractService;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
@Transactional
public class RefundServiceImpl extends AbstractService<Refund> implements RefundService{
    @Resource
    private RefundMapper refundMapper;

    public void addRefund(Refund r) {
        refundMapper.addRefund(r);
    }

    public List<Refund> refundList(Integer page,Integer size){
        return refundMapper.refundList(page*size, size);
    }

    public Integer refundTotal(){
        return refundMapper.refundTotal();
    }

    public String saveImage(MultipartFile imageFile) throws Exception {
        String folder = "/root/public/refund/";
        byte[] bytes = imageFile.getBytes();
        //SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");//设置日期格式
        //String date = df.format(new Date());// new Date()为获取当前系统时间，也可使用当前时间戳
        //Path path = Paths.get(folder + date +imageFile.getOriginalFilename());
        Path path = Paths.get(folder +imageFile.getOriginalFilename());
        Files.write(path,bytes);
        return imageFile.getOriginalFilename();
    }
}
