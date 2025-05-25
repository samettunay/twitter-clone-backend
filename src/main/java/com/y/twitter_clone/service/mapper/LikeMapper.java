package com.y.twitter_clone.service.mapper;

import java.util.UUID;

import com.y.twitter_clone.entity.Like;
import com.y.twitter_clone.service.dto.response.LikeResponse;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {UserMapper.class, TweetMapper.class})
public interface LikeMapper {
    
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    Like toEntity(UUID userId, UUID tweetId);
    
    LikeResponse toResponse(Like like);
} 