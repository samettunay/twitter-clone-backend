package com.y.twitter_clone.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TweetDto {
  private Long id;
  private String content;
  private LocalDateTime createdAt;
  private UserDto user;
}
