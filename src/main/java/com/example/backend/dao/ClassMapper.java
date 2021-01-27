package com.example.backend.dao;

import com.example.backend.core.Mapper;
import com.example.backend.model.Class;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ClassMapper extends Mapper<Class> {
    public void addClass(Class c);
    public void updateClass(Class c);
    public void deleteClass(@Param("classID")Integer classID);
    public List<Class> classList(@Param("page")Integer page,@Param("size") Integer size);
    public List<Class> findBySuperior(@Param("superior")Integer superior);
    public Integer classTotal();
}
