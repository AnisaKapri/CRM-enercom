package com.example.crmenercom.service.impl;

import com.example.crmenercom.dto.CompanyDto;
import com.example.crmenercom.entity.AddressEntity;
import com.example.crmenercom.entity.CompanyEntity;
import com.example.crmenercom.mapper.AddressMapper;
import com.example.crmenercom.mapper.CompanyMapper;
import com.example.crmenercom.repository.CompanyRepository;
import com.example.crmenercom.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.REQUIRED)
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository repository;

    @Override
    public CompanyDto getById(int id) {
        return CompanyMapper.toDto(repository.findById(id).orElse(null));

    }

    @Override
    public CompanyDto create(CompanyDto companyDto) {
        return CompanyMapper.toDto(repository.save(CompanyMapper.toEntity(companyDto)));

    }

    @Override
    public CompanyDto update(CompanyDto companyDto) {
        return CompanyMapper.toDto(repository.save(CompanyMapper.toEntity(companyDto)));
    }

    @Override
    public CompanyDto deleteById(int id) {
        CompanyEntity entity = repository.findById(id).orElse(null);
        if (entity == null) return null;
        repository.delete(entity);
        return CompanyMapper.toDto(entity);
    }
}
