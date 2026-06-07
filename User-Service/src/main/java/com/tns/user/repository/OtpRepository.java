package com.tns.user.repository;

import com.tns.user.entity.OTPEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OtpRepository extends JpaRepository<OTPEntity, Long> {

    Optional<OTPEntity> findByMobileNumber(String mobileNumber);
}
