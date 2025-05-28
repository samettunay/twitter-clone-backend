package com.y.twitter_clone.service.mapper;

import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.y.twitter_clone.entity.Like;
import com.y.twitter_clone.service.dto.response.LikeResponse;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class LikeMapper {
    
    private final ModelMapper modelMapper;

    public Like toEntity(UUID userId, UUID tweetId) {
        Like like = new Like();
        like.setId(null);
        like.setCreatedAt(null);
        return like;
    }

    public LikeResponse toResponse(Like like) {
        return modelMapper.map(like, LikeResponse.class);
    }
} 