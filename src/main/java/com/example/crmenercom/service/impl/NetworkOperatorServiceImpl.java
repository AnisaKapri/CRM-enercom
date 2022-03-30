package com.example.crmenercom.service.impl;

import com.example.crmenercom.dto.CountryDto;
import com.example.crmenercom.dto.NetworkOperatorDto;
import com.example.crmenercom.mapper.CountryMapper;
import com.example.crmenercom.mapper.NetworkOperatorMapper;
import com.example.crmenercom.repository.NetworkOperatorRepository;
import com.example.crmenercom.service.NetworkOperatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.NonUniqueResultException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class NetworkOperatorServiceImpl implements NetworkOperatorService {

    private final NetworkOperatorRepository repository;

    @Autowired
    public NetworkOperatorServiceImpl(NetworkOperatorRepository repository) {
        this.repository = repository;
    }

    @Override
    public Boolean contains(NetworkOperatorDto networkOperator) {
        return selectAll().contains(networkOperator);
    }

    @Override
    public Boolean contains(CountryDto country) {
        return selectAll().stream().anyMatch(networkOperator ->
                country.getName().equals(networkOperator.getCountry()));
    }

    @Override
    public Long getNumOfNetworkOperators(CountryDto country) {
        return selectAll().stream()
                .map(NetworkOperatorDto::getCountry)
                .filter(country::equals)
                .count();
    }



    @Override
    public NetworkOperatorDto findById(Long id) {
        return repository.findById(id)
                .map(NetworkOperatorMapper::toDto).orElse(null);
    }

    @Override
    public List<NetworkOperatorDto> selectAll() {
        return repository.findAll()
                .stream().map(NetworkOperatorMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<NetworkOperatorDto> selectAllByCountry(String country) {
        return repository.findAllByCountryName(country)
                .stream().map(NetworkOperatorMapper::toDto)
                .collect(Collectors.toList());
    }


    @Override
    public NetworkOperatorDto add(NetworkOperatorDto networkOperator) throws NonUniqueResultException {
        if (isUnique(networkOperator))
            throw new NonUniqueResultException(networkOperator.getName());
        return NetworkOperatorMapper.toDto(repository.save(NetworkOperatorMapper.toEntity(networkOperator)));
    }

    @Override
    public NetworkOperatorDto overwrite(NetworkOperatorDto networkOperator) {
        return NetworkOperatorMapper.toDto(repository.save(NetworkOperatorMapper.toEntity(networkOperator)));
    }

    @Override
    public Boolean isUnique(NetworkOperatorDto newNetworkOperator) {
        return selectAll().stream().noneMatch(networkOperator ->
                networkOperator.equalsLogically(newNetworkOperator));
    }


    @Override
    public NetworkOperatorDto delete(NetworkOperatorDto networkOperator) {
        repository.delete(NetworkOperatorMapper.toEntity(networkOperator));
        return networkOperator;
    }

    @Override
    public NetworkOperatorDto deleteById(Long id) {
        return delete(findById(id));
    }

    @Override
    public NetworkOperatorDto update(NetworkOperatorDto updated) {
        return NetworkOperatorMapper.toDto(repository
                .save(NetworkOperatorMapper.toEntity(updated)));
    }

    @Override
    public CountryDto updateCountry(CountryDto current, CountryDto updated) {
        if (contains(current)) {
            for (NetworkOperatorDto networkOperator : selectAll()) {
                if (current.equals(networkOperator.getCountry())) {
                    networkOperator.setCountry(CountryMapper.toEntity(updated));
                    overwrite(networkOperator);
                }
            }
            return updated;
        }
        return null;
    }


}
