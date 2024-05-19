package com.example.bds.service;

import com.example.bds.Request.ArtworkRequest.CreateArtworkRequest;
import com.example.bds.Request.ArtworkRequest.UpdateArtworkRequest;
import com.example.bds.Response.ArtworkResponse.CreateArtworkResponse;
import com.example.bds.Response.ArtworkResponse.DeleteArtworkResponse;
import com.example.bds.Response.ObjectResponse.ResponseObject;
import com.example.bds.Response.UserResponse.ArtworkOrderDetailDTO;
import com.example.bds.model.Artwork;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ArtworkService {
    public List<Artwork> getListArtworkForGuest(int count);
    public CreateArtworkResponse createArtwork(CreateArtworkRequest request);
    DeleteArtworkResponse deleteArtwork(int artworkId);
    public CreateArtworkResponse updateArtwork(int artworkId,UpdateArtworkRequest request);
    ResponseEntity<ResponseObject> findArtworkId(Integer artworkId);

    List<Artwork> getAllArtworks();

    List<Artwork> findArtworksByFilter(String artworkName,  double price);
    public byte[] downloadImage(int fileName);
    List<Artwork> getArtWorkByCreatorId(int id);

    public List<ArtworkOrderDetailDTO> getOrderDetailsByArtworkID(int artworkID);
}
