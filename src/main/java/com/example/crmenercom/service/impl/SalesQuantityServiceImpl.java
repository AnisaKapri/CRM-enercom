package com.example.crmenercom.service.impl;

import com.example.crmenercom.dto.SalesQuantityDto;
import com.example.crmenercom.entity.SalesQuantityEntity;
import com.example.crmenercom.mapper.SalesQuantityMapper;
import com.example.crmenercom.repository.SalesQuantityRepository;
import com.example.crmenercom.service.SalesQuantityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.REQUIRED)
public class SalesQuantityServiceImpl implements SalesQuantityService {

    private final SalesQuantityRepository repository;

    @Override
    public SalesQuantityDto getById(Long id) {
        return SalesQuantityMapper.toDto(repository.findById(id).orElse(null));
    }

    @Override
    public SalesQuantityDto create(SalesQuantityDto salesQuantityDto) {
        return SalesQuantityMapper.toDto(repository.save(SalesQuantityMapper.toEntity(salesQuantityDto)));
    }

    @Override
    public SalesQuantityDto update(SalesQuantityDto salesQuantityDto) {
        return SalesQuantityMapper.toDto(repository.save(SalesQuantityMapper.toEntity(salesQuantityDto)));
    }

    @Override
    public SalesQuantityDto deleteById(Long id) {
        SalesQuantityEntity entity = repository.findById(id).orElse(null);
        if (entity == null) return null;
        repository.delete(entity);
        return SalesQuantityMapper.toDto(entity);
    }
}
