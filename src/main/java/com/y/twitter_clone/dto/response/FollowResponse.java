package com.y.twitter_clone.dto.response;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FollowResponse {
    private Long id;
    private UserResponse follower;
    private UserResponse following;
    private LocalDateTime createdAt;
} 