package com.y.twitter_clone.service.mapper;

import java.util.UUID;

import com.y.twitter_clone.entity.Retweet;
import com.y.twitter_clone.service.dto.response.RetweetResponse;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {UserMapper.class, TweetMapper.class})
public interface RetweetMapper {
    
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    Retweet toEntity(UUID userId, UUID tweetId);
    
    RetweetResponse toResponse(Retweet retweet);
} 