package com.example.backend.dao;

import com.example.backend.core.Mapper;
import com.example.backend.model.Coupon;
import com.example.backend.model.UserCoupon;
import com.example.backend.web.model.UserCouponResult;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserCouponMapper extends Mapper<UserCoupon> {
    public void getCoupon(UserCoupon u);
    public List<UserCouponResult> couponList(@Param("userID") String userID);
    public void updateCouponState(@Param("state")String state,@Param("userID")String userID,@Param("couponID")String couponID);
    public void couponExpired(@Param("userID")String userID);
}
