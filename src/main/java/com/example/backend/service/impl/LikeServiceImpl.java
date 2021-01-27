package com.example.backend.service.impl;

import com.example.backend.core.ServiceException;
import com.example.backend.dao.LikeMapper;
import com.example.backend.model.Frame;
import com.example.backend.model.Like;
import com.example.backend.model.Product;
import com.example.backend.service.LikeService;
import com.example.backend.core.AbstractService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@Service
@Transactional
public class LikeServiceImpl extends AbstractService<Like> implements LikeService{
    @Resource
    private LikeMapper likeMapper;

    public void addLike(Like l){
        likeMapper.addLike(l);
    }

    public void deleteLike(Like l){
        likeMapper.deleteLike(l);
    }

    public List<Product> likeList(String userID){
        return likeMapper.likeList(userID);
    }

    public List<Frame> likeFrameList(String userID){
        return likeMapper.likeFrameList(userID);
    }

    @Override
    public int findUserIsLike(String userID, String productID) {
        return likeMapper.findUserIsLike(userID,productID);
    }
}
