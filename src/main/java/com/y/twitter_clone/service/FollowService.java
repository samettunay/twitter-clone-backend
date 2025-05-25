package com.y.twitter_clone.service;

import java.util.UUID;

public interface FollowService {
    void follow(UUID followerId, UUID followingId);
    void unfollow(UUID followerId, UUID followingId);
    boolean isFollowing(UUID followerId, UUID followingId);
}
