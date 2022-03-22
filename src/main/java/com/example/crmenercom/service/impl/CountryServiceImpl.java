package com.example.crmenercom.service.impl;

import com.example.crmenercom.dto.CountryDto;
import com.example.crmenercom.entity.CountryEntity;
import com.example.crmenercom.mapper.CountryMapper;
import com.example.crmenercom.repository.CountryRepository;
import com.example.crmenercom.service.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.REQUIRED)
public class CountryServiceImpl implements CountryService {

    private final CountryRepository repository;

    @Override
    public CountryDto getById(int id) {
        return CountryMapper.toDto(repository.findById(id).orElse(null));
    }

    @Override
    public CountryDto create(CountryDto countryDto) {
        return CountryMapper.toDto(repository.save(CountryMapper.toEntity(countryDto)));
    }

    @Override
    public CountryDto update(CountryDto countryDto) {
        return CountryMapper.toDto(repository.save(CountryMapper.toEntity(countryDto)));
    }

    @Override
    public CountryDto deleteById(int id) {
        CountryEntity entity = repository.findById(id).orElse(null);
        if (entity == null) return null;
        repository.delete(entity);
        return CountryMapper.toDto(entity);
    }
}
