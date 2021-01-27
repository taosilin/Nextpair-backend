package com.example.backend.dao;

import com.example.backend.core.Mapper;
import com.example.backend.model.Spec;
import com.example.backend.web.model.FrameColorResult;
import org.apache.ibatis.annotations.Param;

import java.util.List;
public interface SpecMapper extends Mapper<Spec> {
    public void addSpec(Spec s);
    public List<Spec> specList(@Param("productID") String productID);
    public void deleteSpec(@Param("specID")String specID);
    public void deleteByProductID(@Param("productID")String productID);
    public void updateSpec(Spec s);
    public List<Spec> productWarning(); // 查询库存不足的商品SKU
    public Spec findBySpecID(@Param("specID")String specID);
    public FrameColorResult findFrameSpec(@Param("specID")String specID);
}
