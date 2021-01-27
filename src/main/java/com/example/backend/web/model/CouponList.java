package com.example.backend.web.model;

import com.example.backend.model.Coupon;

import java.util.ArrayList;
import java.util.List;

public class CouponList {
    public List<UserCouponResult> enabledCoupons = new ArrayList<>();
    public List<UserCouponResult> disabledCoupons = new ArrayList<>();
}
