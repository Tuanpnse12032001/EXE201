package com.example.bds.Request.PackageRequest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreatePackageRequest {
    private String packageName;
    private Double packagePrice;
    private Integer packageTime;
}
