package com.example.crmenercom.repository;

import com.example.crmenercom.entity.CountryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CountryRepository extends JpaRepository<CountryEntity, Integer> {

    @Override
    Optional<CountryEntity> findById(Integer integer);
    CountryEntity save(CountryEntity entity);
}
