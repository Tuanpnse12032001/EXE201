package com.example.bds.Response.PackageResponse;

import com.example.bds.model.Package;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PackageResponse {
    private String status;
    private String message;
    private List<Package> packages;
}
