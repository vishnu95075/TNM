package com.tns.post.service;

import com.tns.post.entity.Post;

import java.util.List;

public interface IPostService {
    Post createPost(Post post);
    Post getPost(Integer id);
    List<Post> getAllPost();
}
