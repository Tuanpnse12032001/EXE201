package com.example.bds.Response.FollowerResponse;
import com.example.bds.model.Follower;

public class FindFollowerResponse {
    private String status;
    private String message;
    private Follower follower;

    public FindFollowerResponse(String status, String message, Follower follower) {
        this.status = status;
        this.message = message;
        this.follower = follower;
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Follower getFollower() {
        return follower;
    }

    public void setFollower(Follower follower) {
        this.follower = follower;
    }
}
