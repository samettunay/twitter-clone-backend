package com.y.twitter_clone.service.impl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.y.twitter_clone.entity.Follow;
import com.y.twitter_clone.entity.User;
import com.y.twitter_clone.repository.FollowRepository;
import com.y.twitter_clone.repository.UserRepository;
import com.y.twitter_clone.service.FollowService;
import com.y.twitter_clone.service.dto.response.UserResponse;
import com.y.twitter_clone.service.mapper.UserMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class FollowServiceImpl implements FollowService {

    private final FollowRepository followRepository;
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public void follow(UUID followerId, UUID followingId) {
        if (followerId.equals(followingId)) {
            throw new RuntimeException("Cannot follow yourself");
        }

        User follower = userRepository.findById(followerId)
            .orElseThrow(() -> new RuntimeException("Follower not found"));
        User following = userRepository.findById(followingId)
            .orElseThrow(() -> new RuntimeException("Following user not found"));

        if (followRepository.existsByFollowerAndFollowing(follower, following)) {
            throw new RuntimeException("Already following this user");
        }

        Follow follow = new Follow();
        follow.setFollower(follower);
        follow.setFollowing(following);
        followRepository.save(follow);
    }

    @Override
    public void unfollow(UUID followerId, UUID followingId) {
        User follower = userRepository.findById(followerId)
            .orElseThrow(() -> new RuntimeException("Follower not found"));
        User following = userRepository.findById(followingId)
            .orElseThrow(() -> new RuntimeException("Following user not found"));

        followRepository.deleteByFollowerAndFollowing(follower, following);
    }

    @Override
    public boolean isFollowing(UUID followerId, UUID followingId) {
        User follower = userRepository.findById(followerId)
            .orElseThrow(() -> new RuntimeException("Follower not found"));
        User following = userRepository.findById(followingId)
            .orElseThrow(() -> new RuntimeException("Following user not found"));

        return followRepository.existsByFollowerAndFollowing(follower, following);
    }

    @Override
    public List<UserResponse> getFollowers(UUID userId) {
        User user = userRepository.findById(userId)
            .orElseThrow(() -> new RuntimeException("User not found"));
        return followRepository.findByFollowing(user).stream()
            .map(Follow::getFollower)
            .map(userMapper::toResponse)
            .collect(Collectors.toList());
    }

    @Override
    public List<UserResponse> getFollowing(UUID userId) {
        User user = userRepository.findById(userId)
            .orElseThrow(() -> new RuntimeException("User not found"));
        return followRepository.findByFollower(user).stream()
            .map(Follow::getFollowing)
            .map(userMapper::toResponse)
            .collect(Collectors.toList());
    }
} 