package com.tns.user.repository;

import com.tns.user.entity.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserProfile,String> {
    UserProfile findByUserName(String userName);
}
