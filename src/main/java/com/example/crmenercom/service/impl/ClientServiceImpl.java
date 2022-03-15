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

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.REQUIRED)

public class ClientServiceImpl implements ClientService {

    private final ClientRepository repository;


    @Override
    public List<ClientDto> selectAll() {
        return repository.findAll()
                .stream().map(ClientMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public ClientDto findById(Integer id) {
        return repository.findById(id)
                .map(ClientMapper::toDto)
                .orElse(null);
    }

    @Override
    public ClientDto getById(int id) {
        return ClientMapper.toDto(repository.findById(id).orElse(null));
    }

    @Override
    public ClientDto create(ClientDto client) {
        return ClientMapper.toDto(repository.save(ClientMapper.toEntity(client)));
    }

    @Override
    public ClientDto update(ClientDto clientDto) {
        return ClientMapper.toDto(repository.save(ClientMapper.toEntity(clientDto)));
    }


    @Override
    public ClientDto deleteById(Integer id) {
        ClientEntity client = repository.findById(id).orElse(null);
        if (client != null) {
            ClientDto dto = ClientMapper.toDto(client);
            repository.delete(client);
            return dto;
        } else {
            return null;
        }
    }
}
