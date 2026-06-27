package com.tns.user.service;

import com.tns.user.entity.FollowEntity;

import java.util.List;

public interface IFollowService {
    void createFollow(FollowEntity followEntity);

    void removeFollow(String id);

    List<String> getAllFollower(String userId);
    List<String> getAllFollowing(String userId);
}
