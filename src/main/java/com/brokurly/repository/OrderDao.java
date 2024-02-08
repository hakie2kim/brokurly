package com.brokurly.repository;

import com.brokurly.entity.Order;
import com.brokurly.entity.OrderAndPayment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderDao {
    // CREATE
    void insert(Order order);

    // READ
    List<Order> selectByCustId(String custId);
    List<OrderAndPayment> selectByCustIdWithJoin(String custId);

    // UPDATE

    // DELTE
}
