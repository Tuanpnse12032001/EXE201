package com.example.bds.Response.PreorderResponseResponse;

import com.example.bds.model.PreorderResponse;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreatePreorderResponseResponse {
    private String status;
    private String message;
    private PreorderResponse preorderResponse;
}