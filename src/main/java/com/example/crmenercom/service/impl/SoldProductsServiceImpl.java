package com.example.crmenercom.service.impl;

import com.example.crmenercom.dto.SoldProductsDto;
import com.example.crmenercom.entity.AddressEntity;
import com.example.crmenercom.entity.SoldProductsEntity;
import com.example.crmenercom.mapper.AddressMapper;
import com.example.crmenercom.mapper.SoldProductsMapper;
import com.example.crmenercom.repository.SoldProductsRepository;
import com.example.crmenercom.service.SoldProductsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.REQUIRED)
public class SoldProductsServiceImpl implements SoldProductsService {

    private final SoldProductsRepository repository;

    @Override
    public SoldProductsDto getById(int id) {
        return SoldProductsMapper.toDto(repository.findById(id).orElse(null));
    }

    @Override
    public SoldProductsDto create(SoldProductsDto soldProductsDto) {
        return SoldProductsMapper.toDto(repository.save(SoldProductsMapper.toEntity(soldProductsDto)));
    }

    @Override
    public SoldProductsDto update(SoldProductsDto soldProductsDto) {
        return SoldProductsMapper.toDto(repository.save(SoldProductsMapper.toEntity(soldProductsDto)));

    }

    @Override
    public SoldProductsDto deleteById(int id) {
        SoldProductsEntity entity = repository.findById(id).orElse(null);
        if (entity == null) return null;
        repository.delete(entity);
        return SoldProductsMapper.toDto(entity);
    }
}
