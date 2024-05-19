package com.example.bds.Response.OrderDetailResponse;

import com.example.bds.model.OrderDetail;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetailResponse {
    private String status;
    private String message;
//    private String orderID;
    private List<OrderDetail> orderDetails;
}
