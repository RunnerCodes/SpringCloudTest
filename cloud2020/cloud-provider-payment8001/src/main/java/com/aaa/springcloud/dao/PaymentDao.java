package com.aaa.springcloud.dao;

import com.aaa.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author
 * @date 2020/9/26 0026 - 下午 6:03
 */
@Mapper
public interface PaymentDao {
    public int create(Payment payment);
    public Payment getPaymentById(@Param("id") Long id);
}
