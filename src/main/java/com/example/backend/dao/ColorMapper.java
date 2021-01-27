package com.example.backend.dao;

import com.example.backend.core.Mapper;
import com.example.backend.model.Color;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ColorMapper extends Mapper<Color> {
    public void addColor(Color c);
    public List<Color> colorList(@Param("page")Integer page,@Param("size")Integer size);
    public void updateColor(Color c);
    public void deleteColor(@Param("colorID")Integer colorID);
    public Integer colorTotal();
    public Color findByColorID(@Param("colorID")Integer colorID);
}
