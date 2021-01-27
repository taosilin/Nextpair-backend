package com.example.backend.web;

import com.example.backend.core.Result;
import com.example.backend.core.ResultGenerator;
import com.example.backend.model.Product;
import com.example.backend.model.User;
import com.example.backend.service.ProductService;
import com.example.backend.web.model.MyRequestBody;
import com.example.backend.web.model.ProductDetail;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Resource
    private ProductService productService;

    @PostMapping("/add")
    public Result addProduct(@RequestBody Product product) {
        Product p = productService.productDetail(product.getProductID()).product;
        if (p==null){
            productService.addProduct(product);
            return ResultGenerator.genSuccessResult();
        }
        else{
            return ResultGenerator.genFailResult("该商品ID已存在！");
        }
    }

    @PostMapping("/detail")
    public Result productDetail(@RequestBody Product product){
        ProductDetail p = productService.productDetail(product.getProductID());
        return ResultGenerator.genSuccessResult(p);
    }

    @PostMapping("/update")
    public Result updateProduct(@RequestBody Product product){
        productService.updateProduct(product);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result deleteProduct(@RequestBody Product product){
        productService.deleteProduct(product.getProductID());
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/list")
    public Result productList(@RequestBody MyRequestBody myRequestBody){
        List<Product> list = productService.productList(myRequestBody.page, myRequestBody.size);
        return ResultGenerator.genSuccessResult(list);
    }

    @PostMapping("/overview")
    public Result productOverview(){
        return ResultGenerator.genSuccessResult(productService.productOverview());
    }

    @PostMapping("/total")
    public Integer productTotal(){
        return productService.productTotal();
    }

    @PostMapping("/uploadImage")
    public String uploadImage(@RequestParam("imageFile") MultipartFile imageFile) {
        String returnValue = "start";
        try {
            String fileName = productService.saveImage(imageFile);
            returnValue = "https://from2121.com/pictures/product/"+ fileName;
        } catch (Exception e) {
            e.printStackTrace();
            returnValue = "error";
        }
        return returnValue;
    }
}
