package com.y.twitter_clone.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.y.twitter_clone.service.RetweetService;
import com.y.twitter_clone.service.dto.response.RetweetResponse;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/retweets")
@RequiredArgsConstructor
public class RetweetController {

    private final RetweetService retweetService;

    @PostMapping("/tweet/{tweetId}")
    public ResponseEntity<RetweetResponse> retweet(@PathVariable UUID tweetId, @PathVariable UUID currentUserId) {
        return ResponseEntity.ok(retweetService.retweet(tweetId, currentUserId));
    }

    @DeleteMapping("/tweet/{tweetId}")
    public ResponseEntity<Void> undoRetweet(@PathVariable UUID tweetId, @PathVariable UUID currentUserId) {
        retweetService.undoRetweet(tweetId, currentUserId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<RetweetResponse>> getRetweetsByUser(@PathVariable UUID userId) {
        return ResponseEntity.ok(retweetService.getRetweetsByUser(userId));
    }
} 