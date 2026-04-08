package com.tns.user.service;

import com.tns.user.entity.User;

import java.util.List;

public interface IUserService {
   List<User> getAllUsers();
   User createUser(User user);
   void deleteUser(String id);
   User updateUser(User user);
}
