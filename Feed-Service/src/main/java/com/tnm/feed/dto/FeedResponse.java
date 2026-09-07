package com.tnm.feed.dto;

import com.tnm.feed.entity.Post;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class FeedResponse {
    private List<Post> posts;
    private Long nextCursorTimestamp;
}