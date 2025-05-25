package com.y.twitter_clone.service.mapper;

import com.y.twitter_clone.entity.Tweet;
import com.y.twitter_clone.service.dto.request.TweetRequest;
import com.y.twitter_clone.service.dto.response.TweetResponse;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", uses = {UserMapper.class})
public interface TweetMapper {
    
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "user", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "likeCount", constant = "0")
    @Mapping(target = "retweetCount", constant = "0")
    @Mapping(target = "replyCount", constant = "0")
    Tweet toEntity(TweetRequest request);
    
    TweetResponse toResponse(Tweet tweet);
    
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "user", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "likeCount", ignore = true)
    @Mapping(target = "retweetCount", ignore = true)
    @Mapping(target = "replyCount", ignore = true)
    void updateEntityFromRequest(TweetRequest request, @MappingTarget Tweet tweet);
} 