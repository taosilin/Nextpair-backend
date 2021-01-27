package com.example.backend.service;

import com.example.backend.core.Service;
import com.example.backend.model.Frame;
import com.example.backend.model.Like;
import com.example.backend.model.Product;

import java.util.List;

public interface LikeService extends Service<Like>{
    void addLike(Like l);
    void deleteLike(Like l);
    List<Product> likeList(String userID);
    List<Frame> likeFrameList(String userID);

    public int findUserIsLike(String userID,String productID);
}
