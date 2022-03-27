package com.example.crmenercom.service;

import com.example.crmenercom.dto.TechnologyDeployedDto;

import java.util.UUID;

public interface TechnologyDeployedService {

    TechnologyDeployedDto getById(Long id);

    TechnologyDeployedDto create(TechnologyDeployedDto technologyDeployedDto);

    TechnologyDeployedDto update(TechnologyDeployedDto technologyDeployedDto);

    TechnologyDeployedDto deleteById(Long id);
}
