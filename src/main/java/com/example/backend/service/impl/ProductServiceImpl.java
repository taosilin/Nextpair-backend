package com.example.backend.service.impl;

import com.example.backend.core.ServiceException;
import com.example.backend.dao.*;
import com.example.backend.model.Attribute;
import com.example.backend.model.Product;
import com.example.backend.service.ProductService;
import com.example.backend.core.AbstractService;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.example.backend.web.model.ProductDetail;
import com.example.backend.web.model.ProductOverview;
import com.example.backend.web.model.ValueList;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

@Service
@Transactional
public class ProductServiceImpl extends AbstractService<Product> implements ProductService{
    @Resource
    private ProductMapper productMapper;
    @Resource
    private AttributeMapper attributeMapper;
    @Resource
    private ValueMapper valueMapper;
    @Resource
    private SpecMapper specMapper;

    public void addProduct(Product p){
        productMapper.addProduct(p);
    }

    public ProductDetail productDetail(String productID){
        ProductDetail p = new ProductDetail();
        List<ValueList> valueLists = new ArrayList<>();
        p.specs=specMapper.specList(productID);
        p.product = productMapper.productDetail(productID);
        List<Attribute> attributes = attributeMapper.attributeList(productID);
        for (Attribute a:attributes){
            ValueList valueList = new ValueList();
            valueList.attribute = a;
            valueList.values = valueMapper.findByAttribute(a.getAttributeID());
            valueLists.add(valueList);
        }
        p.attributes = valueLists;
        return p;
    }

    public void updateProduct(Product p){
        productMapper.updateProduct(p);
    }

    public void deleteProduct(String productID){
        specMapper.deleteByProductID(productID);
        List<Attribute> attributes = attributeMapper.attributeList(productID);
        for (Attribute attribute:attributes){
            valueMapper.deleteByAttribute(attribute.getAttributeID());
            attributeMapper.deleteAttribute(attribute.getAttributeID());
        }
        productMapper.deleteProduct(productID);
    }

    public List<Product> productList(Integer page,Integer size){
        return productMapper.productList(page*size, size);
    }

    public ProductOverview productOverview(){
        ProductOverview p = new ProductOverview();
        p.pending = productMapper.productNum("0");
        p.onShelf = productMapper.productNum("1");
        p.offShelf = productMapper.productNum("2");
        p.total = productMapper.productTotal();
        return p;
    }

    public Integer productTotal(){
        return productMapper.productTotal();
    }

    public String saveImage(MultipartFile imageFile) throws Exception {
        String folder = "/root/public/product/";
        byte[] bytes = imageFile.getBytes();
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");//设置日期格式
        String date = df.format(new Date());// new Date()为获取当前系统时间，也可使用当前时间戳
        Path path = Paths.get(folder + date +imageFile.getOriginalFilename());
        Files.write(path,bytes);
        return date + imageFile.getOriginalFilename();
    }
}
