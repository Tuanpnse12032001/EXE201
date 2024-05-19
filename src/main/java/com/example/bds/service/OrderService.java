package com.example.bds.service;

import com.example.bds.Request.OrderRequest.CreateOrderRequest;
import com.example.bds.Response.OrderResponse.CreateOrderResponse;
import com.example.bds.Response.OrderResponse.OrderResponse;
import com.example.bds.model.Order;
import com.example.bds.model.User;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.List;

public interface OrderService {
    ResponseEntity<OrderResponse> getAll();
    ResponseEntity<OrderResponse> deleteOrder(int orderId);
    ResponseEntity<OrderResponse> searchOrders(LocalDate fromDate, LocalDate toDate);
    public CreateOrderResponse createOrder(CreateOrderRequest request);
    List<Order> getOrdersByAudience(User audience);
}
