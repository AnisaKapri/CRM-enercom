package com.example.crmenercom.service.impl;

import com.example.crmenercom.dto.NetworkOperatorDto;
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
    public List<NetworkOperatorDto> selectAll() {
        return repository.findAll()
                .stream().map(NetworkOperatorMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public NetworkOperatorDto findByName(String name) {
        return repository.findByName(name)
                .map(NetworkOperatorMapper::toDto)
                .orElse(null);
    }

    @Override
    public Boolean exist(NetworkOperatorDto networkOperator) {
        return repository.existsByName(networkOperator.getName());
    }

    @Override
    public NetworkOperatorDto add(NetworkOperatorDto newNetworkOperator)
            throws NonUniqueResultException {
        if (exist(newNetworkOperator))
            throw new NonUniqueResultException(newNetworkOperator.getName());
        return NetworkOperatorMapper.toDto(repository
                .save(NetworkOperatorMapper.toEntity(newNetworkOperator)));
    }

    @Override
    public NetworkOperatorDto delete(NetworkOperatorDto networkOperator) {
        repository.delete(NetworkOperatorMapper.toEntity(networkOperator));
        return networkOperator;
    }

    @Override
    public NetworkOperatorDto update(NetworkOperatorDto current, NetworkOperatorDto updated)
            throws NonUniqueResultException {
        NetworkOperatorDto newNetworkOperator = add(updated);
        delete(current);
        return newNetworkOperator;
    }

    @Override
    public NetworkOperatorDto delete(String name) {
        return delete(findByName(name));
    }

}
