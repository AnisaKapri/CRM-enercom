package com.example.crmenercom.repository;

import com.example.crmenercom.entity.SalesQuantityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalesQuantityRepository extends JpaRepository<SalesQuantityEntity, Long> {
}
