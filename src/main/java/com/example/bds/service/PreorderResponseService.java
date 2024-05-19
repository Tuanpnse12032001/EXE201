package com.example.bds.service;


import com.example.bds.Request.PreorderResponseRequest.CreatePreorderResponseRequest;
import com.example.bds.Response.PreorderResponseResponse.CreatePreorderResponseResponse;
import org.springframework.http.ResponseEntity;

public interface PreorderResponseService {

    ResponseEntity<CreatePreorderResponseResponse> createPreorderResponse(CreatePreorderResponseRequest request);
}