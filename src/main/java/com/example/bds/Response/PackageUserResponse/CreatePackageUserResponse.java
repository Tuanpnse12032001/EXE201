package com.example.bds.Response.PackageUserResponse;

import com.example.bds.model.PackageUser;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreatePackageUserResponse {
    private String status;
    private String message;
    private PackageUser packageUser;
}