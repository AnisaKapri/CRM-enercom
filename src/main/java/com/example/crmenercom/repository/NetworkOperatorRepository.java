package com.example.crmenercom.repository;

import com.example.crmenercom.entity.NetworkOperatorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface NetworkOperatorRepository extends JpaRepository<NetworkOperatorEntity, Long> {

   Optional<NetworkOperatorEntity> findById(Integer id);
   NetworkOperatorEntity save(NetworkOperatorEntity entity);

   @Query("SELECT n FROM NetworkOperatorEntity n " +
           "INNER JOIN CountryEntity c ON n.country.id = c.id " +
           "WHERE c.name = :countryName")
   List<NetworkOperatorEntity> findAllByCountryName(String countryName);
}
