package com.example.backend.dao;

import com.example.backend.core.Mapper;
import com.example.backend.model.Cart;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface CartMapper extends Mapper<Cart>{
    public void addCart(Cart c);
    public void deleteCart(Cart c);
    public void updateCart(Cart c);
    public List<Cart> findByUserID(@Param("userID")String userID);
    public Cart findCart(Cart c);
}
