package com.example.backend.web;

import com.example.backend.core.Result;
import com.example.backend.core.ResultGenerator;
import com.example.backend.model.Coupon;
import com.example.backend.service.CouponService;
import com.example.backend.web.model.MyRequestBody;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/coupon")
public class CouponController {
    @Resource
    private CouponService couponService;

    @PostMapping("/add")
    public Result addCoupon(@RequestBody Coupon coupon){
        couponService.addCoupon(coupon);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result findByCouponID(@RequestBody Coupon c){
        Coupon coupon = couponService.findByCouponID(c.getCouponID());
        return ResultGenerator.genSuccessResult(coupon);
    }

    @PostMapping("/list")
    public Result couponList(@RequestBody MyRequestBody myRequestBody){
        List<Coupon> list = couponService.couponList(myRequestBody.page, myRequestBody.size);
        return ResultGenerator.genSuccessResult(list);
    }

    @PostMapping("/delete")
    public Result deleteCoupon(@RequestBody Coupon coupon){
        couponService.deleteCoupon(coupon.getCouponID());
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/total")
    public Integer couponTotal(){
        return couponService.couponTotal();
    }
}
