package com.tns.user.controller;

import com.tns.user.entity.FollowEntity;
import com.tns.user.repository.FollowRepository;
import com.tns.user.service.IFollowService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/follow")
public class FollowController {
    private final IFollowService iFollowService;

    public FollowController(IFollowService iFollowService) {
        this.iFollowService = iFollowService;
    }

    @GetMapping("/following/{id}")
    public ResponseEntity<List<String>> getAllFollowing(@PathVariable String id) {
        System.out.println(id);
        return ResponseEntity.ok(iFollowService.getAllFollowing(id));
    }

    @GetMapping("/follower/{id}")
    public ResponseEntity<List<String>> getAllFollower(@PathVariable String id) {
        System.out.println(id);
        return ResponseEntity.ok(iFollowService.getAllFollower(id));
    }

    @PostMapping
    public ResponseEntity<String> createFollow(@RequestBody FollowEntity followEntity) {
        System.out.println(followEntity.getFollowerId() + " " + followEntity.getFollowingId());
        iFollowService.createFollow(followEntity);
        return ResponseEntity.ok("ok");
    }

    @DeleteMapping
    public ResponseEntity<String> deleteFollow(@RequestBody FollowEntity followEntity) {
        return ResponseEntity.ok("Done");
    }

}
