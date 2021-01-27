package com.example.backend.service;

import com.example.backend.core.Service;
import com.example.backend.model.Post;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface PostService extends Service<Post> {
    void addPost(Post p);
    String saveImage(MultipartFile imageFile) throws Exception;
    List<Post> postList();
}
