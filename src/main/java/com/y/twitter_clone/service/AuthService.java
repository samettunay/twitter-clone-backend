package com.y.twitter_clone.service;

import java.util.UUID;

import com.y.twitter_clone.service.dto.request.LoginRequest;
import com.y.twitter_clone.service.dto.request.RegisterRequest;
import com.y.twitter_clone.service.dto.response.AuthResponse;

public interface AuthService {
    AuthResponse register(RegisterRequest request);
    AuthResponse login(LoginRequest request);
    UUID getCurrentUserId();
}
