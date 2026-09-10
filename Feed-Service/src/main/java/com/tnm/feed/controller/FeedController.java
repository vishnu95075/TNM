package com.tnm.feed.controller;

import com.tnm.feed.dto.PostDto;
import com.tnm.feed.repository.projection.PostWithUserProjection;
import com.tnm.feed.service.FeedService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/feed")
@RequiredArgsConstructor
public class FeedController {

    private final FeedService feedService;

    @GetMapping
    public ResponseEntity<List<PostDto>> getFeed(
//            @RequestHeader("X-User-Id") String userId,
//            @RequestParam(required = false) Long maxTimestamp,
//            @RequestParam(defaultValue = "20") int limit
    ) {

//        FeedResponse feed = feedService.getUserFeed(userId, maxTimestamp, limit);
        List<PostDto> p = feedService.getAllFeedPost();
        return ResponseEntity.ok(p);
    }


    @GetMapping("all")
    public ResponseEntity<List<PostWithUserProjection>> getPostsWithUsersById() {
        List<PostWithUserProjection> posts = feedService.getAllPostsWithUsers();
        return ResponseEntity.ok(posts);
    }
}