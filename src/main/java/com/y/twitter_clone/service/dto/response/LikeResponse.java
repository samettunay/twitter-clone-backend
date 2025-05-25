package com.y.twitter_clone.service.dto.response;

import java.time.LocalDateTime;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LikeResponse {
    private UUID id;
    private UserResponse user;
    private TweetResponse tweet;
    private LocalDateTime createdAt;
} 