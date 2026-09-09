package com.tnm.feed.service;

import com.tnm.feed.client.PostClient;
import com.tnm.feed.dto.FeedResponse;
import com.tnm.feed.dto.PostDto;
import com.tnm.feed.entity.Post;
//import com.tnm.feed.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.ZoneOffset;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FeedService {

    private final FeedCacheService feedCacheService;
//    private final PostRepository postRepository;
    private final PostClient postClient;


//    public FeedResponse getUserFeed(String userId, Long maxTimestamp, int pageSize) {

//    }



    public PostDto getFeedPost(String postId) {
        return postClient.getPostById(postId);
    }

    public List<PostDto> getAllFeedPost() {
        List<PostDto> postDtos = postClient.getAllPost();

        return postDtos;
    }
}