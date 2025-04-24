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
@Table(name = "replies")
public class Reply {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  private User user;

  @ManyToOne
  private Tweet tweet;

  @Column(nullable = false, length = 280)
  private String content;

  private LocalDateTime repliedAt = LocalDateTime.now();
}
