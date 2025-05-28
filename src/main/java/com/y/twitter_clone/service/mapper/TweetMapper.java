package com.y.twitter_clone.service.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.y.twitter_clone.entity.Tweet;
import com.y.twitter_clone.service.dto.request.TweetRequest;
import com.y.twitter_clone.service.dto.response.TweetResponse;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class TweetMapper {
    
    private final ModelMapper modelMapper;

    public Tweet toEntity(TweetRequest request) {
        Tweet tweet = modelMapper.map(request, Tweet.class);
        tweet.setId(null);
        tweet.setUser(null);
        tweet.setCreatedAt(null);
        tweet.setLikeCount(0);
        tweet.setRetweetCount(0);
        tweet.setReplyCount(0);
        return tweet;
    }

    public TweetResponse toResponse(Tweet tweet) {
        return modelMapper.map(tweet, TweetResponse.class);
    }

    public void updateEntityFromRequest(TweetRequest request, Tweet tweet) {
        modelMapper.map(request, tweet);
        tweet.setId(null);
        tweet.setUser(null);
        tweet.setCreatedAt(null);
        tweet.setLikeCount(0);
        tweet.setRetweetCount(0);
        tweet.setReplyCount(0);
    }
} 