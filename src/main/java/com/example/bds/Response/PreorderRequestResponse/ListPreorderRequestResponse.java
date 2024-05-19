package com.example.bds.Response.PreorderRequestResponse;

import com.example.bds.model.PreorderRequest;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ListPreorderRequestResponse {
    private String status;
    private String message;
    private List<PreorderRequest> preorderRequests;
}