package com.example.crmenercom.repository;

import com.example.crmenercom.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrderRepository extends JpaRepository<OrderEntity, Integer> {

    Optional<OrderEntity> findById(Integer id);
    OrderEntity save(OrderEntity entity);
}