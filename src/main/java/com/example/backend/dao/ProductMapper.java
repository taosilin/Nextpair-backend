package com.example.backend.dao;

import com.example.backend.core.Mapper;
import com.example.backend.model.Product;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductMapper extends Mapper<Product> {
    public void addProduct(Product p);
    public Product productDetail(@Param("productID") String productID);
    public void updateProduct(Product p);
    public void deleteProduct(@Param("productID")String productID);
    public List<Product> productList(@Param("page")Integer page,@Param("size")Integer size);
    public Integer productNum(@Param("state")String state);
    public Integer productTotal();
}
