package com.example.bds.Response.UserResponse;


import com.example.bds.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseUser {
    private String status;
    private String message;
    private List<User> userList;
}
