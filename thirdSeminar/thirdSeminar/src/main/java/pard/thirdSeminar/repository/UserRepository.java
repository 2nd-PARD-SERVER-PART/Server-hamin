package pard.thirdSeminar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pard.thirdSeminar.entity.UserEntity;

import java.util.List;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    boolean existsByUserEmail(String userEmail);
    boolean existsByUserEmailAndUserPassword(String userEmail, String userPassword);

    List<UserEntity> findTop3ByUserSignUptimeOrderBySignUptimeDesc();
}
