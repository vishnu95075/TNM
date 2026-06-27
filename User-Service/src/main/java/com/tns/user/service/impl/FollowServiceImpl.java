package com.tns.user.service.impl;

import com.tns.user.entity.FollowEntity;
import com.tns.user.repository.FollowRepository;
import com.tns.user.service.IFollowService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FollowServiceImpl implements IFollowService {

    private final FollowRepository followRepository;

    public FollowServiceImpl(FollowRepository followRepository) {
        this.followRepository = followRepository;
    }

    @Override
    public void createFollow(FollowEntity followEntity) {

    }

    @Override
    public void removeFollow(String id) {

    }

    @Override
    public List<String> getAllFollower(String userId) {
        return followRepository.getFollowerUserIds(userId);
    }


    @Override
    public List<String> getAllFollowing(String userId) {
        return followRepository.getFollowingUserIds(userId);
    }


}
