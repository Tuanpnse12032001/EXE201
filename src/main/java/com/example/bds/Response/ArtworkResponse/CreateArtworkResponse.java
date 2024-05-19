package com.example.bds.Response.ArtworkResponse;

import com.example.bds.model.Artwork;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateArtworkResponse {
    private String status;
    private Artwork artwork;
}

