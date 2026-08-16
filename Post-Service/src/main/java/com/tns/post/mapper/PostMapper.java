package com.tns.post.mapper;

import com.tns.post.dto.RequestPostDto;
import com.tns.post.entity.PostEntity;

public class PostMapper {
    public static RequestPostDto mapToPostDto(PostEntity postEntity) {
        RequestPostDto postDto = new RequestPostDto();
        postDto.setContent(postEntity.getContent());
        postDto.setUserId(postEntity.getUserId());
        return postDto;
    }

    public static PostEntity mapToPostEntity(RequestPostDto postDto) {
        PostEntity postEntity = new PostEntity();
        postEntity.setContent(postDto.getContent());
        postEntity.setMediaUrl(postDto.getMediaUrl());
        postEntity.setUserId(postDto.getUserId());
        postEntity.setTag(postDto.getTag());
        return postEntity;
    }
}
