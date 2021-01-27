package com.example.backend.dao;

import com.example.backend.core.Mapper;
import com.example.backend.model.Coupon;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CouponMapper extends Mapper<Coupon>{
    public void addCoupon(Coupon c);
    public Coupon findByCouponID(@Param("couponID") String couponID);
    public List<Coupon> couponList(@Param("page")Integer page,@Param("size")Integer size);
    public void deleteCoupon(@Param("couponID")String couponID);
    public Integer couponTotal();
    public Coupon findByCouponCode(@Param("couponCode")String couponCode);
    public void updateCouponNum(@Param("couponID")String couponID);
}
