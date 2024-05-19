package com.example.bds.Response.OrderResponse;

import com.example.bds.model.Order;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponse {
    private String status;
    private String message;
    private List<Order> orders;
}
