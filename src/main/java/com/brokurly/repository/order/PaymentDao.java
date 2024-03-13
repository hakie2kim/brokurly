package com.brokurly.repository.order;

import com.brokurly.entity.payment.PaymentDetails;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PaymentDao {
    // CREATE
    void insert(PaymentDetails paymentDetails);

    // READ
    List<PaymentDetails> selectAll();

    PaymentDetails selectByOrderId(String orderId);

    // UPDATE

    // DELETE
}
