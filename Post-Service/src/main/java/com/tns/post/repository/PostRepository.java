package com.tns.post.repository;

import com.tns.post.entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;


public interface PostRepository extends JpaRepository<Post, Long> {

//    Page<Post> findByExpiresAtAfter(
//            LocalDateTime currentTime,
//            Pageable pageable
//    );

//    Page<Post> findByIsDeletedFalse(Pageable pageable);
//    List<Post> findByIsDeletedFalse();

}

