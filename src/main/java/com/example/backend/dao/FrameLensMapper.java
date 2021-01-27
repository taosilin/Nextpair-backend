package com.example.backend.dao;

import com.example.backend.core.Mapper;
import com.example.backend.model.FrameLens;
import com.example.backend.model.Lens;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FrameLensMapper extends Mapper<FrameLens> {
    public void addFrameLens(FrameLens f);
    public List<Lens> lensList(@Param("frameID")String frameID);

    public List<Lens> enabledLens(@Param("frameID")String frameID); //用户可选镜片前端显示

    public void deleteFrameLens(FrameLens f);
    public void deleteByFrameID(@Param("frameID")String frameID);
    public void deleteByLensID(@Param("lensID")String lensID);
}
