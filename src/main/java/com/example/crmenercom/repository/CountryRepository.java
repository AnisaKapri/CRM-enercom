package com.example.crmenercom.repository;

import com.example.crmenercom.entity.CountryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CountryRepository extends JpaRepository<CountryEntity, Long> {

    Boolean existsByName(String name);
    List<CountryEntity> findAll();
    Optional<CountryEntity> findByName(String name);
    CountryEntity save(CountryEntity entity);
}
