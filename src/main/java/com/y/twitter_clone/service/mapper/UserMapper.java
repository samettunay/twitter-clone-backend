package com.y.twitter_clone.service.mapper;

import com.y.twitter_clone.entity.User;
import com.y.twitter_clone.service.dto.request.UserRequest;
import com.y.twitter_clone.service.dto.response.UserResponse;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {
    
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    User toEntity(UserRequest request);
    
    UserResponse toResponse(User user);
    
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    void updateEntityFromRequest(UserRequest request, @MappingTarget User user);
} 