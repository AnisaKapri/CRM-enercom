package com.example.crmenercom.repository;

import com.example.crmenercom.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    Boolean existsByEmail(String email);
    Optional<UserEntity> findById(Integer id);
    Optional<UserEntity> findByEmail(String email);
    UserEntity save(UserEntity entity);
}
