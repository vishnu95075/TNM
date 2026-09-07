package com.tnm.feed.service;

import com.tnm.feed.dto.FeedResponse;
import com.tnm.feed.entity.Post;
import com.tnm.feed.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FeedService {

    private final FeedCacheService feedCacheService;
    private final PostRepository postRepository;

    public FeedResponse getUserFeed(UUID userId, Long maxTimestamp, int pageSize) {
        long cursor = (maxTimestamp != null) ? maxTimestamp : System.currentTimeMillis();

        Set<String> postIdStrings = feedCacheService.getFeedPage(userId, cursor, pageSize);

        if (postIdStrings.isEmpty()) {
            return new FeedResponse(List.of(), null);
        }

        List<UUID> postIds = postIdStrings.stream()
                .map(UUID::fromString)
                .collect(Collectors.toList());

        // 2. Hydrate Post details from PostgreSQL / Multi-get Cache
        List<Post> posts = postRepository.findAllByIdIn(postIds);

        // 3. Determine next cursor timestamp for infinite scroll
        Long nextCursor = posts.isEmpty() ? null : posts.get(posts.size() - 1).getCreatedAt().toEpochMilli() - 1;

        return new FeedResponse(posts, nextCursor);
    }
}