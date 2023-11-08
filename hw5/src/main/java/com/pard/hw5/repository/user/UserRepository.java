package com.pard.hw5.repository.user;

import com.pard.hw5.entity.user.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    boolean existsByUserEmail(String userEmail);
    UserEntity findByUserEmail(String userEmail);
}
