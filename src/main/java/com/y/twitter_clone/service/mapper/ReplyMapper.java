package com.y.twitter_clone.service.mapper;

import com.y.twitter_clone.entity.Reply;
import com.y.twitter_clone.service.dto.request.ReplyRequest;
import com.y.twitter_clone.service.dto.response.ReplyResponse;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", uses = {UserMapper.class, TweetMapper.class})
public interface ReplyMapper {
    
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "user", ignore = true)
    @Mapping(target = "tweet", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    Reply toEntity(ReplyRequest request);
    
    ReplyResponse toResponse(Reply reply);
    
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "user", ignore = true)
    @Mapping(target = "tweet", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    void updateEntityFromRequest(ReplyRequest request, @MappingTarget Reply reply);
} 