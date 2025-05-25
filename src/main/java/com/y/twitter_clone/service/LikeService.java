package com.y.twitter_clone.service;

import java.util.UUID;

public interface LikeService {
    void like(UUID tweetId, UUID userId);
    void unlike(UUID tweetId, UUID userId);
    long countLikes(UUID tweetId);
}
