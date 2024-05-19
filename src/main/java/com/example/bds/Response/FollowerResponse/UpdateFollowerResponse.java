package com.example.bds.Response.FollowerResponse;

import com.example.bds.model.Follower;

public class UpdateFollowerResponse {
    private String status;
    private String message;
    private Follower follower;

    public UpdateFollowerResponse(String status, String message, Follower follower) {
        this.status = status;
        this.message = message;
        this.follower = follower;
    }

}
