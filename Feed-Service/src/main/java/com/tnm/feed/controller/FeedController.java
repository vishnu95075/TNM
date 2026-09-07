package com.tnm.feed.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/feed")
public class FeedController {

    @GetMapping
    public String getHello(){
        return "Feed Controller test";
    }
}
