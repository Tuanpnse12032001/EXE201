package com.example.bds.service;

import com.example.bds.Request.LikeRequest.CreateLikeRequest;
import com.example.bds.Response.LikeResponse.CreateLikeResponse;
import com.example.bds.Response.LikeResponse.DeleteLikeResponse;
import com.example.bds.Response.LikeResponse.FindLikeResponse;
import com.example.bds.Response.LikeResponse.ListLikeResponse;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface LikeService {
    CreateLikeResponse Like(CreateLikeRequest likeRequest);


    ResponseEntity<DeleteLikeResponse> deleteLike(int likeId);

    ResponseEntity<FindLikeResponse> findLikeById(int likeId);

    ResponseEntity<ListLikeResponse> findAllLikes();


    ResponseEntity<ListLikeResponse> findAllLikesPageNable(Pageable pageable);
}