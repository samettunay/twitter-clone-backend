package com.y.twitter_clone.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.y.twitter_clone.entity.User;
import com.y.twitter_clone.service.dto.request.RegisterRequest;
import com.y.twitter_clone.service.dto.request.UserRequest;
import com.y.twitter_clone.service.dto.response.UserResponse;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "password", ignore = true)
    User toEntity(UserRequest request);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "password", ignore = true)
    User toEntity(RegisterRequest request);

    @Mapping(target = "password", ignore = true)
    void updateEntity(@MappingTarget User user, UserRequest request);

    UserResponse toResponse(User user);
} 