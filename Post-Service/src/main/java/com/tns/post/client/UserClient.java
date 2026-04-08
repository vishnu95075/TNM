package com.tns.post.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "USER-SERVICE")
public interface UserClient {

    @GetMapping("/api/dummy")
    List<User> getAllUser();
}
