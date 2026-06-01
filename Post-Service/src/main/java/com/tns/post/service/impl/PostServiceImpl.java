package com.tns.post.service.impl;

import com.tns.post.dto.PostDto;
import com.tns.post.model.PostModel;
import com.tns.post.repository.PostRepository;
import com.tns.post.service.IPostService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements IPostService {
    private final PostRepository postRepository;


    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    // Create post
    public PostDto createPost(PostDto postDto) {

        PostModel post = new PostModel();

        post.setContent(postDto.getContent());
        post.setUserName(postDto.getUserName());
        post.setCreatedAt(LocalDateTime.now());

        PostModel savedPost = postRepository.save(post);

        PostDto response = new PostDto();
        response.setContent(savedPost.getContent());
        response.setUserName(savedPost.getUserName());

        return response;
    }

    // Get all posts
    public List<PostDto> getAllPosts() {

        return postRepository.findAll()
                .stream()
                .map(post -> {
                    PostDto dto = new PostDto();
                    dto.setContent(post.getContent());
                    dto.setUserName(post.getUserName());
                    return dto;
                })
                .collect(Collectors.toList());
    }
    public Page<PostModel> getPosts(int page, int size) {

        Pageable pageable =
                PageRequest.of(page, size);

        return postRepository
                .findByIsDeletedFalse(pageable);
    }
}
