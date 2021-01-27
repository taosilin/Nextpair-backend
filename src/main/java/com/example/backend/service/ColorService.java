package com.example.backend.service;

import com.example.backend.core.Service;
import com.example.backend.model.Color;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ColorService extends Service<Color> {
    void addColor(Color c);
    List<Color> colorList(Integer page,Integer size);
    void updateColor(Color c);
    void deleteColor(Integer colorID);
    Integer colorTotal();
    String saveImage(MultipartFile imageFile) throws Exception;
}
