package com.example.crmenercom.service;

import com.example.crmenercom.dto.ContactedByDto;

import java.util.UUID;


public interface ContactedByService {
    ContactedByDto getById(Long id);

    ContactedByDto create(ContactedByDto contactedByDto);


    ContactedByDto update(ContactedByDto contactedByDto);


    ContactedByDto deleteById(Long id);
}
