package com.example.bds.Request.LikeRequest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateLikeRequest {
    private int userId;
    private int artworkId;


}