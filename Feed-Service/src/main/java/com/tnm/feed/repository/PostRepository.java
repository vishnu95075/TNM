package com.tnm.feed.repository;

import com.tnm.feed.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

public interface PostRepository extends JpaRepository<Post, String> {
    List<Post> findAllByIdIn(Collection<UUID> ids);
}
