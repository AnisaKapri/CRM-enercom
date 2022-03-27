package com.example.crmenercom.service;


import com.example.crmenercom.dto.CompanyDto;

import java.util.UUID;

public interface CompanyService {

    CompanyDto getById(Long id);

    CompanyDto create(CompanyDto companyDto);


    CompanyDto update(CompanyDto companyDto);

    CompanyDto deleteById(Long id);
}
