package com.tnm.feed.service;

import com.tnm.feed.client.PostClient;
import com.tnm.feed.dto.PostDto;
//import com.tnm.feed.repository.PostRepository;
import com.tnm.feed.repository.FeedRepository;
import com.tnm.feed.repository.projection.PostWithUserProjection;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedService {

    private final PostClient postClient;
    private final FeedRepository feedRepository;

    public FeedService( PostClient postClient, FeedRepository feedRepository) {
        this.postClient = postClient;
        this.feedRepository = feedRepository;
    }


    public PostDto getFeedPost(String postId) {
        return postClient.getPostById(postId);
    }

    public List<PostDto> getAllFeedPost() {
        List<PostDto> postDtos = postClient.getAllPost();

        return postDtos;
    }
    public List<PostWithUserProjection> getAllPostsWithUsers() {
        return feedRepository.findPostsWithUserInfo();
    }
}