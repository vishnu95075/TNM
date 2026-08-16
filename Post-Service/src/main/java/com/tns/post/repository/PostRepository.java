package com.tns.post.repository;

import com.tns.post.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Arrays;
import java.util.List;


public interface PostRepository extends JpaRepository<PostEntity, String> {
    List<PostEntity> findByUserId(String userId);

//    Page<Post> findByExpiresAtAfter(
//            LocalDateTime currentTime,
//            Pageable pageable
//    );

//    Page<Post> findByIsDeletedFalse(Pageable pageable);
//    List<Post> findByIsDeletedFalse();

}

