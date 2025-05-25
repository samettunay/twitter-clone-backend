package com.y.twitter_clone.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.y.twitter_clone.entity.User;
import com.y.twitter_clone.repository.UserRepository;
import com.y.twitter_clone.service.UserService;
import com.y.twitter_clone.service.dto.request.UserRequest;
import com.y.twitter_clone.service.dto.response.UserResponse;
import com.y.twitter_clone.service.mapper.UserMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserResponse getUserById(UUID id) {
        User user = userRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("User not found"));
        return userMapper.toResponse(user);
    }

    @Override
    public UserResponse getUserByUsername(String username) {
        User user = userRepository.findByUsername(username)
            .orElseThrow(() -> new RuntimeException("User not found"));
        return userMapper.toResponse(user);
    }

    @Override
    public UserResponse createUser(UserRequest request) {
        if (userRepository.existsByUsername(request.getUsername())) {
            throw new RuntimeException("Username already exists");
        }
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email already exists");
        }

        User user = userMapper.toEntity(request);
        User savedUser = userRepository.save(user);
        
        return userMapper.toResponse(savedUser);
    }

    @Override
    public List<UserResponse> searchUsers(String query) {
        List<User> users = userRepository.findByUsernameContainingIgnoreCase(query);
        return users.stream()
            .map(userMapper::toResponse)
            .toList();
    }
} 