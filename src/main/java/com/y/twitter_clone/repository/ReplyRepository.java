package com.y.twitter_clone.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.y.twitter_clone.entity.Reply;
import com.y.twitter_clone.entity.Tweet;

public interface ReplyRepository extends JpaRepository<Reply, UUID> {
    List<Reply> findByTweet(Tweet tweet);
}
    