package com.y.twitter_clone.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.y.twitter_clone.service.TweetService;
import com.y.twitter_clone.service.dto.request.TweetRequest;
import com.y.twitter_clone.service.dto.response.TweetResponse;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/tweets")
@RequiredArgsConstructor
public class TweetController {

    private final TweetService tweetService;

    @PostMapping
    public ResponseEntity<TweetResponse> postTweet(@Valid @RequestBody TweetRequest request, @PathVariable UUID currentUserId) {
        return ResponseEntity.ok(tweetService.postTweet(request, currentUserId));
    }

    @GetMapping("/feed")
    public ResponseEntity<List<TweetResponse>> getFeed(@PathVariable UUID currentUserId) {
        return ResponseEntity.ok(tweetService.getFeed(currentUserId));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<TweetResponse>> getUserTweets(@PathVariable UUID userId) {
        return ResponseEntity.ok(tweetService.getUserTweets(userId));
    }
} 