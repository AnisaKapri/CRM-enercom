package com.example.crmenercom.service;

import com.example.crmenercom.dto.ClientDto;
import com.example.crmenercom.dto.UserDto;
import com.example.crmenercom.entity.ClientEntity;
import org.springframework.data.domain.Page;

import javax.persistence.NonUniqueResultException;
import java.util.List;

public interface ClientService {

    List<ClientDto> selectAll();

    ClientDto findById(Long id);

    ClientDto add(ClientDto newClient) throws NonUniqueResultException;

    Boolean existsByCompany(String company);

    Boolean existsByCompany(ClientDto client);

    Boolean exists(ClientDto client);

    ClientDto addClient(ClientDto newClient);


    ClientDto findByCompany(String company);

    ClientDto findByCompany(ClientDto client);

    ClientDto update(ClientDto current, ClientDto updated) throws NonUniqueResultException;

    ClientDto deleteById(Long id);

    ClientDto delete(ClientDto client);

    ClientDto delete(String company);


}
