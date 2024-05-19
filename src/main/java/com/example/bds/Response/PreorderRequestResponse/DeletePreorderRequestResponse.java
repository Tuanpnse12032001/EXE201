package com.example.bds.Response.PreorderRequestResponse;

import lombok.Data;

@Data

public class DeletePreorderRequestResponse {
    private String status;
    private String message;

    public DeletePreorderRequestResponse(String status, String message) {
        this.status = status;
        this.message = message;
    }

    // Getters and setters...
}