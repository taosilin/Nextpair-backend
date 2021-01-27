package com.example.backend.service;

import com.example.backend.core.Service;
import com.example.backend.model.Frame;
import com.example.backend.web.model.FrameDetail;
import com.example.backend.web.model.ProductOverview;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface FrameService extends Service<Frame> {
    void addFrame(Frame f); // 管理员 添加镜框
    List<Frame> frameList(Integer page,Integer size); // 用户/管理员 镜框列表+好评数量 分页
    FrameDetail findByFrameID(String frameID); // 按ID查找镜框
    void updateFrame(Frame f); // 编辑镜框信息
    void deleteFrame(String frameID); // 按ID删除镜框
    ProductOverview frameOverview(); // 镜框商品概览
    Integer frameTotal(); // 查询镜框总数
    String saveImage(MultipartFile imageFile) throws Exception; // 上传镜框图片
    List<Frame> searchByFrameName(String searchString); // 按镜框名称搜索
    List<Frame> findByFrameClass(String state,String classification,Integer page,Integer size); // 用户前端 按分类筛选镜框
}
