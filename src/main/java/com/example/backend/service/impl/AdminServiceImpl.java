package com.example.backend.service.impl;

import com.example.backend.core.ServiceException;
import com.example.backend.dao.AdminMapper;
import com.example.backend.model.Admin;
import com.example.backend.service.AdminService;
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
public class AdminServiceImpl extends AbstractService<Admin> implements AdminService{
    @Resource
    private AdminMapper adminMapper;

    public Admin adminLogin(String adminID){
        return adminMapper.adminLogin(adminID);
    }

    public List<Admin> adminList(Integer page,Integer size){
        return adminMapper.adminList(page*size, size);
    }

    public void addAdmin(Admin a){
        adminMapper.addAdmin(a);
    }

    public void deleteAdmin(String adminID){
        adminMapper.deleteAdmin(adminID);
    }

    public Admin findByAdminID(String adminID){
        return adminMapper.findByAdminID(adminID);
    }

    public Integer adminTotal(){
        return adminMapper.adminTotal();
    }
}
