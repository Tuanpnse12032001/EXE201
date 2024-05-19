package com.example.bds.service;

import com.example.bds.Request.PackageUser.createPackageUserRequest;
import com.example.bds.Response.PackageUserResponse.CreatePackageUserResponse;
import org.springframework.http.ResponseEntity;

public interface PackageUserService {
    ResponseEntity<CreatePackageUserResponse> createPackageUser(createPackageUserRequest request);
}
