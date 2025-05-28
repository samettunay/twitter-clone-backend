package com.y.twitter_clone.service.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.y.twitter_clone.entity.User;
import com.y.twitter_clone.service.dto.request.RegisterRequest;
import com.y.twitter_clone.service.dto.request.UserRequest;
import com.y.twitter_clone.service.dto.response.UserResponse;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class UserMapper {
    
    private final ModelMapper modelMapper;

    public User toEntity(UserRequest request) {
        User user = modelMapper.map(request, User.class);
        user.setId(null);
        user.setCreatedAt(null);
        user.setPassword(null);
        return user;
    }

    public User toEntity(RegisterRequest request) {
        User user = modelMapper.map(request, User.class);
        user.setId(null);
        user.setCreatedAt(null);
        user.setPassword(null);
        return user;
    }

    public void updateEntity(User user, UserRequest request) {
        modelMapper.map(request, user);
        user.setPassword(null);
    }

    public UserResponse toResponse(User user) {
        return modelMapper.map(user, UserResponse.class);
    }
} 