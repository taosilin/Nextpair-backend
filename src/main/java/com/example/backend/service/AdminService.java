package com.example.backend.service;

import com.example.backend.core.Service;
import com.example.backend.model.Admin;

import java.util.List;

public interface AdminService extends Service<Admin> {
    Admin adminLogin(String adminID);
    List<Admin> adminList(Integer page,Integer size);
    void addAdmin(Admin a);
    void deleteAdmin(String adminID);
    Admin findByAdminID(String adminID);
    Integer adminTotal();
}
