package com.tns.post.repository;

import com.tns.post.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PostRepository extends JpaRepository<PostEntity, String> {

//    Page<Post> findByExpiresAtAfter(
//            LocalDateTime currentTime,
//            Pageable pageable
//    );

//    Page<Post> findByIsDeletedFalse(Pageable pageable);
//    List<Post> findByIsDeletedFalse();

}

