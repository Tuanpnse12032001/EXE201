package com.example.bds.serviceimplement;

import com.example.bds.Request.LikeRequest.CreateLikeRequest;
import com.example.bds.Response.LikeResponse.CreateLikeResponse;
import com.example.bds.Response.LikeResponse.DeleteLikeResponse;
import com.example.bds.Response.LikeResponse.FindLikeResponse;
import com.example.bds.Response.LikeResponse.ListLikeResponse;
import com.example.bds.enums.Role;
import com.example.bds.model.Artwork;
import com.example.bds.model.Like;

import com.example.bds.repository.ArtworkRepo;
import com.example.bds.repository.LikeRepository;

import com.example.bds.repository.UserRepo;
import com.example.bds.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LikeServiceImpl implements LikeService {

    @Autowired
    private LikeRepository likeRepository;
    @Autowired
    private UserRepo userRepo;

   @Autowired
   private ArtworkRepo artworkRepo;

    @Override
    public CreateLikeResponse Like(CreateLikeRequest likeRequest) {
        int userid = likeRequest.getUserId();
        int artworkId = likeRequest.getArtworkId();
        var user = userRepo.findUserByUsersID(userid).orElse(null);
        Artwork artwork = artworkRepo.findById(artworkId).orElse(null);
        if(user!=null && (user.getRole()== Role.AUDIENCE || user.getRole()==Role.CREATOR)){
            if(artwork != null){
                Like likeCheck =likeRepository.findByUserAndArtwork(user, artwork);
                if (likeCheck==null) {
                    Like like = new Like();
                    like.setUser(user);
                    like.setArtwork(artwork);
                    likeRepository.save(like);
                    artwork.setLikeCount(artwork.getLikeCount() + 1);
                    artworkRepo.save(artwork);
                    return CreateLikeResponse.builder()
                            .status("Like successful")
                            .build();
                }else {
                    likeRepository.delete(likeCheck);
                    artwork.setLikeCount(artwork.getLikeCount() - 1);
                    artworkRepo.save(artwork);
                    return CreateLikeResponse.builder()
                            .status("UnLike successful")
                            .build();
                }

            }else{
                return CreateLikeResponse.builder()
                        .status("Artwork not found !")
                        .build();
            }

        }else {
            return CreateLikeResponse.builder()
                    .status("User not found !")
                    .build();
        }
    }

    @Override
    public ResponseEntity<DeleteLikeResponse> deleteLike(int likeId) {
        try {
            Like like = likeRepository.findById(likeId).orElse(null);
            if (like == null) {
                return ResponseEntity.badRequest().body(new DeleteLikeResponse("Fail", "Follower not found", null));
            }

            // Xóa follower từ cơ sở dữ liệu
            likeRepository.delete(like);

            return ResponseEntity.ok(new DeleteLikeResponse("Success", "Delete follower success", null));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(new DeleteLikeResponse("Fail", "Internal Server Error", null));
        }
    }

    @Override
    public ResponseEntity<FindLikeResponse> findLikeById(int likeId) {
        try {
            Like like = likeRepository.findById(likeId).orElse(null);
            if (like == null) {
                return ResponseEntity.badRequest().body(new FindLikeResponse("Fail", "Follower not found", null));
            }

            // Tạo response
            return ResponseEntity.ok(new FindLikeResponse("Success", "Find follower success", like));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(new FindLikeResponse("Fail", "Internal Server Error", null));
        }
    }

    @Override
    public ResponseEntity<ListLikeResponse> findAllLikes() {
        try {
            List<Like> likes = likeRepository.findAll();
            if (likes.isEmpty()) {
                return ResponseEntity.ok(new ListLikeResponse("Success", "List is empty", "listIsEmpty"));
            }
            return ResponseEntity.ok(new ListLikeResponse("Success", "List followers", likes));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(new ListLikeResponse("Fail", "Internal Server Error", null));
        }
    }

    @Override
    public ResponseEntity<ListLikeResponse> findAllLikesPageNable(Pageable pageable) {
        try {
            Page<Like> likePage = likeRepository.findAll(pageable);
            List<Like> likes = likePage.getContent();

            if (likes.isEmpty()) {
                return ResponseEntity.ok(new ListLikeResponse("Success", "List is empty", "listIsEmpty"));
            }

            return ResponseEntity.ok(new ListLikeResponse("Success", "List followers", likes));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(new ListLikeResponse("Fail", "Internal Server Error", null));
        }
    }


}