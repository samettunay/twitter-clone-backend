package com.y.twitter_clone.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.y.twitter_clone.service.ReplyService;
import com.y.twitter_clone.service.dto.request.ReplyRequest;
import com.y.twitter_clone.service.dto.response.ReplyResponse;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/replies")
@RequiredArgsConstructor
public class ReplyController {

    private final ReplyService replyService;

    @PostMapping("/tweet/{tweetId}")
    public ResponseEntity<ReplyResponse> addReply(
            @PathVariable UUID tweetId,
            @Valid @RequestBody ReplyRequest request) {
        return ResponseEntity.ok(replyService.addReply(tweetId, request));
    }

    @GetMapping("/tweet/{tweetId}")
    public ResponseEntity<List<ReplyResponse>> getRepliesByTweet(@PathVariable UUID tweetId) {
        return ResponseEntity.ok(replyService.getRepliesByTweet(tweetId));
    }

    @DeleteMapping("/{replyId}")
    public ResponseEntity<Void> deleteReply(@PathVariable UUID replyId, @PathVariable UUID currentUserId) {
        replyService.deleteReply(replyId, currentUserId);
        return ResponseEntity.ok().build();
    }
} 