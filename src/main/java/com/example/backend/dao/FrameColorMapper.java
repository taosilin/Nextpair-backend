package com.example.backend.dao;

import com.example.backend.core.Mapper;
import com.example.backend.model.FrameColor;
import com.example.backend.web.model.FrameColorResult;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FrameColorMapper extends Mapper<FrameColor> {
    public void addFrameColor(FrameColor f);
    public void updateFrameColor(FrameColor f);
    public void deleteFrameColor(@Param("frameID")String frameID,@Param("colorID")Integer colorID);
    public void deleteByFrameID(@Param("frameID")String frameID);
    public List<FrameColorResult> findByFrameID(@Param("frameID")String frameID);
}
