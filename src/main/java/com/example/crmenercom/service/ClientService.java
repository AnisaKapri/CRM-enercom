package com.example.crmenercom.service;
import com.example.crmenercom.dto.ClientDto;

import java.util.UUID;

public interface ClientService {

    ClientDto getById(int id);

    ClientDto create(ClientDto clientDto);


    ClientDto update(ClientDto clientDto);

    ClientDto deleteById(int id);


}
