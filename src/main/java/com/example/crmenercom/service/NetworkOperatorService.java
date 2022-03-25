package com.example.crmenercom.service;

import com.example.crmenercom.dto.NetworkOperatorDto;

import javax.persistence.NonUniqueResultException;
import java.util.List;

public interface NetworkOperatorService {

    List<NetworkOperatorDto> selectAll();

    NetworkOperatorDto findByName(String name);

    Boolean exist(NetworkOperatorDto networkOperator);

    NetworkOperatorDto add(NetworkOperatorDto newNetwork) throws NonUniqueResultException;

    NetworkOperatorDto delete(NetworkOperatorDto networkOperator);

    NetworkOperatorDto delete(String name);

    NetworkOperatorDto update(NetworkOperatorDto current, NetworkOperatorDto updated) throws NonUniqueResultException;

}
