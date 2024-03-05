package com.brokurly.repository.order;

import com.brokurly.entity.order.Order;
import com.brokurly.entity.order.OrderAndPayment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderDao {
    // CREATE
    int insert(Order order);

    // READ
    List<Order> selectByCustId(String custId);
    List<OrderAndPayment> selectByCustIdWithJoin(String custId);
    List<Order> selectByOrderId(String orderId);

    // UPDATE

    // DELTE
    int deleteById(String orderId);
}
