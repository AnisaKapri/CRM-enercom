package com.example.crmenercom.service;

import com.example.crmenercom.dto.CountryDto;

import java.util.UUID;


public interface CountryService {
    CountryDto getById(int id);

    CountryDto create(CountryDto countryDto);


    CountryDto update(CountryDto countryDto);


    CountryDto deleteById(int id);
}
