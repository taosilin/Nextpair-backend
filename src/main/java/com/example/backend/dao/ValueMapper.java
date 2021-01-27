package com.example.backend.dao;

import com.example.backend.core.Mapper;
import com.example.backend.model.Value;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ValueMapper extends Mapper<Value> {
    public void addValue(Value v); // 添加value
    public List<Value> findByAttribute(@Param("attributeID") String attributeID); // 查找某一属性全部value
    public void deleteValue(@Param("valueID")String valueID); // 根据valueID删除
    public void deleteByAttribute(@Param("attributeID")String attributeID); // 删除某一属性的全部value
}
