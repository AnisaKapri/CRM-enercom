package com.example.crmenercom.service;


import com.example.crmenercom.dto.ContactPersonDto;

import java.util.UUID;

public interface ContactPersonService {
    ContactPersonDto getById(Long id);

    ContactPersonDto create(ContactPersonDto contactPersonDto);


    ContactPersonDto update(ContactPersonDto contactPersonDto);


    ContactPersonDto deleteById(Long id);
}
