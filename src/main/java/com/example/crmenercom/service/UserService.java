package com.example.crmenercom.service;

import com.example.crmenercom.dto.UserDto;
import com.example.crmenercom.entity.UserEntity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService extends UserDetailsService {

    Boolean existsByEmail(String email);

    Boolean existsByEmail(UserDto user);

    Boolean isValid(UserDto user);

    List<UserDto> selectAll();

    UserDto findById(Integer id);

    UserDto findByEmail(String email);

    UserDto findByEmail(UserDto user);

    UserDto addUser(UserDto newUser);

    UserDto deleteById(Integer id);

    UserEntity save(UserDto registrationDto);
}
