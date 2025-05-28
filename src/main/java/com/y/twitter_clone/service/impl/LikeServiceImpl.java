package com.y.twitter_clone.service.impl;

import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.y.twitter_clone.entity.Like;
import com.y.twitter_clone.entity.Tweet;
import com.y.twitter_clone.entity.User;
import com.y.twitter_clone.repository.LikeRepository;
import com.y.twitter_clone.repository.TweetRepository;
import com.y.twitter_clone.repository.UserRepository;
import com.y.twitter_clone.service.LikeService;
import com.y.twitter_clone.service.mapper.LikeMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class LikeServiceImpl implements LikeService {

    private final LikeRepository likeRepository;
    private final UserRepository userRepository;
    private final TweetRepository tweetRepository;
    private final LikeMapper likeMapper;

    @Override
    public void like(UUID tweetId, UUID userId) {
        User user = userRepository.findById(userId)
            .orElseThrow(() -> new RuntimeException("User not found"));
        Tweet tweet = tweetRepository.findById(tweetId)
            .orElseThrow(() -> new RuntimeException("Tweet not found"));

        if (likeRepository.existsByUserAndTweet(user, tweet)) {
            throw new RuntimeException("Tweet already liked");
        }

        Like like = likeMapper.toEntity(userId, tweetId);
        like.setUser(user);
        like.setTweet(tweet);
        likeRepository.save(like);
        
        tweet.setLikeCount(tweet.getLikeCount() + 1);
        tweetRepository.save(tweet);
    }

    @Override
    public void unlike(UUID tweetId, UUID userId) {
        User user = userRepository.findById(userId)
            .orElseThrow(() -> new RuntimeException("User not found"));
        Tweet tweet = tweetRepository.findById(tweetId)
            .orElseThrow(() -> new RuntimeException("Tweet not found"));

        likeRepository.deleteByUserAndTweet(user, tweet);
        
        tweet.setLikeCount(tweet.getLikeCount() - 1);
        tweetRepository.save(tweet);
    }

    @Override
    public long countLikes(UUID tweetId) {
        Tweet tweet = tweetRepository.findById(tweetId)
            .orElseThrow(() -> new RuntimeException("Tweet not found"));
        return likeRepository.countByTweet(tweet);
    }
}