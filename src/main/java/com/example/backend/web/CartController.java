package com.example.backend.web;

import com.example.backend.core.Result;
import com.example.backend.core.ResultGenerator;
import com.example.backend.model.Cart;
import com.example.backend.service.CartService;
import com.example.backend.web.model.MyRequestBody;
import com.example.backend.web.model.UserCartResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {
    @Resource
    private CartService cartService;

    @PostMapping("/add")
    public Result addCart(@RequestBody Cart cart){
        cartService.addCart(cart);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result deleteCart(@RequestBody Cart cart){
        cartService.deleteCart(cart);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result updateCart(@RequestBody Cart cart){
        cartService.updateCart(cart);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/user")
    public Result findByUserID(@RequestBody Cart cart){
        List<UserCartResult> list = cartService.findByUserID(cart.getUserID());
        return ResultGenerator.genSuccessResult(list);
    }
}
