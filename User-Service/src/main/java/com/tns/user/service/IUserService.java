package com.tns.user.service;

import com.tns.user.entity.UserEntity;

import java.util.List;

public interface IUserService {
   List<UserEntity> getAllUsers();
   UserEntity createUser(UserEntity user);
   void deleteUser(Long id);
   UserEntity updateUser(UserEntity user);
}
