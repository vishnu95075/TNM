package com.tnm.feed.controller;

import com.tnm.feed.dto.FeedResponse;
import com.tnm.feed.service.FeedService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/feed")
@RequiredArgsConstructor
public class FeedController {

    private final FeedService feedService;

    @GetMapping
    public ResponseEntity<FeedResponse> getFeed(
            @RequestHeader("X-User-Id") UUID userId,
            @RequestParam(required = false) Long maxTimestamp,
            @RequestParam(defaultValue = "20") int limit) {

        FeedResponse feed = feedService.getUserFeed(userId, maxTimestamp, limit);
        return ResponseEntity.ok(feed);
    }
}