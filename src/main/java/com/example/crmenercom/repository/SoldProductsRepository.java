package com.example.crmenercom.repository;

import com.example.crmenercom.entity.SoldProductsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SoldProductsRepository extends JpaRepository<SoldProductsEntity, Integer> {
}
