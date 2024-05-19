package com.example.bds.repository;

import com.example.bds.model.PreorderRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PreorderRequestRepository extends JpaRepository<PreorderRequest, Integer> {

}