package com.y.twitter_clone.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tweets")
public class Tweet {

  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id", nullable = false)
  private User user;

  @Column(nullable = false, length = 280)
  private String content;

  private int likeCount = 0;
  private int retweetCount = 0;
  private int replyCount = 0;

  private LocalDateTime createdAt;

  @PrePersist
  public void onCreate() {
      this.createdAt = LocalDateTime.now();
  }
}
