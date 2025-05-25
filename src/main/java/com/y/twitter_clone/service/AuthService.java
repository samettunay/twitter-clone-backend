package com.y.twitter_clone.service;

import com.y.twitter_clone.service.dto.request.LoginRequest;
import com.y.twitter_clone.service.dto.request.RegisterRequest;
import com.y.twitter_clone.service.dto.response.AuthResponse;

public interface AuthService {
    AuthResponse register(RegisterRequest dto);
    AuthResponse login(LoginRequest dto);
}
