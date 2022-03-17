package com.example.crmenercom.service.impl;

import com.example.crmenercom.dto.OperatorDto;
import com.example.crmenercom.entity.OperatorEntity;
import com.example.crmenercom.mapper.OperatorMapper;
import com.example.crmenercom.repository.OperatorRepository;
import com.example.crmenercom.service.OperatorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.REQUIRED)
public class OperatorServiceImpl implements OperatorService {

    private final OperatorRepository repository;

    @Override
    public OperatorDto getById(int id) {
        return OperatorMapper.toDto(repository.findById(id).orElse(null));
    }

    @Override
    public OperatorDto create(OperatorDto operatorDto) {
        return OperatorMapper.toDto(repository.save(OperatorMapper.toEntity(operatorDto)));
    }

    @Override
    public OperatorDto update(OperatorDto operatorDto) {
        return OperatorMapper.toDto(repository.save(OperatorMapper.toEntity(operatorDto)));
    }

    @Override
    public OperatorDto deleteById(int id) {
        OperatorEntity entity = repository.findById(id).orElse(null);
        if(entity == null) return null;
        repository.delete(entity);
        return OperatorMapper.toDto(entity);
    }
}
