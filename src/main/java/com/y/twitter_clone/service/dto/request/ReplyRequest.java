package com.y.twitter_clone.service.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReplyRequest {
    
    @NotBlank(message = "Content is required")
    @Size(max = 280, message = "Reply content cannot exceed 280 characters")
    private String content;
} 