package com.example.crmenercom.repository;

import com.example.crmenercom.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {
    @Override
    Optional<ProductEntity> findById(Integer integer);
    ProductEntity save(ProductEntity entity);
}
