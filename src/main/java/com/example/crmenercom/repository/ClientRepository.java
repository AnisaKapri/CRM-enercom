package com.example.crmenercom.repository;

import com.example.crmenercom.entity.ClientEntity;
import com.example.crmenercom.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<ClientEntity, Long> {

    Boolean existsByCompany(String company);
    Optional<ClientEntity> findById(Long id);
    Optional<ClientEntity> findByCompany(String company);
    ClientEntity save(ClientEntity entity);
}
