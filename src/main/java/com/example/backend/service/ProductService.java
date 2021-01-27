package com.example.backend.service;

import com.example.backend.core.Service;
import com.example.backend.model.Product;
import com.example.backend.web.model.ProductDetail;
import com.example.backend.web.model.ProductOverview;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProductService extends Service<Product> {
    void addProduct(Product p);
    ProductDetail productDetail(String productID);
    void updateProduct (Product p);
    void deleteProduct(String productID);
    List<Product> productList(Integer page,Integer size);
    ProductOverview productOverview();
    Integer productTotal();
    String saveImage(MultipartFile imageFile) throws Exception;
}
