package com.y.twitter_clone.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.y.twitter_clone.entity.Tweet;
import com.y.twitter_clone.entity.User;

public interface TweetRepository extends JpaRepository<Tweet, UUID> {
    List<Tweet> findByUser(User user);
    List<Tweet> findByUserInOrderByCreatedAtDesc(List<User> users);
    List<Tweet> findAllByOrderByCreatedAtDesc();
}