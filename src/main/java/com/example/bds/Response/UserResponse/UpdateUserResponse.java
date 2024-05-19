package com.example.bds.Response.UserResponse;

import com.example.bds.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpdateUserResponse {
    private String status;
    private User user;
}
