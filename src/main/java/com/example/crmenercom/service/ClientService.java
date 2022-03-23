package com.example.crmenercom.service;

import com.example.crmenercom.dto.ClientDto;
import com.example.crmenercom.entity.ClientEntity;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ClientService {

    List<ClientDto> selectAll();

    List<ClientEntity> findAll();

    ClientDto findById(Integer id);

    ClientDto getById(int id);

    ClientDto create(ClientDto client);

    ClientDto update(ClientDto clientDto);

    ClientDto deleteById(Integer id);

    //forma tjt
    List<ClientEntity> getAllClients();

    void saveClient(ClientEntity client);

    ClientEntity getClientById(int id);

    void deleteClientById(int id);

    Page<ClientEntity> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);


}
