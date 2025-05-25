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
@Table(name = "follows", uniqueConstraints = {
  @UniqueConstraint(columnNames = {"follower_id", "following_id"})
})
public class Follow {

  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "follower_id")
  private User follower;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "following_id")
  private User following;

  private LocalDateTime followedAt;

  @PrePersist
  public void onCreate() {
      this.followedAt = LocalDateTime.now();
  }
}
