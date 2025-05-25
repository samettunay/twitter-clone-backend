package com.y.twitter_clone.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.y.twitter_clone.entity.Tweet;
import com.y.twitter_clone.entity.User;
import com.y.twitter_clone.repository.TweetRepository;
import com.y.twitter_clone.repository.UserRepository;
import com.y.twitter_clone.service.TweetService;
import com.y.twitter_clone.service.dto.request.TweetRequest;
import com.y.twitter_clone.service.dto.response.TweetResponse;
import com.y.twitter_clone.service.mapper.TweetMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class TweetServiceImpl implements TweetService {

    private final TweetRepository tweetRepository;
    private final UserRepository userRepository;
    private final TweetMapper tweetMapper;

    @Override
    public TweetResponse postTweet(TweetRequest request, UUID userId) {
        User user = userRepository.findById(userId)
            .orElseThrow(() -> new RuntimeException("User not found"));

        Tweet tweet = tweetMapper.toEntity(request);
        tweet.setUser(user);
        Tweet savedTweet = tweetRepository.save(tweet);
        
        return tweetMapper.toResponse(savedTweet);
    }

    @Override
    public List<TweetResponse> getFeed(UUID userId) {
        User user = userRepository.findById(userId)
            .orElseThrow(() -> new RuntimeException("User not found"));
        List<Tweet> tweets = tweetRepository.findByUserOrderByCreatedAtDesc(user);
        return tweets.stream()
            .map(tweetMapper::toResponse)
            .toList();
    }

    @Override
    public List<TweetResponse> getUserTweets(UUID userId) {
        User user = userRepository.findById(userId)
            .orElseThrow(() -> new RuntimeException("User not found"));
        List<Tweet> tweets = tweetRepository.findByUserOrderByCreatedAtDesc(user);
        return tweets.stream()
            .map(tweetMapper::toResponse)
            .toList();
    }
} 