package com.tns.user.service.impl;

import com.tns.user.entity.UserEntity;
import com.tns.user.repository.UserRepository;
import com.tns.user.service.IUserService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserServiceImpl implements IUserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public UserEntity createUser(UserEntity user) {
        user.setCreatedAt(LocalDateTime.now());
        user.setUpdatedAt(LocalDateTime.now());
        return userRepository.save(user);

    }

    @Override
    public void deleteUser(Long id) {
       userRepository.deleteById(id);
    }

    @Override
    public UserEntity updateUser(UserEntity user) {
        Long id = user.getId();
        UserEntity user1 = userRepository.findById(id).orElseThrow(()-> new RuntimeException("User Can not found by id "+id));
      return  userRepository.save(user);
    }
}
