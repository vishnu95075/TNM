package com.tns.post.repository;

import com.tns.post.entity.Post;
import com.tns.post.model.PostModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;


public interface PostRepository extends JpaRepository<PostModel, Long> {

    Page<PostModel> findByExpiresAtAfter(
            LocalDateTime currentTime,
            Pageable pageable
    );

    Page<PostModel> findByIsDeletedFalse(Pageable pageable);
    List<Post> findByIsDeletedFalse();

}

