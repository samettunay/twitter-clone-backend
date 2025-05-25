package com.y.twitter_clone.dto.response;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RetweetResponse {
    private Long id;
    private UserResponse user;
    private TweetResponse tweet;
    private LocalDateTime createdAt;
} 