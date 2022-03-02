package com.example.crmenercom.service.impl;

import com.example.crmenercom.dto.AddressDto;
import com.example.crmenercom.entity.AddressEntity;
import com.example.crmenercom.mapper.AddressMapper;
import com.example.crmenercom.repository.AddressRepository;
import com.example.crmenercom.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.REQUIRED)
public class AddressServiceImpl implements AddressService {

    private final AddressRepository repository;

    @Override
    public AddressDto getById(int id) {
        return AddressMapper.toDto(repository.findById(id).orElse(null));
    }

    @Override
    public AddressDto create(AddressDto addressDto) {
        return AddressMapper.toDto(repository.save(AddressMapper.toEntity(addressDto)));
    }

    @Override
    public AddressDto update(AddressDto addressDto) {
        return AddressMapper.toDto(repository.save(AddressMapper.toEntity(addressDto)));
    }

    @Override
    public AddressDto deleteById(int id) {
        AddressEntity entity = repository.findById(id).orElse(null);
        if (entity == null) return null;
        repository.delete(entity);
        return AddressMapper.toDto(entity);
    }
}
