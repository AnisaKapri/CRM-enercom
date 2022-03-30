package com.example.crmenercom.service.impl;

import com.example.crmenercom.dto.ClientDto;
import com.example.crmenercom.entity.ClientEntity;
import com.example.crmenercom.mapper.ClientMapper;
import com.example.crmenercom.repository.ClientRepository;
import com.example.crmenercom.service.ClientService;
import org.springframework.stereotype.Service;

import javax.persistence.NonUniqueResultException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository repository;

    public ClientServiceImpl(ClientRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<ClientDto> selectAll() {
        return repository.findAll()
                .stream().map(ClientMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public ClientDto findById(Long id) {
        return repository.findById(id)
                .map(ClientMapper::toDto)
                .orElse(null);
    }

    @Override
    public ClientDto add(ClientDto newClient) throws NonUniqueResultException {
        if (exists(newClient))
            throw new NonUniqueResultException(newClient.getCompany());
        return ClientMapper.toDto(repository.save(ClientMapper.toEntity(newClient)));
    }

    @Override
    public Boolean existsByCompany(String company) {
        return repository.existsByCompany(company);
    }

    @Override
    public Boolean existsByCompany(ClientDto client) {
        return repository.existsByCompany(client.getCompany());
    }

    @Override
    public Boolean exists(ClientDto client) {
        return repository.existsByCompany(client.getCompany());
    }

    @Override
    public ClientDto addClient(ClientDto newClient) {
        if (existsByCompany(newClient)) throw new NonUniqueResultException("This client is already inserted!");
        ClientEntity entity = ClientMapper.toEntity(newClient);
        return ClientMapper.toDto(repository.save(entity));
    }

    @Override
    public ClientDto findByCompany(String company) {
        return repository.findByCompany(company)
                .map(ClientMapper::toDto)
                .orElse(null);
    }

    @Override
    public ClientDto findByCompany(ClientDto client) {
        return findByCompany(client.getCompany());
    }

    @Override
    public ClientDto update(ClientDto current, ClientDto updated) throws NonUniqueResultException {
        ClientDto newClient = add(updated);
        delete(current);
        return newClient;
    }

    @Override
    public ClientDto deleteById(Long id) {
        ClientEntity client = repository.findById(id).orElse(null);
        if (client != null) {
            repository.delete(client);
            return ClientMapper.toDto(client);
        } else return null;
    }

    @Override
    public ClientDto delete(ClientDto client) {
        repository.delete(ClientMapper.toEntity(client));
        return client;
    }

    @Override
    public ClientDto delete(String company){
        return delete(findByCompany(company));
    }

}
