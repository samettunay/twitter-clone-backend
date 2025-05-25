package com.y.twitter_clone.service;

import java.util.List;
import java.util.UUID;

import com.y.twitter_clone.service.dto.request.UserRequest;
import com.y.twitter_clone.service.dto.response.UserResponse;

public interface UserService {
    UserResponse getUserById(UUID id);
    UserResponse getUserByUsername(String username);
    UserResponse createUser(UserRequest request);
    List<UserResponse> searchUsers(String query);
}
