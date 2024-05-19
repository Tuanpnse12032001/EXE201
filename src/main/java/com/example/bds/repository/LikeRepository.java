package com.example.bds.repository;

import com.example.bds.model.Artwork;
import com.example.bds.model.Like;
import com.example.bds.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LikeRepository extends JpaRepository<Like, Integer> {
    boolean existsByUserAndArtwork(User user, Artwork artwork);
    Like findByUserAndArtwork(User user, Artwork artwork);
}