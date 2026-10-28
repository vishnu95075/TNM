package com.tns.post.repository;

import com.tns.post.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface PostRepository extends JpaRepository<PostEntity, String> {
    List<PostEntity> findByUserId(String userId);

    @Query(value = """
            SELECT *
            FROM posts
            WHERE :tagName = ANY(tag)
            """, nativeQuery = true)
    List<PostEntity> findByTagName(String tagName);
//    Page<Post> findByExpiresAtAfter(
//            LocalDateTime currentTime,
//            Pageable pageable
//    );

//    Page<Post> findByIsDeletedFalse(Pageable pageable);
//    List<Post> findByIsDeletedFalse();

}

