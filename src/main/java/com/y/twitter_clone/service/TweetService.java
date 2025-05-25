package com.y.twitter_clone.service;

import java.util.List;
import java.util.UUID;

import com.y.twitter_clone.service.dto.request.TweetRequest;
import com.y.twitter_clone.service.dto.response.TweetResponse;

public interface TweetService {
    TweetResponse postTweet(TweetRequest request, UUID userId);
    List<TweetResponse> getFeed(UUID userId);
    List<TweetResponse> getUserTweets(UUID userId);
}
