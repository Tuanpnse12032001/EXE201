package com.example.bds.repository;

import com.example.bds.model.Follower;
import com.example.bds.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FollowerRepository extends JpaRepository<Follower, Integer> {
    boolean existsByUserAndFollowerUser(User user, User followerUser);


    @Query("SELECT f FROM Follower f WHERE " +
            "(:userId IS NULL OR f.user.usersID = :userId) AND " +
            "(:accountName IS NULL OR f.user.accountName = :accountName)")
    List<Follower> findFollowersByFilter(Integer userId, String accountName);


}