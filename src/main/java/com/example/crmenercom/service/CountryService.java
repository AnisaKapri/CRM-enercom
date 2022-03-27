package com.example.crmenercom.service;


import com.example.crmenercom.dto.CountryDto;

import javax.persistence.NonUniqueResultException;
import java.util.List;

public interface CountryService {

    List<CountryDto> selectAll();

    CountryDto findByName(String name);

    Boolean exists(CountryDto country);

    CountryDto add(CountryDto newCountry) throws NonUniqueResultException;

    CountryDto delete(CountryDto country);

    CountryDto delete(String name);

    CountryDto update(CountryDto current, CountryDto updated) throws NonUniqueResultException;


}
