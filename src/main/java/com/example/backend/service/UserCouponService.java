package com.example.backend.service;

import com.example.backend.core.Service;
import com.example.backend.model.Coupon;
import com.example.backend.model.UserCoupon;
import com.example.backend.web.model.CouponList;
import com.example.backend.web.model.UserCouponResult;

import java.util.List;

public interface UserCouponService extends Service<UserCoupon> {
    void getCoupon(UserCoupon u);
    List<UserCouponResult> couponList(String userID);
    CouponList enabledCoupons(String userID,Double totalAmount);
    boolean getByCouponCode(String userID,String couponCode);
}
