package com.example.crmenercom.service.impl;

import com.example.crmenercom.dto.CountryDto;
import com.example.crmenercom.dto.NetworkOperatorDto;
import com.example.crmenercom.entity.CountryEntity;
import com.example.crmenercom.mapper.CountryMapper;
import com.example.crmenercom.repository.CountryRepository;
import com.example.crmenercom.service.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NonUniqueResultException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryRepository repository;

    @Autowired
    private CountryServiceImpl(CountryRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<CountryDto> selectAll() {
        return repository.findAll()
                .stream().map(CountryMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public CountryDto findByName(String name) {
        return repository.findByName(name)
                .map(CountryMapper::toDto)
                .orElse(null);
    }

    @Override
    public Boolean exists(CountryDto country) {
        return repository.existsByName(country.getName());
    }

    @Override
    public CountryDto add(CountryDto newCountry) throws NonUniqueResultException {
        if (exists(newCountry))
            throw new NonUniqueResultException(newCountry.getName());
        return CountryMapper.toDto(repository.save(CountryMapper.toEntity(newCountry)));
    }


    @Override
    public CountryDto delete(CountryDto country) {
        repository.delete(CountryMapper.toEntity(country));
        return country;
    }


    @Override
    public CountryDto update(CountryDto current, CountryDto updated) throws NonUniqueResultException {
        CountryDto newCnt = add(updated);
        delete(current);
        return newCnt;
    }


    @Override
    public CountryDto delete(String name) {
        return delete(findByName(name));
    }



}
