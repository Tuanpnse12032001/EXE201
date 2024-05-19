package com.example.bds.service;
import com.example.bds.Request.PackageRequest.CreatePackageRequest;
import com.example.bds.Request.PackageRequest.UpdatePackageRequest;
import com.example.bds.Response.PackageResponse.PackageResponse;
import com.example.bds.model.Package;
import org.springframework.http.ResponseEntity;

import java.util.Optional;


public interface PackageService {
    ResponseEntity<PackageResponse> getAll();
    ResponseEntity<PackageResponse> createPackage(CreatePackageRequest request);
    ResponseEntity<PackageResponse> deletePackage(int packageId);
    Optional<Package> findById(int packageId);
    ResponseEntity<PackageResponse> update(int packageId, UpdatePackageRequest request);
    ResponseEntity<PackageResponse> searchPackage(String packageName);
}
