package com.tns.post.service.impl;

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

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public void createPost(RequestPostDto postDto) {
        PostEntity postEntity = PostMapper.mapToPostEntity(postDto);
        postRepository.save(postEntity);

    }

    public List<ResponsePostDto> getAllPosts() {

        return postRepository.findAll()
                .stream()
                .map(postEntity -> {
                    ResponsePostDto responsePostDto = new ResponsePostDto();
                    responsePostDto.setContent(postEntity.getContent());
                    responsePostDto.setMediaUrl(postEntity.getMediaUrl());
                    responsePostDto.setTag(postEntity.getTag());
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
            responsePostDto.setTag(postEntity.getTag());
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

    public void updatePost(String id, RequestPostDto postDto) {
        PostEntity postEntity = PostMapper.mapToPostEntity(postDto);
        postEntity.setId(id);
        postRepository.save(postEntity);
    }

    public List<ResponsePostDto> getAllPostsByUserId(String userId) {
        return postRepository.findByUserId(userId)
                .stream()
                .map(postEntity -> {
                    ResponsePostDto responsePostDto = new ResponsePostDto();
                    responsePostDto.setContent(postEntity.getContent());
                    responsePostDto.setMediaUrl(postEntity.getMediaUrl());
                    responsePostDto.setTag(postEntity.getTag());
                    return responsePostDto;
                })
                .collect(Collectors.toList());
    }
}
