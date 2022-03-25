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
    public Boolean contains(NetworkOperatorDto networkOperator) {
        return selectAll().stream().anyMatch(country ->
                networkOperator.getName().equals(country.getNetworkOperator()));
    }


    @Override
    public Long getNumOfCountries(NetworkOperatorDto networkOperator) {
        return selectAll().stream()
                .map(CountryDto::getNetworkOperator)
                .filter(networkOperator::equals)
                .count();
    }


    @Override
    public CountryDto findById(int id) {
        return repository.findById(id)
                .map(CountryMapper::toDto)
                .orElse(null);
    }

    @Override
    public List<CountryDto> selectAll() {
        return repository.findAll()
                .stream().map(CountryMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<CountryDto> selectAllByNetworkOperator(String networkOperator) {
        return repository.findAll()
                .stream().map(CountryMapper::toDto)
                .filter(country -> country.isOf(networkOperator))
                .collect(Collectors.toList());
    }


    @Override
    public CountryDto add(CountryDto country) throws NonUniqueResultException {
        if (isUnique(country)) throw new NonUniqueResultException(country.getName());
        return CountryMapper.toDto(repository.save(CountryMapper.toEntity(country)));
    }


    @Override
    public Boolean isUnique(CountryDto newCountry) {
        return selectAll().stream().noneMatch(country -> country.equalsLogically(newCountry));
    }


    @Override
    public CountryDto delete(CountryDto country) {
        repository.delete(CountryMapper.toEntity(country));
        return country;
    }

    @Override
    public CountryDto deleteById(int id) {
        CountryEntity entity = repository.findById(id).orElse(null);
        if (entity == null) return null;
        repository.delete(entity);
        return CountryMapper.toDto(entity);
    }

    @Override
    public CountryDto update(CountryDto countryDto) {
        return CountryMapper.toDto(repository.save(CountryMapper.toEntity(countryDto)));
    }

    @Override
    public NetworkOperatorDto updateNetworkOperator(NetworkOperatorDto current, NetworkOperatorDto updated) {

        if (contains(current)) {
            for (CountryDto country : selectAll()) {
                if (current.equals(country.getNetworkOperator())) {
                    country.setNetworkOperator(updated);
                    overwrite(country);
                }
            }
            return updated;
        }
        return null;
    }

    @Override
    public CountryDto overwrite(CountryDto country) {
        return CountryMapper.toDto(repository.save(CountryMapper.toEntity(country)));
    }

}
