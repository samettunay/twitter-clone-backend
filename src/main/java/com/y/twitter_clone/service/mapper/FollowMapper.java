package com.y.twitter_clone.service.mapper;

import java.util.UUID;

import com.y.twitter_clone.entity.Follow;
import com.y.twitter_clone.service.dto.response.FollowResponse;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {UserMapper.class})
public interface FollowMapper {
    
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    Follow toEntity(UUID followerId, UUID followingId);
    
    FollowResponse toResponse(Follow follow);
} 