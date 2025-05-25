package com.y.twitter_clone.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.y.twitter_clone.entity.Retweet;
import com.y.twitter_clone.entity.Tweet;
import com.y.twitter_clone.entity.User;

public interface RetweetRepository extends JpaRepository<Retweet, UUID> {
    boolean existsByUserAndTweet(User user, Tweet tweet);
    Optional<Retweet> findByUserAndTweet(User user, Tweet tweet);
    List<Retweet> findByUser(User user);
}