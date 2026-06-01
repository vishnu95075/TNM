package com.tns.post.service;

import com.tns.post.dto.PostDto;

import java.util.List;

public interface IPostService {
    PostDto createPost(PostDto postDto);
    List<PostDto> getAllPosts();

}
