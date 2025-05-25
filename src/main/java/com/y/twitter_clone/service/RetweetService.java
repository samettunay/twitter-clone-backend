package com.y.twitter_clone.service;

import java.util.List;
import java.util.UUID;

import com.y.twitter_clone.service.dto.response.RetweetResponse;

public interface RetweetService {
    RetweetResponse retweet(UUID tweetId, UUID userId);
    void undoRetweet(UUID tweetId, UUID userId);
    List<RetweetResponse> getRetweetsByUser(UUID userId);
}
