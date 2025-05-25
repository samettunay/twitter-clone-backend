package com.y.twitter_clone.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.y.twitter_clone.entity.Follow;
import com.y.twitter_clone.entity.User;

public interface FollowRepository extends JpaRepository<Follow, UUID> {
    List<Follow> findByFollower(User user);
    List<Follow> findByFollowing(User user);
    boolean existsByFollowerAndFollowing(User follower, User following);
    void deleteByFollowerAndFollowing(User follower, User following);
}
