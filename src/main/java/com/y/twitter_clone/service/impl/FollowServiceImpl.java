package com.y.twitter_clone.service.impl;

import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.y.twitter_clone.entity.Follow;
import com.y.twitter_clone.entity.User;
import com.y.twitter_clone.repository.FollowRepository;
import com.y.twitter_clone.repository.UserRepository;
import com.y.twitter_clone.service.FollowService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class FollowServiceImpl implements FollowService {

    private final FollowRepository followRepository;
    private final UserRepository userRepository;

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
} 