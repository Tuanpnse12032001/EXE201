package com.example.bds.Response.PreorderRequestResponse;

import com.example.bds.model.PreorderRequest;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreatePreorderRequestResponse {
    private String status;
    private String message;
    private PreorderRequest preorderRequest;
}