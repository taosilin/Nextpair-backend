package com.example.backend.service.impl;

import com.example.backend.core.ServiceException;
import com.example.backend.dao.*;
import com.example.backend.model.Cart;
import com.example.backend.model.Spec;
import com.example.backend.service.CartService;
import com.example.backend.core.AbstractService;

import java.util.ArrayList;
import java.util.List;

import com.example.backend.web.model.UserCartResult;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@Service
@Transactional
public class CartServiceImpl extends AbstractService<Cart> implements CartService{
    @Resource
    private CartMapper cartMapper;
    @Resource
    private SpecMapper specMapper;
    @Resource
    private FrameMapper frameMapper;
    @Resource
    private ColorMapper colorMapper;
    @Resource
    private LensMapper lensMapper;

    public void addCart(Cart c){
        Cart cart = cartMapper.findCart(c);
        if (cart!=null){
            cart.setNum(cart.getNum()+1);
            cartMapper.updateCart(cart);
        }
        else {
            cartMapper.addCart(c);
        }
    }

    public void deleteCart(Cart c){
        cartMapper.deleteCart(c);
    }

    public void updateCart(Cart c){
        cartMapper.updateCart(c);
    }

    public List<UserCartResult> findByUserID(String userID){
        List<Cart> carts = cartMapper.findByUserID(userID);
        List<UserCartResult> userCartResults = new ArrayList<>();

        for (Cart c:carts){
            UserCartResult u = new UserCartResult();
            u.cart = c;
            u.frame = frameMapper.findByFrameID(c.getProductID());
            u.spec = specMapper.findBySpecID(c.getSpecID());
            u.color = colorMapper.findByColorID(Integer.parseInt(u.spec.getProductSpec()));
            u.lens = lensMapper.findByLensID(c.getLensID());
            userCartResults.add(u);
        }

        return userCartResults;
    }
}
