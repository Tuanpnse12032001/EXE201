package com.example.bds.repository;

import com.example.bds.model.Order;
import com.example.bds.model.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderDetailRepo extends JpaRepository<OrderDetail,Integer> {
    List<OrderDetail> findByOrder_OrderId(int orderId);
    List<OrderDetail> findOrderDetailByOrder(Order order);
}
