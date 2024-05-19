package com.example.bds.repository;

import com.example.bds.model.Artwork;
import com.example.bds.model.Cart;
import com.example.bds.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CartRepo extends JpaRepository<Cart,Integer> {

    List<Cart> findByUser(User userId);

    Optional<Cart> findByUserAndArtwork(User user, Artwork artwork);
}
