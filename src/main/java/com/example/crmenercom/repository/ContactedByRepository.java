package com.example.crmenercom.repository;

import com.example.crmenercom.entity.ContactedByEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactedByRepository extends JpaRepository<ContactedByEntity, Integer> {
}
