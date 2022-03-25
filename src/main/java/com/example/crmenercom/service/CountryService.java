package com.example.crmenercom.service;

import com.example.crmenercom.dto.CountryDto;
import com.example.crmenercom.dto.NetworkOperatorDto;

import javax.persistence.NonUniqueResultException;
import java.util.List;
import java.util.UUID;


public interface CountryService {


    Boolean contains(NetworkOperatorDto networkOperator);

    Long getNumOfCountries(NetworkOperatorDto networkOperator);

    List<CountryDto> selectAll();

    List<CountryDto> selectAllByNetworkOperator(String networkOperator);

    CountryDto findById(int id);

    Boolean isUnique(CountryDto country);

    CountryDto add(CountryDto country) throws NonUniqueResultException;

    CountryDto overwrite(CountryDto country);

    CountryDto delete(CountryDto country);

    CountryDto deleteById(int id);

    CountryDto update(CountryDto updated);

    NetworkOperatorDto updateNetworkOperator(NetworkOperatorDto current, NetworkOperatorDto updated);
}
