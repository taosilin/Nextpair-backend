package com.example.backend.dao;

import com.example.backend.core.Mapper;
import com.example.backend.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper extends Mapper<User>{
    public User findByUserID(@Param("userID") String userID);
    public void addUser(User u);
}
