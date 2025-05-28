package com.y.twitter_clone.service;

import java.util.List;
import java.util.UUID;

import com.y.twitter_clone.service.dto.response.UserResponse;

public interface FollowService {
    void follow(UUID followerId, UUID followingId);
    void unfollow(UUID followerId, UUID followingId);
    boolean isFollowing(UUID followerId, UUID followingId);
    List<UserResponse> getFollowers(UUID userId);
    List<UserResponse> getFollowing(UUID userId);
}
