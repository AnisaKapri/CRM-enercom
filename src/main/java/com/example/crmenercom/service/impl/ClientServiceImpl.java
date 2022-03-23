package com.example.crmenercom.service.impl;

import com.example.crmenercom.dto.ClientDto;
import com.example.crmenercom.entity.ClientEntity;
import com.example.crmenercom.mapper.ClientMapper;
import com.example.crmenercom.repository.ClientRepository;
import com.example.crmenercom.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.REQUIRED)

public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository repository;


    @Override
    public List<ClientDto> selectAll() {
        return repository.findAll()
                .stream().map(ClientMapper::toDto)
                .collect(Collectors.toList());
    }


    @Override
    public List<ClientEntity> findAll(){
        return repository.findAll();
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


    @Override
    public List<ClientEntity> getAllClients(){
        return repository.findAll();
    }

    @Override
    public void saveClient(ClientEntity client){
        this.repository.save(client);
    }

    @Override
    public ClientEntity getClientById(int id){
        Optional<ClientEntity> optional = repository.findById(id);
        ClientEntity client = null;
        if(optional.isPresent()){
            client = optional.get();
        }else {
            throw new RuntimeException("Client not found for id :: " + id);
        }
        return client;
    }

    @Override
    public void deleteClientById(int id){
        this.repository.deleteById(id);
    }

    @Override
    public Page<ClientEntity> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();

        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        return this.repository.findAll(pageable);
    }

}
