package com.example.crmenercom.repository;

import com.example.crmenercom.entity.ContactPersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactPersonRepository extends JpaRepository<ContactPersonEntity, Long> {
}
