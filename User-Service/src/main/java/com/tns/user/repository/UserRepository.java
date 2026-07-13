package com.tns.user.repository;

import com.tns.user.entity.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface UserRepository extends JpaRepository<UserProfile,String> {
    UserProfile findByUserName(String userName);

    @Modifying
    @Transactional
    @Query("UPDATE UserProfile e SET e.profilePicUrl = :url WHERE e.userName = :userName")
    int updateProfilePicUrl(@Param("userName") String username, @Param("url") String url);
}
