package com.example.backend.service;

import com.example.backend.core.Service;
import com.example.backend.model.User;

public interface UserService extends Service<User> {
    User findByUserID(String userID);
    void addUser(User u);
}
