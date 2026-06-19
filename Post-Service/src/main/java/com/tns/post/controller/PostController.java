package com.tns.post.controller;

import com.tns.post.common.constants.PostResponseConstants;
import com.tns.post.dto.RequestPostDto;
import com.tns.post.dto.ResponseDto;
import com.tns.post.dto.ResponsePostDto;
import com.tns.post.service.impl.PostServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<ResponseDto> createPost(@RequestBody RequestPostDto postDto) {
        postService.createPost(postDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDto(PostResponseConstants.POST_CREATED, PostResponseConstants.SUCCESS));
    }

    @GetMapping
    public ResponseEntity<List<ResponsePostDto>> getPosts() {
        List<ResponsePostDto> responsePostDto = postService.getAllPosts();
        return ResponseEntity.status(HttpStatus.OK).body(responsePostDto);
    }

    @GetMapping("/auth")
    public String getUserAuth(@RequestHeader(value = "Authorization",required = false) String authHeader) {
//        Claims claims = extractAllClaims(token);
        if (authHeader==null)
            return "ResponseEntity.status(HttpStatus.OK).body(responsePostDto)  No Auth: ";
        else{
//            Claims claims = extractAllClaims(token);
            return "Repost Auth: "+authHeader;
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPostById(@PathVariable Long id) {
        ResponsePostDto responsePostDto = postService.getPostById(id);
        if (responsePostDto != null) {
            return ResponseEntity.status(HttpStatus.OK).body(responsePostDto);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseDto(PostResponseConstants.POST_NOT_FOUND, PostResponseConstants.FAIL));
        }

    }


    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDto> deletePost(@PathVariable Long id) {
        System.out.println("Delete Controller " + id);
        boolean isDeleted = postService.deletePostById(id);
        if (isDeleted) {
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto(PostResponseConstants.POST_DELETED, PostResponseConstants.SUCCESS));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseDto(PostResponseConstants.POST_NOT_FOUND, PostResponseConstants.FAIL));
        }

    }


}