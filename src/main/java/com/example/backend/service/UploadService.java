package com.example.backend.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class UploadService {
    private Logger logger = LoggerFactory.getLogger(UploadService.class);
    // 文件的真实路径
    @Value("${file.uploadFolder}")
    private String realBasePath;
    @Value("${file.accessPath}")
    private String accessPath;

    public String uploadImg(HttpServletRequest request) throws IOException, ServletException {
        InputStream inputStream = request.getInputStream();
        // 获取请求头中Contect-Type的值
        // 图片后缀
        String imgSuffix = "png";
        Enumeration enumeration=request.getHeaderNames();
        while(enumeration.hasMoreElements()) {
            String name=(String)enumeration.nextElement();
            if(name.equals("content-type")){
                String value=request.getHeader(name);
                imgSuffix = value.split("/")[1];
                logger.info("header中" + name + " " + value);
                logger.info("文件后缀：" + imgSuffix);
            }
        }
        // 文件唯一的名字
        String fileName = UUID.randomUUID().toString() + "." +imgSuffix;
        Date todayDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String today = dateFormat.format(todayDate);
        // 域名访问的相对路径（通过浏览器访问的链接-虚拟路径）
        String saveToPath = accessPath + today + "/";
        // 真实路径，实际储存的路径
        String realPath = realBasePath + today + "/";
        // 储存文件的物理路径，使用本地路径储存
        String filepath = realPath + fileName;
        logger.info("上传图片名为：" + fileName+"  虚拟文件路径为：" + saveToPath +"  物理文件路径为：" + realPath);
        // 判断有没有对应的文件夹
        File destFile = new File(filepath);
        if (!destFile.getParentFile().exists()) {
            destFile.getParentFile().mkdirs();
        }
        // 输出流 输出到文件
        OutputStream outputStream = new FileOutputStream(destFile);
        // 缓冲区
        byte[] bs = new byte[1024];
        int len = -1;
        while ((len = inputStream.read(bs)) != -1) {
            outputStream.write(bs,0,len);
        }
        inputStream.close();
        outputStream.close();
        // 返回虚拟路径，给链接访问
        return saveToPath+fileName;
    }
}
