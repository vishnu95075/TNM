package com.tns.user.repository;

import com.tns.user.entity.FollowEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FollowRepository extends JpaRepository<FollowEntity, String> {

    @Query(
            value = "select f.following_id from follow f where f.follower_id=:userId",
            nativeQuery = true
    )
    List<String> getFollowerUserIds(@Param("userId") String userId);

    @Query(
            value = "select f.follower_id from follow f where f.following_id=:userId",
            nativeQuery = true
    )
    List<String> getFollowingUserIds(@Param("userId") String userId);
}
