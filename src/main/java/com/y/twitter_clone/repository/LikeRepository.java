package com.y.twitter_clone.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.y.twitter_clone.entity.Like;
import com.y.twitter_clone.entity.Tweet;
import com.y.twitter_clone.entity.User;

public interface LikeRepository extends JpaRepository<Like, UUID> {
    boolean existsByUserAndTweet(User user, Tweet tweet);
    void deleteByUserAndTweet(User user, Tweet tweet);
    long countByTweet(Tweet tweet);
}
