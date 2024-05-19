package com.example.bds.service;

import com.example.bds.Request.UserRequest.SearchRequest;
import com.example.bds.Request.UserRequest.UpdateUserRequest;
import com.example.bds.Response.ObjectResponse.ResponseObject;
import com.example.bds.Response.UserResponse.*;
import com.example.bds.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface UserService {
    public List<User> getAll();

    public UpdateUserResponse updateUser(String email, UpdateUserRequest updateUserRequest);
    public ChangeAvatarResponse changeAvatar(String email, MultipartFile file) throws IOException;

    public byte[] downloadImage(String fileName);

    public UpdateUserResponse banUser(String email);
    public UpdateUserResponse banUserByID(int userID);
    public UpdateUserResponse unbanUser(String email);
    public UpdateUserResponse unbanUserByID(int userID);

    public List<User> getCreator();

    ResponseEntity<ResponseUser> searchUsers(SearchRequest req);


    ResponseEntity<ResponseObject> findAllCreator();

    ResponseEntity<ResponseObject> findUserById(int userId);

    ResponseEntity<ResponseObject> findAllUsers();

    List<User> searchUser(String searchValue, String phone);

    User findByEmailForMail(String email);

    User saveUserForMail(User user);

    User getUserById(int audienceId);

    UpdateUserResponse updateAccountBalance(int userid ,BalanceRequest request);
    UpdateUserResponse ReduceAccountBalance(int userid ,BalanceRequest request);

    BalanceAccountResponse getBalanceAccount(int userid);
    UserInfoResponse getUserInfo(int userid);
}
