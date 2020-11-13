package com.aaa.springcloud.controller;

import com.aaa.springcloud.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
@DefaultProperties(defaultFallback = "payment_Global_FailbackMethod")
public class OrderHystrixController {
    @Resource
    private PaymentHystrixService paymentHystrixService;

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id){
        String result = paymentHystrixService.paymentInfo_OK(id);
        return result;
    }

    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
    /*@HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler",commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="3000")
    })*/
    @HystrixCommand
    public String paymentInfo_timeOut(@PathVariable("id") Integer id){
        String result = paymentHystrixService.paymentInfo_timeOut(id);
        return result;
    }

    public String paymentInfo_TimeOutHandler(@PathVariable("id") Integer id){

        return  "我是消费者80,对方支付系统繁忙,请10秒钟后再试或者自己运行出错请检查自己...........";
    }

    public String payment_Global_FailbackMethod(){
        return "olobal异常处理信息,请稍后再试.";
    }




}
