package com.tns.post.mapper;

import com.tns.post.dto.PostDto;
import com.tns.post.entity.PostEntity;

public class PostMapper {
    public static PostDto mapToPostDto(PostEntity postEntity) {
        PostDto postDto = new PostDto();
        postDto.setContent(postEntity.getContent());
        postDto.setUserId(postEntity.getUserId());
        return postDto;
    }

    public static PostEntity mapToPostEntity(PostDto postDto) {
        PostEntity postEntity = new PostEntity();
        postEntity.setContent(postDto.getContent());
        postEntity.setMediaUrl(postDto.getMediaUrl());
        postEntity.setUserId(postDto.getUserId());
        return postEntity;
    }
}
