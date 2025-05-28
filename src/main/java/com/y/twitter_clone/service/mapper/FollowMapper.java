package com.y.twitter_clone.service.mapper;

import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.y.twitter_clone.entity.Follow;
import com.y.twitter_clone.service.dto.response.FollowResponse;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class FollowMapper {
    
    private final ModelMapper modelMapper;

    public Follow toEntity(UUID followerId, UUID followingId) {
        Follow follow = new Follow();
        follow.setId(null);
        follow.setCreatedAt(null);
        return follow;
    }

    public FollowResponse toResponse(Follow follow) {
        return modelMapper.map(follow, FollowResponse.class);
    }
} 