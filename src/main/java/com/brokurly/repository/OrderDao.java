package com.brokurly.repository;

import com.brokurly.domain.Order;
import com.brokurly.domain.OrderAndPayment;
import org.apache.ibatis.annotations.Mapper;

import java.sql.SQLException;
import java.util.List;

@Mapper
public interface OrderDao {
    // CREATE
    void insert(Order order);

    // READ
    List<Order> selectByCustId(String custId);
    List<OrderAndPayment> selectByCustIdWithJoin(String custId);

    List<Order> selectByOrderId(String orderId);

    // UPDATE

    // DELTE
}