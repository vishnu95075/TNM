package com.tns.user.service;

import com.tns.user.entity.UserProfile;

import java.util.List;

public interface IUserService {
    List<UserProfile> getAllUsers();

    UserProfile createUser(UserProfile user);

    void deleteUser(String userName);

    UserProfile updateUser(UserProfile user);
}
