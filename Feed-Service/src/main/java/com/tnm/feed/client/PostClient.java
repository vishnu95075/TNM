package com.tnm.feed.client;

import com.tnm.feed.dto.PostDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "POST-SERVICE", url = "${application.config.post-service-url:http://localhost:8085}")
public interface PostClient {
    @GetMapping("/api/v1/posts/{id}")
    PostDto getPostById(@PathVariable("id") String id);

    @GetMapping("/api/posts")
    List<PostDto> getAllPost();
}
