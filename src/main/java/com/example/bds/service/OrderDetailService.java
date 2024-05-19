package com.example.bds.service;

import com.example.bds.Request.OrderDetailRequest.CreateOrderDetailRequest;
import com.example.bds.Response.OrderDetailResponse.CreateOrderDetailResponse;
import com.example.bds.Response.OrderDetailResponse.OrderDetailResponse;
import com.example.bds.model.OrderDetail;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface OrderDetailService {
    ResponseEntity<OrderDetailResponse> getAllOrderDetails(int orderID);
    CreateOrderDetailResponse createOrderDetail(CreateOrderDetailRequest request);
    List<OrderDetail> getOrderDetailsByOrderId(int orderId);

    List<OrderDetail> getOrderDetailByUser(int userid);

    List<OrderDetail> getAll();
}
