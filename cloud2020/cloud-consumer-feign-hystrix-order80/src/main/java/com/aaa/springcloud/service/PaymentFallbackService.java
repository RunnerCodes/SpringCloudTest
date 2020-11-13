package com.aaa.springcloud.service;

import org.springframework.stereotype.Component;

@Component
public class PaymentFallbackService implements PaymentHystrixService{
    @Override
    public String paymentInfo_OK(Integer id) {
        return "------PaymentFallbackService  fall back-paymentInfo_ok----";
    }

    @Override
    public String paymentInfo_timeOut(Integer id) {
        return "-------PaymentFallbackService  fall back-paymentInfo_timeOut";
    }
}
