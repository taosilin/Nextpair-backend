package com.example.backend.service.impl;

import com.example.backend.core.ServiceException;
import com.example.backend.dao.CouponMapper;
import com.example.backend.model.Coupon;
import com.example.backend.service.CouponService;
import com.example.backend.core.AbstractService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@Service
@Transactional
public class CouponServiceImpl extends AbstractService<Coupon> implements CouponService{
    @Resource
    private CouponMapper couponMapper;

    public void addCoupon(Coupon c){
        couponMapper.addCoupon(c);
    }

    public Coupon findByCouponID(String couponID){
        return couponMapper.findByCouponID(couponID);
    }

    public List<Coupon> couponList(Integer page,Integer size){
        return couponMapper.couponList(page*size, size);
    }

    public void deleteCoupon(String couponID){
        couponMapper.deleteCoupon(couponID);
    }

    public Integer couponTotal(){
        return couponMapper.couponTotal();
    }
}
