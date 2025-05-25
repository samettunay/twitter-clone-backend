package com.y.twitter_clone.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.y.twitter_clone.entity.Retweet;
import com.y.twitter_clone.entity.Tweet;
import com.y.twitter_clone.entity.User;
import com.y.twitter_clone.repository.RetweetRepository;
import com.y.twitter_clone.repository.TweetRepository;
import com.y.twitter_clone.repository.UserRepository;
import com.y.twitter_clone.service.RetweetService;
import com.y.twitter_clone.service.dto.response.RetweetResponse;
import com.y.twitter_clone.service.mapper.RetweetMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class RetweetServiceImpl implements RetweetService {

    private final RetweetRepository retweetRepository;
    private final UserRepository userRepository;
    private final TweetRepository tweetRepository;
    private final RetweetMapper retweetMapper;

    @Override
    public RetweetResponse retweet(UUID tweetId, UUID userId) {
        User user = userRepository.findById(userId)
            .orElseThrow(() -> new RuntimeException("User not found"));
        Tweet tweet = tweetRepository.findById(tweetId)
            .orElseThrow(() -> new RuntimeException("Tweet not found"));

        if (retweetRepository.existsByUserAndTweet(user, tweet)) {
            throw new RuntimeException("Tweet already retweeted");
        }

        Retweet retweet = retweetMapper.toEntity(userId, tweetId);
        retweet.setUser(user);
        retweet.setTweet(tweet);
        Retweet savedRetweet = retweetRepository.save(retweet);
        
        tweet.setRetweetCount(tweet.getRetweetCount() + 1);
        tweetRepository.save(tweet);
        
        return retweetMapper.toResponse(savedRetweet);
    }

    @Override
    public void undoRetweet(UUID tweetId, UUID userId) {
        User user = userRepository.findById(userId)
            .orElseThrow(() -> new RuntimeException("User not found"));
        Tweet tweet = tweetRepository.findById(tweetId)
            .orElseThrow(() -> new RuntimeException("Tweet not found"));

        retweetRepository.findByUserAndTweet(user, tweet)
            .ifPresent(retweet -> {
                retweetRepository.delete(retweet);
                tweet.setRetweetCount(tweet.getRetweetCount() - 1);
                tweetRepository.save(tweet);
            });
    }

    @Override
    public List<RetweetResponse> getRetweetsByUser(UUID userId) {
        User user = userRepository.findById(userId)
            .orElseThrow(() -> new RuntimeException("User not found"));
        List<Retweet> retweets = retweetRepository.findByUser(user);
        return retweets.stream()
            .map(retweetMapper::toResponse)
            .toList();
    }
} 