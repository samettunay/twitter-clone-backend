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
@Table(name = "likes", uniqueConstraints = {
  @UniqueConstraint(columnNames = {"user_id", "tweet_id"})
})
public class Like {

  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY)
  private User user;

  @ManyToOne(fetch = FetchType.LAZY)
  private Tweet tweet;

  private LocalDateTime likedAt;

  @PrePersist
  public void onCreate() {
      this.likedAt = LocalDateTime.now();
  }
}
