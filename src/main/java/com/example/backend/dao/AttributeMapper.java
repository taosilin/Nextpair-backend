package com.example.backend.dao;

import com.example.backend.core.Mapper;
import com.example.backend.model.Attribute;
import com.example.backend.model.Value;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AttributeMapper extends Mapper<Attribute> {
    public void addAttribute(Attribute a); // 添加属性
    public List<Attribute> attributeList(@Param("productID") String productID); // 查询某一商品全部属性
    public void deleteAttribute(@Param("attributeID")String attributeID); // 根据attributeID删除
    public void deleteByProduct(@Param("productID")String productID); // 删除某一商品全部attribute （可能改？？？）
}
