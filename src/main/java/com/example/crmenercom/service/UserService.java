package com.example.crmenercom.service;

import com.example.crmenercom.dto.UserDto;
import com.example.crmenercom.entity.UserEntity;

import java.util.List;

public interface UserService {

    Boolean existsByEmail(String email);

    Boolean existsByEmail(UserDto user);

    Boolean isValid(UserDto user);

    List<UserDto> selectAll();

    UserDto findById(Long id);

    UserDto findByEmail(String email);

    UserDto findByEmail(UserDto user);

    UserDto addUser(UserDto newUser);

    UserDto deleteById(Long id);
}
