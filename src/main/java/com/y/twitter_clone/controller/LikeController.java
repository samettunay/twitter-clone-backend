package com.y.twitter_clone.controller;

import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.y.twitter_clone.service.LikeService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/likes")
@RequiredArgsConstructor
public class LikeController {

    private final LikeService likeService;

    @PostMapping("/tweet/{tweetId}")
    public ResponseEntity<Void> likeTweet(@PathVariable UUID tweetId, @PathVariable UUID currentUserId) {
        likeService.like(tweetId, currentUserId);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/tweet/{tweetId}")
    public ResponseEntity<Void> unlikeTweet(@PathVariable UUID tweetId, @PathVariable UUID currentUserId) {
        likeService.unlike(tweetId, currentUserId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/tweet/{tweetId}/count")
    public ResponseEntity<Long> countLikes(@PathVariable UUID tweetId) {
        return ResponseEntity.ok(likeService.countLikes(tweetId));
    }
} 