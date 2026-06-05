package com.tns.post.controller;

import com.tns.post.common.constants.PostResponseConstants;
import com.tns.post.dto.PostDto;
import com.tns.post.dto.ResponseDto;
import com.tns.post.service.impl.PostServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/posts")
public class PostController {
    private final PostServiceImpl postService;

    public PostController(PostServiceImpl postService) {
        this.postService = postService;
    }

    @PostMapping
    public ResponseEntity<ResponseDto> createPost(@RequestBody PostDto postDto) {
         postService.createPost(postDto);
         return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDto(PostResponseConstants.CREATED_POST_MSG,PostResponseConstants.SUCCESS));
    }

    @GetMapping
    public String getPosts() {
        return postService.getAllPosts();
    }


}