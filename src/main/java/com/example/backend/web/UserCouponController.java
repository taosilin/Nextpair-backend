package com.example.backend.web;

import com.example.backend.core.Result;
import com.example.backend.core.ResultGenerator;
import com.example.backend.model.Coupon;
import com.example.backend.model.UserCoupon;
import com.example.backend.service.UserCouponService;
import com.example.backend.web.model.CouponList;
import com.example.backend.web.model.MyRequestBody;
import com.example.backend.web.model.UserCouponRequest;
import com.example.backend.web.model.UserCouponResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/usercoupon")
public class UserCouponController {
    @Resource
    private UserCouponService userCouponService;

    @PostMapping("/add")
    public Result getCoupon(@RequestBody UserCoupon userCoupon){
        userCouponService.getCoupon(userCoupon);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/list")
    public Result couponList(@RequestBody UserCoupon userCoupon){
        List<UserCouponResult> list = userCouponService.couponList(userCoupon.getUserID());
        return ResultGenerator.genSuccessResult(list);
    }

    // 查询可用与不可用优惠券
    @PostMapping("/enable")
    public Result enabledCoupons(@RequestBody UserCouponRequest userCouponRequest){
        CouponList couponList = userCouponService.enabledCoupons(userCouponRequest.userID, userCouponRequest.totalAmount);
        return ResultGenerator.genSuccessResult(couponList);
    }

    // 用户根据优惠券码兑换优惠券
    @PostMapping("/getByCouponCode")
    public Result getByCouponCode(@RequestBody MyRequestBody myRequestBody){
        if (userCouponService.getByCouponCode(myRequestBody.userID, myRequestBody.sortedBy)){
            return ResultGenerator.genSuccessResult("领取成功！");
        }
        else{
            return ResultGenerator.genFailResult("优惠券码不正确");
        }
    }
}
