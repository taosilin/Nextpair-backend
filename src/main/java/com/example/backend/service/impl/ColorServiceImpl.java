package com.example.backend.service.impl;

import com.example.backend.core.ServiceException;
import com.example.backend.dao.ColorMapper;
import com.example.backend.model.Color;
import com.example.backend.service.ColorService;
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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class ColorServiceImpl extends AbstractService<Color> implements ColorService{
    @Resource
    private ColorMapper colorMapper;

    public void addColor(Color c){
        colorMapper.addColor(c);
    }

    public List<Color> colorList(Integer page,Integer size){
        return colorMapper.colorList(page*size, size);
    }

    public void updateColor(Color c){
        colorMapper.updateColor(c);
    }

    public void deleteColor(Integer colorID){
        colorMapper.deleteColor(colorID);
    }

    public Integer colorTotal(){
        return colorMapper.colorTotal();
    }

    public String saveImage(MultipartFile imageFile) throws Exception {
        String folder = "/root/public/color/";
        byte[] bytes = imageFile.getBytes();
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");//设置日期格式
        String date = df.format(new Date());// new Date()为获取当前系统时间，也可使用当前时间戳
        Path path = Paths.get(folder + date +imageFile.getOriginalFilename());
        Files.write(path,bytes);
        return date + imageFile.getOriginalFilename();
    }
}
