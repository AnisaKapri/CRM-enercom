package com.example.crmenercom.repository;

import com.example.crmenercom.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Integer> {

    Optional<OrderEntity> findById(Integer id);
    OrderEntity save(OrderEntity entity);
}