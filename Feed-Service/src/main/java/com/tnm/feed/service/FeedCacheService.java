package com.tnm.feed.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Set;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FeedCacheService {

    private final StringRedisTemplate redisTemplate;
    private static final String FEED_KEY_PREFIX = "feed:";
    private static final int MAX_FEED_SIZE = 500;


    public void pushToFeed(UUID followerId, UUID postId, long timestampMillis) {
        String key = FEED_KEY_PREFIX + followerId;

        redisTemplate.opsForZSet().add(key, postId.toString(), timestampMillis);

        trimFeed(key);
    }


    public Set<String> getFeedPage(UUID userId, long maxTimestamp, int limit) {
        String key = FEED_KEY_PREFIX + userId;

        ZSetOperations<String, String> zSetOps = redisTemplate.opsForZSet();
        Set<String> postIds = zSetOps.reverseRangeByScore(
                key,
                0,
                maxTimestamp,
                0,
                limit
        );

        return postIds != null ? postIds : Collections.emptySet();
    }


    private void trimFeed(String key) {
        ZSetOperations<String, String> zSetOps = redisTemplate.opsForZSet();
        Long card = zSetOps.zCard(key);
        if (card != null && card > MAX_FEED_SIZE) {
            zSetOps.removeRange(key, 0, card - MAX_FEED_SIZE - 1);
        }
    }
}