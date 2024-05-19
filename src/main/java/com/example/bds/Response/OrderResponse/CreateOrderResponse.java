package com.example.bds.Response.OrderResponse;

import com.example.bds.model.Order;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateOrderResponse {
    private String status;
    private Order order;
}
