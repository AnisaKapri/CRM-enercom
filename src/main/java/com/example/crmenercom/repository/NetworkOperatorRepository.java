package com.example.crmenercom.repository;

import com.example.crmenercom.entity.NetworkOperatorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface NetworkOperatorRepository extends JpaRepository<NetworkOperatorEntity, String> {

    Boolean existsByName(String name);
    List<NetworkOperatorEntity> findAll();
    Optional<NetworkOperatorEntity> findByName(String name);
    NetworkOperatorEntity save(NetworkOperatorEntity entity);
}
