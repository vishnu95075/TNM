package com.tns.post.service.impl;

import com.tns.post.common.constants.PostResponseConstants;
import com.tns.post.dto.PostDto;
import com.tns.post.dto.ResponseDto;
import com.tns.post.entity.PostEntity;
import com.tns.post.mapper.PostMapper;
import com.tns.post.model.PostModel;
import com.tns.post.repository.PostRepository;
import com.tns.post.service.IPostService;
import jakarta.persistence.Entity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl{
    private final PostRepository postRepository;


    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

  // Create post
    public void createPost(PostDto postDto) {

        PostEntity postEntity  = PostMapper.mapToPostEntity(postDto);
        PostEntity savedPost = postRepository.save(postEntity);

    }

//    // Get all posts
//    public List<PostDto> getAllPosts() {
//
//        return postRepository.findAll()
//                .stream()
//                .map(post -> {
//                    PostDto dto = new PostDto();
//                    dto.setContent(post.getContent());
//                    dto.setUserName(post.getUserName());
//                    return dto;
//                })
//                .collect(Collectors.toList());
//    }
//    public Page<PostModel> getPosts(int page, int size) {
//
//        Pageable pageable =
//                PageRequest.of(page, size);
//
//        return postRepository
//                .findByIsDeletedFalse(pageable);
//    }
}
