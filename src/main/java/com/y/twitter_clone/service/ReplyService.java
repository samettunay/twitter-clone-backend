package com.y.twitter_clone.service;

import java.util.List;
import java.util.UUID;

import com.y.twitter_clone.service.dto.request.ReplyRequest;
import com.y.twitter_clone.service.dto.response.ReplyResponse;

public interface ReplyService {
    ReplyResponse addReply(UUID tweetId, ReplyRequest request);
    List<ReplyResponse> getRepliesByTweet(UUID tweetId);
    void deleteReply(UUID replyId, UUID userId);
}
