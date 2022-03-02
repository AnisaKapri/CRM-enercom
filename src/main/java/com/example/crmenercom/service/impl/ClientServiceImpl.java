package com.example.crmenercom.service.impl;

import com.example.crmenercom.dto.ClientDto;
import com.example.crmenercom.entity.ClientEntity;
import com.example.crmenercom.mapper.ClientMapper;
import com.example.crmenercom.repository.ClientRepository;
import com.example.crmenercom.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.REQUIRED)

public class ClientServiceImpl implements ClientService {

    private final ClientRepository repository;


    @Override
    public ClientDto getById(int id) {
        return ClientMapper.toDto(repository.findById(id).orElse(null));
    }

    @Override
    public ClientDto create(ClientDto clientDto) {
        return ClientMapper.toDto(repository.save(ClientMapper.toEntity(clientDto)));
    }

    @Override
    public ClientDto update(ClientDto clientDto) {
        return ClientMapper.toDto(repository.save(ClientMapper.toEntity(clientDto)));
    }

    @Override
    public ClientDto deleteById(int id) {
        ClientEntity entity = repository.findById(id).orElse(null);
        if (entity == null) return null;
        repository.delete(entity);
        return ClientMapper.toDto(entity);
    }

}
