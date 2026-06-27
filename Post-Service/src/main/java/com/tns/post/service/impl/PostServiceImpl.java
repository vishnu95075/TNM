package com.tns.post.service.impl;

import com.tns.post.config.JwtService;
import com.tns.post.dto.RequestPostDto;
import com.tns.post.dto.ResponsePostDto;
import com.tns.post.entity.PostEntity;
import com.tns.post.exception.ResourceNotFoundException;
import com.tns.post.mapper.PostMapper;
import com.tns.post.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl {
    private final PostRepository postRepository;
    private final JwtService  jwtService;

    public PostServiceImpl(PostRepository postRepository, JwtService jwtService) {
        this.postRepository = postRepository;
        this.jwtService = jwtService;
    }

    public void createPost(RequestPostDto postDto, String authHeader) {

        PostEntity postEntity = PostMapper.mapToPostEntity(postDto);
        postEntity.setUserId(jwtService.extractUserId(authHeader));

        postRepository.save(postEntity);

    }

    public List<ResponsePostDto> getAllPosts() {

        return postRepository.findAll()
                .stream()
                .map(postEntity -> {
                    ResponsePostDto responsePostDto = new ResponsePostDto();
                    responsePostDto.setContent(postEntity.getContent());
                    responsePostDto.setMediaUrl(postEntity.getMediaUrl());
                    return responsePostDto;
                })
                .collect(Collectors.toList());
    }

    public ResponsePostDto getPostById(String id) {
        boolean isExist = postRepository.existsById(id);
        if (isExist) {
            PostEntity postEntity = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "Id", id));
            ResponsePostDto responsePostDto = new ResponsePostDto();
            responsePostDto.setContent(postEntity.getContent());
            responsePostDto.setMediaUrl(postEntity.getMediaUrl());
            return responsePostDto;
        }
        return null;
    }
//    public Page<PostModel> getPosts(int page, int size) {
//
//        Pageable pageable =
//                PageRequest.of(page, size);
//
//        return postRepository
//                .findByIsDeletedFalse(pageable);
//    }

    public boolean deletePostById(String id) {
        boolean isExist = postRepository.existsById(id);
        if (isExist) {
            postRepository.deleteById(id);
        }
        return isExist;
    }
}
