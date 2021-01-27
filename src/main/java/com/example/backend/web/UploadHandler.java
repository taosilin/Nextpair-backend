package com.example.backend.web;

import com.example.backend.service.UploadService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.*;

@RestController
public class UploadHandler {
    private Logger logger = LoggerFactory.getLogger(UploadHandler.class);
    @Autowired
    private UploadService uploadService;

    @RequestMapping("/uploadimg")
    public String uploadimg(HttpServletRequest request) throws IOException, ServletException {
        // handler调用文件上传的service 得到文件的虚拟路径
        String filepath = uploadService.uploadImg(request);
        return filepath;
    }
}
