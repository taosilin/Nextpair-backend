package com.example.backend.service.impl;

import com.example.backend.core.ServiceException;
import com.example.backend.dao.UserMapper;
import com.example.backend.model.User;
import com.example.backend.service.UserService;
import com.example.backend.core.AbstractService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@Service
@Transactional
public class UserServiceImpl extends AbstractService<User> implements UserService {
    @Resource
    private UserMapper userMapper;

    public User findByUserID(String userID)
    {
        return userMapper.findByUserID(userID);
    }

    public void addUser(User u)
    {
        u.setRegistrationTime(new Date());
        userMapper.addUser(u);
    }
}
