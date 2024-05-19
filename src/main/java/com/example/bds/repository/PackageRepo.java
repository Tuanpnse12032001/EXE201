package com.example.bds.repository;

import com.example.bds.model.Package;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PackageRepo extends JpaRepository<Package,Integer> {
    Optional<Package> findByPackageNameIgnoreCase(String packageName);
}