package com.example.backend.service.impl;

import com.example.backend.core.ServiceException;
import com.example.backend.dao.PostMapper;
import com.example.backend.model.Post;
import com.example.backend.service.PostService;
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
public class PostServiceImpl extends AbstractService<Post> implements PostService{
    @Resource
    public PostMapper postMapper;

    public void addPost(Post p){
        postMapper.addPost(p);
    }

    public String saveImage(MultipartFile imageFile) throws Exception {
        String folder = "/root/public/post/";
        byte[] bytes = imageFile.getBytes();
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");//设置日期格式
        String date = df.format(new Date());// new Date()为获取当前系统时间，也可使用当前时间戳
        Path path = Paths.get(folder + date +imageFile.getOriginalFilename());
        Files.write(path,bytes);
        return date + imageFile.getOriginalFilename();
    }

    public List<Post> postList(){
        return postMapper.postList();
    }
}
