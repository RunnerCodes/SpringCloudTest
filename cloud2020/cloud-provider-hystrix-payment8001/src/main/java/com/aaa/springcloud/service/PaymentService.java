package com.aaa.springcloud.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class PaymentService {
    public String paymentInfo_OK(Integer id){
        return  "线程池  "+Thread.currentThread().getName()+" paymentInfo_OK,is  :"+id+"\t"+"哈哈";
    }

    public String paymentInfo_timeOut(Integer id){
        int timeout= 3;
        try {
            TimeUnit.SECONDS.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return  "线程池  "+Thread.currentThread().getName()+" paymentInfo_timeOut,is  :"+id+"\t"+"哈哈,耗时"+timeout;
    }
}
