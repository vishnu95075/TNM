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
//        long cursor = (maxTimestamp != null) ? maxTimestamp : System.currentTimeMillis();
//
//        Set<String> postIdStrings = feedCacheService.getFeedPage(userId, cursor, pageSize);
//
//        if (postIdStrings.isEmpty()) {
//            return new FeedResponse(List.of(), null);
//        }
//
//        List<UUID> postIds = postIdStrings.stream()
//                .map(UUID::fromString)
//                .collect(Collectors.toList());
//
//        List<Post> posts = postRepository.findAllByIdIn(postIds);
//
//        Long nextCursor = posts.isEmpty() ? null : posts.getLast().getCreatedAt().toEpochSecond(ZoneOffset.UTC);
//
//        return new FeedResponse(posts, nextCursor);
//    }



    public PostDto getFeedPost(String postId) {
        return postClient.getPostById(postId);
    }

    public List<PostDto> getAllFeedPost() {
        List<PostDto> postDtos = postClient.getAllPost();

        return postDtos;
    }
}