package com.example.backend.dao;

import com.example.backend.core.Mapper;
import com.example.backend.model.Frame;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FrameMapper extends Mapper<Frame> {
    public void addFrame(Frame f); // 管理员 添加镜框
    public List<Frame> frameList(@Param("page")Integer page, @Param("size")Integer size); // 用户/管理员 镜框列表+好评数量 分页
    public Frame findByFrameID(@Param("frameID") String frameID); // 按ID查找镜框
    public void updateFrame(Frame f); // 编辑镜框信息
    public void deleteFrame(@Param("frameID")String frameID); // 按ID删除镜框
    public Integer frameNum(@Param("state")String state); // 按状态筛选镜框数量
    public Integer frameTotal(); // 查询镜框总数
    public List<Frame> searchByFrameName(@Param("searchString")String searchString); // 按镜框名称搜索
    public List<Frame> findByFrameClass(@Param("state")String state,@Param("classification")String classification,@Param("page")Integer page, @Param("size")Integer size); // 用户前端 按分类筛选镜框
}
