package com.y.twitter_clone.service.mapper;

import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.y.twitter_clone.entity.Retweet;
import com.y.twitter_clone.service.dto.response.RetweetResponse;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class RetweetMapper {
    
    private final ModelMapper modelMapper;

    public Retweet toEntity(UUID userId, UUID tweetId) {
        Retweet retweet = new Retweet();
        retweet.setId(null);
        retweet.setCreatedAt(null);
        return retweet;
    }

    public RetweetResponse toResponse(Retweet retweet) {
        return modelMapper.map(retweet, RetweetResponse.class);
    }
} 