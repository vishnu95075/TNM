package com.tns.user.repository;

import com.tns.user.entity.Dummy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DummyRepository extends JpaRepository<Dummy, Integer> {
}
