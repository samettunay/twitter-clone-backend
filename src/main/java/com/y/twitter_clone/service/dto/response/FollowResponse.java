package com.y.twitter_clone.service.dto.response;

import java.time.LocalDateTime;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FollowResponse {
    private UUID id;
    private UserResponse follower;
    private UserResponse following;
    private LocalDateTime createdAt;
} 