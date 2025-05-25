package com.y.twitter_clone.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.y.twitter_clone.entity.Reply;
import com.y.twitter_clone.entity.Tweet;
import com.y.twitter_clone.entity.User;
import com.y.twitter_clone.repository.ReplyRepository;
import com.y.twitter_clone.repository.TweetRepository;
import com.y.twitter_clone.repository.UserRepository;
import com.y.twitter_clone.service.ReplyService;
import com.y.twitter_clone.service.dto.request.ReplyRequest;
import com.y.twitter_clone.service.dto.response.ReplyResponse;
import com.y.twitter_clone.service.mapper.ReplyMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class ReplyServiceImpl implements ReplyService {

    private final ReplyRepository replyRepository;
    private final UserRepository userRepository;
    private final TweetRepository tweetRepository;
    private final ReplyMapper replyMapper;

    @Override
    public ReplyResponse addReply(UUID tweetId, ReplyRequest request) {
        Tweet tweet = tweetRepository.findById(tweetId)
            .orElseThrow(() -> new RuntimeException("Tweet not found"));
        User user = userRepository.findById(request.getUserId())
            .orElseThrow(() -> new RuntimeException("User not found"));

        Reply reply = replyMapper.toEntity(request);
        reply.setUser(user);
        reply.setTweet(tweet);
        
        Reply savedReply = replyRepository.save(reply);
        tweet.setReplyCount(tweet.getReplyCount() + 1);
        tweetRepository.save(tweet);
        
        return replyMapper.toResponse(savedReply);
    }

    @Override
    public List<ReplyResponse> getRepliesByTweet(UUID tweetId) {
        Tweet tweet = tweetRepository.findById(tweetId)
            .orElseThrow(() -> new RuntimeException("Tweet not found"));
        List<Reply> replies = replyRepository.findByTweet(tweet);
        return replies.stream()
            .map(replyMapper::toResponse)
            .toList();
    }

    @Override
    public void deleteReply(UUID replyId, UUID userId) {
        Reply reply = replyRepository.findById(replyId)
            .orElseThrow(() -> new RuntimeException("Reply not found"));
            
        if (!reply.getUser().getId().equals(userId)) {
            throw new RuntimeException("Not authorized to delete this reply");
        }
            
        Tweet tweet = reply.getTweet();
        tweet.setReplyCount(tweet.getReplyCount() - 1);
        tweetRepository.save(tweet);
        
        replyRepository.delete(reply);
    }
} 