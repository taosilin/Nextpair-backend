package com.example.backend.dao;

import com.example.backend.core.Mapper;
import com.example.backend.model.Lens;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LensMapper extends Mapper<Lens> {
    public void addLens(Lens l);
    public List<Lens> lensList(@Param("page")Integer page,@Param("size")Integer size);
    public void updateLens(Lens l);
    public void deleteLens(@Param("lensID")String lensID);
    public Lens findByLensID(@Param("lensID")String lensID);
    public Integer lensTotal();
}
