package com.example.crmenercom.service;

import com.example.crmenercom.dto.ClientDto;
import com.example.crmenercom.entity.ClientEntity;

import java.util.List;

public interface ClientService {

    List<ClientDto> selectAll();

    List<ClientEntity> findAll();

    ClientDto findById(Integer id);

    ClientDto getById(int id);

    ClientDto create(ClientDto client);

    ClientDto update(ClientDto clientDto);

    ClientDto deleteById(Integer id);


}
