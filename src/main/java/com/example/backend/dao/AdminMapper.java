package com.example.backend.dao;

import com.example.backend.core.Mapper;
import com.example.backend.model.Admin;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminMapper extends Mapper<Admin>{
    public Admin adminLogin(@Param("adminID")String adminID); // 管理员登录
    public List<Admin> adminList(@Param("page")Integer page,@Param("size")Integer size);
    public void addAdmin(Admin a);
    public void deleteAdmin(@Param("adminID") String adminID);
    public Admin findByAdminID(@Param("adminID") String adminID); // 按ID查找管理员
    public Integer adminTotal();
}
