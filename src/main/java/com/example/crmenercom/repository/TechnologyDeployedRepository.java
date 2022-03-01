package com.example.crmenercom.repository;

import com.example.crmenercom.entity.TechnologyDeployedEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TechnologyDeployedRepository extends JpaRepository<TechnologyDeployedEntity, Integer> {
}
