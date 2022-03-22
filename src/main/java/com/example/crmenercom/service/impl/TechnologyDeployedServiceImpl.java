package com.example.crmenercom.service.impl;

import com.example.crmenercom.dto.TechnologyDeployedDto;
import com.example.crmenercom.entity.TechnologyDeployedEntity;
import com.example.crmenercom.mapper.TechnologyDeployedMapper;
import com.example.crmenercom.repository.TechnologyDeployedRepository;
import com.example.crmenercom.service.TechnologyDeployedService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.REQUIRED)
public class TechnologyDeployedServiceImpl  implements TechnologyDeployedService {

    private final TechnologyDeployedRepository repository;

    @Override
    public TechnologyDeployedDto getById(int id) {
        return TechnologyDeployedMapper.toDto(repository.findById(id).orElse(null));
    }

    @Override
    public TechnologyDeployedDto create(TechnologyDeployedDto technologyDeployedDto) {
        return TechnologyDeployedMapper.toDto(repository.save(TechnologyDeployedMapper.toEntity(technologyDeployedDto)));
    }

    @Override
    public TechnologyDeployedDto update(TechnologyDeployedDto technologyDeployedDto) {
        return TechnologyDeployedMapper.toDto(repository.save(TechnologyDeployedMapper.toEntity(technologyDeployedDto)));
    }

    @Override
    public TechnologyDeployedDto deleteById(int id) {
        TechnologyDeployedEntity entity = repository.findById(id).orElse(null);
        if (entity == null) return null;
        repository.delete(entity);
        return TechnologyDeployedMapper.toDto(entity);
    }
}
