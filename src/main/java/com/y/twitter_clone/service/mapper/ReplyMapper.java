package com.y.twitter_clone.service.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.y.twitter_clone.entity.Reply;
import com.y.twitter_clone.service.dto.request.ReplyRequest;
import com.y.twitter_clone.service.dto.response.ReplyResponse;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ReplyMapper {
    
    private final ModelMapper modelMapper;

    public Reply toEntity(ReplyRequest request) {
        Reply reply = modelMapper.map(request, Reply.class);
        reply.setId(null);
        reply.setUser(null);
        reply.setTweet(null);
        reply.setCreatedAt(null);
        return reply;
    }

    public ReplyResponse toResponse(Reply reply) {
        return modelMapper.map(reply, ReplyResponse.class);
    }

    public void updateEntityFromRequest(ReplyRequest request, Reply reply) {
        modelMapper.map(request, reply);
        reply.setId(null);
        reply.setUser(null);
        reply.setTweet(null);
        reply.setCreatedAt(null);
    }
} 