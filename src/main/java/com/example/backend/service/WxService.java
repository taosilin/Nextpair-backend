package com.example.backend.service;

import com.example.backend.web.model.WXPayRequest;

import java.math.BigDecimal;
import java.util.Map;

public interface WxService {
    String payBack(String resXml);

    Map doUnifiedOrder(WXPayRequest wxPayRequest) throws Exception;
}
