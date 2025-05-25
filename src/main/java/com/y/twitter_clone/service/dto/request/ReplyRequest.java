package com.y.twitter_clone.service.dto.request;

import java.util.UUID;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReplyRequest {
    
    @NotNull(message = "User ID is required")
    private UUID userId;

    @NotNull(message = "Tweet ID is required")
    private UUID tweetId;
    
    @NotBlank(message = "Content is required")
    @Size(max = 280, message = "Reply content cannot exceed 280 characters")
    private String content;
} 