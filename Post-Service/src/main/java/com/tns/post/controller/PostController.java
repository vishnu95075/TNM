package com.tns.post.controller;

import com.tns.post.dto.PostDto;
import com.tns.post.service.impl.PostServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {
    private final PostServiceImpl postService;

    public PostController(PostServiceImpl postService) {
        this.postService = postService;
    }

    @PostMapping
    public PostDto createPost(@RequestBody PostDto postDto) {
        return postService.createPost(postDto);
    }

    @GetMapping
    public List<PostDto> getPosts() {
        return postService.getAllPosts();
    }


}