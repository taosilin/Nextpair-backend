package com.example.backend.dao;

import com.example.backend.core.Mapper;
import com.example.backend.model.Post;

import java.util.List;

public interface PostMapper extends Mapper<Post> {
    public void addPost(Post p);
    public List<Post> postList();
}
