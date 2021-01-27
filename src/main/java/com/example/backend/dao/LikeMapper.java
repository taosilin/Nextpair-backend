package com.example.backend.dao;

import com.example.backend.core.Mapper;
import com.example.backend.model.Frame;
import com.example.backend.model.Like;
import com.example.backend.model.Product;
import org.apache.ibatis.annotations.Param;
import java.util.List;
public interface LikeMapper extends Mapper<Like>{
    public void addLike(Like l);
    public void deleteLike(Like l);
    public List<Product> likeList(String userID);
    public List<Frame> likeFrameList(String userID);

    public int findUserIsLike(@Param("userID")String userID,@Param("productID")String productID);
}
