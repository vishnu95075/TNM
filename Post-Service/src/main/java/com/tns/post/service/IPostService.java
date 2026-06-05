package com.tns.post.service;

import com.tns.post.dto.RequestPostDto;

import java.util.List;

public interface IPostService {
    RequestPostDto createPost(RequestPostDto postDto);
    List<RequestPostDto> getAllPosts();

}
