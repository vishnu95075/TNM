package com.tns.user.service.impl;

import com.tns.user.entity.User;
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
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User createUser(User user) {
        user.setCreatedAt(LocalDateTime.now());
        user.setUpdatedAt(LocalDateTime.now());
        return userRepository.save(user);

    }

    @Override
    public void deleteUser(String id) {
       userRepository.deleteById(id);
    }

    @Override
    public User updateUser(User user) {
        String id = user.getId();
        User user1 = userRepository.findById(id).orElseThrow(()-> new RuntimeException("User Can not found by id "+id));
      return  userRepository.save(user);
    }
}
