package com.tns.post.service.impl;

import com.tns.post.model.Post;
import com.tns.post.repository.PostRepository;
import com.tns.post.service.IPostService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements IPostService {
    private final PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public Post createPost(Post post) {
        return this.postRepository.save(post);
    }

    @Override
    public Post getPost(Integer id) {
        return this.postRepository.findById(id).orElse(null);
    }

    @Override
    public List<Post> getAllPost() {
        return this.postRepository.findAll();
    }
}
