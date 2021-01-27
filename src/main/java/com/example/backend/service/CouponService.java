package com.example.backend.service;

import com.example.backend.core.Service;
import com.example.backend.model.Coupon;

import java.util.List;

public interface CouponService extends Service<Coupon> {
    void addCoupon(Coupon c);
    Coupon findByCouponID(String couponID);
    List<Coupon> couponList(Integer page,Integer size);
    void deleteCoupon(String couponID);
    Integer couponTotal();
}
