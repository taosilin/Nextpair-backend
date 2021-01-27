package com.example.backend.kuaidi100Utils;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * 　　* @description: 签名工具类
 * 　　* @param ${tags}
 * 　　* @return ${return_type}
 * 　　* @throws
 * 　　* @author liutao
 * 　　* @date 2020/12/21 17:47
 *
 */
public class SignUtils {

    /**
     * 快递100加密方式统一为MD5后转大写
     *
     * @param msg
     * @return
     */
    public static String sign(String msg) {
        return DigestUtils.md5Hex(msg).toUpperCase();
    }

    /**
     * 查询加密
     * @param param
     * @param key
     * @param customer
     * @return
     */
    public static String querySign(String param,String key,String customer){
        return sign(param+key+customer);
    }

}
