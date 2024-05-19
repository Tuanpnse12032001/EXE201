package com.example.bds.service;

import com.example.bds.Request.FollowerRequest.CreateFollowerRequest;
import com.example.bds.Response.FollowerResponse.*;

import com.example.bds.model.Follower;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface FollowerService {
    ResponseEntity<CreateFollowerResponse> createFollower(CreateFollowerRequest createFollowerRequest);




    ResponseEntity<DeleteFollowerResponse> deleteFollower(int followerId);

    ResponseEntity<FindFollowerResponse> findFollowerById(int followerId);

    ResponseEntity<ListFollowerResponse> findAllFollowers();

    ResponseEntity<CreateFollowerResponse> updateFollower(int followerId, CreateFollowerRequest followerRequest);


    List<Follower> searchFollowers(Integer userId, String accountName);
}