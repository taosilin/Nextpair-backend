package com.example.backend.service.impl;

import com.example.backend.core.ServiceException;
import com.example.backend.core.AbstractService;
import com.example.backend.dao.CouponMapper;
import com.example.backend.dao.UserCouponMapper;
import com.example.backend.model.Coupon;
import com.example.backend.model.UserCoupon;
import com.example.backend.service.UserCouponService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.example.backend.web.model.CouponList;
import com.example.backend.web.model.UserCouponResult;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import javax.annotation.Resource;

@Service
@Transactional
public class UserCouponServiceImpl extends AbstractService<UserCoupon> implements UserCouponService {
    @Resource
    private UserCouponMapper userCouponMapper;
    @Resource
    private CouponMapper couponMapper;

    public void getCoupon(UserCoupon u){
        Coupon coupon = couponMapper.findByCouponID(u.getCouponID());
        u.setReceiveTime(new Date());
        u.setState(1);


        Calendar ca = Calendar.getInstance();
        ca.setTime(new Date());// 获取的是当天的日期，可以自己获取需要计算的时间，传进来就可以，需要注意的是日期类型。
        ca.add(ca.DATE, coupon.getTimeLimit());
        u.setDeadline(ca.getTime());

        userCouponMapper.getCoupon(u);

    }

    public List<UserCouponResult> couponList(String userID){
        userCouponMapper.couponExpired(userID);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");// 格式化时间
        List<UserCouponResult> couponList = userCouponMapper.couponList(userID);
        List<UserCouponResult> resultList = new ArrayList<>();
        for (UserCouponResult u:couponList){
            try{
                u.receiveTime = sdf.parse(sdf.format(u.receiveTime));
                u.deadline = sdf.parse(sdf.format(u.deadline));
                resultList.add(u);
            }catch(ParseException e){
                e.printStackTrace();
            }

        }
        return resultList;
        //return userCouponMapper.couponList(userID);
    }

    public CouponList enabledCoupons(String userID,Double totalAmount){
        userCouponMapper.couponExpired(userID);
        CouponList couponList = new CouponList();
        List<UserCouponResult> coupons = userCouponMapper.couponList(userID);
        for (UserCouponResult c:coupons){
            if (totalAmount>=c.restriction){
                couponList.enabledCoupons.add(c);
            }
            else {
                couponList.disabledCoupons.add(c);
            }
        }
        return couponList;
    }

    public boolean getByCouponCode(String userID,String couponCode){
        Coupon coupon = couponMapper.findByCouponCode(couponCode);
        if (coupon!=null&&coupon.getRemain()>0){
            UserCoupon u = new UserCoupon();
            u.setUserID(userID);
            u.setCouponID(coupon.getCouponID());
            u.setReceiveTime(new Date());
            u.setState(1);
            Calendar ca = Calendar.getInstance();
            ca.setTime(new Date());// 获取的是当天的日期，可以自己获取需要计算的时间，传进来就可以，需要注意的是日期类型。
            ca.add(ca.DATE, coupon.getTimeLimit());
            u.setDeadline(ca.getTime());
            userCouponMapper.getCoupon(u);
            couponMapper.updateCouponNum(coupon.getCouponID());
            return true;
        }
        else{
            return false;
        }
    }
}
