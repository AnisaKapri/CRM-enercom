package com.example.crmenercom.repository;

import com.example.crmenercom.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

    Optional<ProductEntity> findById(Long id);

    ProductEntity save(ProductEntity entity);

    @Query("SELECT p FROM ProductEntity p " +
            "INNER JOIN ClientEntity c on p.client.id = c.id " +
            "WHERE c.company = :clientCompany")
    List<ProductEntity> findAllByClientCompany(String clientCompany);
}
