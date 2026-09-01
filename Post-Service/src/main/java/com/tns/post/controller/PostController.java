package com.tns.post.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.tns.post.common.constants.PostResponseConstants;
import com.tns.post.dto.RequestPostDto;
import com.tns.post.dto.ResponseMsgDto;
import com.tns.post.dto.ResponsePostDto;
import com.tns.post.service.MediaUploadService;
import com.tns.post.service.impl.PostServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {
    private final PostServiceImpl postService;
    private final MediaUploadService mediaUploadService;

    public PostController(PostServiceImpl postService, MediaUploadService mediaUploadService) {
        this.postService = postService;
        this.mediaUploadService = mediaUploadService;
    }


    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> createPost(
            @RequestPart(value = "files", required = false) MultipartFile[] files,
            @RequestPart("postDto") String postDtoString,
            ObjectMapper objectMapper) throws Exception {

        RequestPostDto postDto;
        try {
            postDto = objectMapper.readValue(postDtoString, RequestPostDto.class);
        } catch (JsonProcessingException e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(new ResponseMsgDto("Invalid JSON format for postDto", PostResponseConstants.FAILURE));
        }

        List<String> listOfUrls = new ArrayList<>();
        if (files != null) {
            for (MultipartFile file : files) {
                listOfUrls.add(mediaUploadService.uploadMedia(file));
            }
        }
        
        postDto.setMediaUrl(listOfUrls);
        postService.createPost(postDto);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseMsgDto(PostResponseConstants.POST_CREATED, PostResponseConstants.SUCCESS));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseMsgDto> updatePost(@PathVariable String id, @RequestBody RequestPostDto postDto) {
        postService.updatePost(id, postDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseMsgDto(PostResponseConstants.POST_CREATED, PostResponseConstants.SUCCESS));
    }


    @GetMapping
    public ResponseEntity<List<ResponsePostDto>> getAllPosts() {
        List<ResponsePostDto> responsePostDto = postService.getAllPosts();
        return ResponseEntity.status(HttpStatus.OK).body(responsePostDto);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<ResponsePostDto>> getAllPosts(@PathVariable String userId) {
        List<ResponsePostDto> responsePostDto = postService.getAllPostsByUserId(userId);
        return ResponseEntity.status(HttpStatus.OK).body(responsePostDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPostById(@PathVariable String id) {
        ResponsePostDto responsePostDto = postService.getPostById(id);
        if (responsePostDto != null) {
            return ResponseEntity.status(HttpStatus.OK).body(responsePostDto);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseMsgDto(PostResponseConstants.POST_NOT_FOUND, PostResponseConstants.FAIL));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseMsgDto> deletePost(@PathVariable String id) {
        System.out.println("Delete Controller " + id);
        boolean isDeleted = postService.deletePostById(id);
        if (isDeleted) {
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMsgDto(PostResponseConstants.POST_DELETED, PostResponseConstants.SUCCESS));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseMsgDto(PostResponseConstants.POST_NOT_FOUND, PostResponseConstants.FAIL));
        }
    }


}