package com.tns.user.service.impl;

import com.tns.user.entity.User;
import com.tns.user.repository.UserRepository;
import com.tns.user.service.IUserService;

import java.util.List;

public class UserServiceImpl implements IUserService {
    private UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return List.of();
    }
}
