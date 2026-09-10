package com.tnm.feed.repository;

import com.tnm.feed.entity.PostEntity;
import com.tnm.feed.repository.projection.PostWithUserProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FeedRepository extends JpaRepository<PostEntity,String> {
    @Query(value = """
        SELECT 
            p.id AS id, 
            p.content AS content, 
            p.tag AS tag, 
            p.media_url AS mediaUrl, 
            p.created_at AS createdAt, 
            u.user_id AS userId, 
            u.username AS username, 
            u.full_name AS fullName 
        FROM posts p 
        INNER JOIN users u ON p.user_id = u.user_id
        """, nativeQuery = true)
    List<PostWithUserProjection> findPostsWithUserInfo();
}
