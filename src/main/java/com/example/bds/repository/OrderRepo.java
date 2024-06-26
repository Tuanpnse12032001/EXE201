package com.example.bds.repository;

import com.example.bds.model.Order;
import com.example.bds.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.time.LocalDateTime;

import java.util.List;
import java.util.Optional;

public interface OrderRepo extends JpaRepository<Order,Integer> {
    @Query("SELECT o FROM Order o WHERE o.orderDate BETWEEN :fromDate AND :toDate")
    List<Order> findByOrderDateBetween(LocalDateTime fromDate, LocalDateTime toDate);
    Optional<Order> findOrderByOrderId(int orderId);
//    Optional<Order> findOrderByAudience(User audience);

    List<Order> findOrderByAudience(User audience);

}
