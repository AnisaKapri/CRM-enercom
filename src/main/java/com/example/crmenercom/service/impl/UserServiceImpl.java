package com.example.crmenercom.service.impl;

import com.example.crmenercom.dto.UserDto;
import com.example.crmenercom.entity.UserEntity;
import com.example.crmenercom.mapper.UserMapper;
import com.example.crmenercom.repository.UserRepository;
import com.example.crmenercom.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NonUniqueResultException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(propagation = Propagation.REQUIRED)
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    @Override
    public Boolean existsByEmail(String email) {
        return repository.existsByEmail(email);
    }

    @Override
    public Boolean existsByEmail(UserDto user) {
        return repository.existsByEmail(user.getEmail());
    }

    @Override
    public Boolean isValid(UserDto user) {
        return user.equals(findByEmail(user));
    }

    @Override
    public UserDto findById(Long id) {
        return repository.findById(id)
                .map(UserMapper::toDto)
                .orElse(null);
    }

    @Override
    public UserDto findByEmail(String email) {
        return repository.findByEmail(email)
                .map(UserMapper::toDto)
                .orElse(null);
    }

    @Override
    public UserDto findByEmail(UserDto user) {
        return findByEmail(user.getEmail());
    }

    @Override
    public List<UserDto> selectAll() {
        return repository.findAll()
                .stream().map(UserMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserDto addUser(UserDto newUser) {
        if (existsByEmail(newUser))
            throw new NonUniqueResultException("This email is already inserted!");
        UserEntity entity = UserMapper.toEntity(newUser);
        return UserMapper.toDto(repository.save(entity));
    }

    @Override
    public UserDto deleteById(Long id) {
        UserEntity user = repository.findById(id).orElse(null);
        if (user != null) {
            repository.delete(user);
            return UserMapper.toDto(user);
        } else return null;
    }
}
