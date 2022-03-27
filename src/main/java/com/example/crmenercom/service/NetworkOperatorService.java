package com.example.crmenercom.service;

import com.example.crmenercom.dto.CountryDto;
import com.example.crmenercom.dto.NetworkOperatorDto;

import javax.persistence.NonUniqueResultException;
import java.util.List;

public interface NetworkOperatorService {

    Boolean contains(NetworkOperatorDto networkOperator);

    Boolean contains(CountryDto country);

    Long getNumOfNetworkOperators(CountryDto country);

    List<NetworkOperatorDto> selectAll();

    List<NetworkOperatorDto> selectAllByCountry(String country);

    NetworkOperatorDto findById(Long id);

    Boolean isUnique(NetworkOperatorDto networkOperator);

    NetworkOperatorDto add(NetworkOperatorDto networkOperator) throws NonUniqueResultException;

    NetworkOperatorDto overwrite(NetworkOperatorDto networkOperator);

    NetworkOperatorDto delete(NetworkOperatorDto networkOperator);

    NetworkOperatorDto deleteById(Long id);

    NetworkOperatorDto update(NetworkOperatorDto updated);

    CountryDto updateCountry(CountryDto current, CountryDto updated);

}
