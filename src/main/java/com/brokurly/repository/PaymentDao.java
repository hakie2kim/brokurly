package com.brokurly.repository;

import com.brokurly.domain.Payment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PaymentDao {
    // CREATE
    void insert(Payment payment);

    // READ
    List<Payment> selectAll();

    // UPDATE

    // DELETE
}
