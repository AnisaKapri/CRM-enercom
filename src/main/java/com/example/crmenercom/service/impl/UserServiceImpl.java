package com.example.crmenercom.service.impl;

import com.example.crmenercom.dto.UserDto;
import com.example.crmenercom.entity.ProductEntity;
import com.example.crmenercom.entity.UserEntity;
import com.example.crmenercom.mapper.ProductMapper;
import com.example.crmenercom.mapper.UserMapper;
import com.example.crmenercom.repository.UserRepository;
import com.example.crmenercom.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
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
    public UserDto findById(int id) {
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
    public UserDto deleteById(int id) {
        UserEntity user = repository.findById(id).orElse(null);
        if (user != null) {
            repository.delete(user);
            return UserMapper.toDto(user);
        } else return null;
    }

    @Override
    public UserDto update(UserDto updated) {

        if (updated.getId() == null)
            throw new IllegalArgumentException("Id must be supplied on update");
        UserEntity existing = repository.findById(updated.getId()).orElse(null);
        if (existing == null)
            throw new EntityNotFoundException("Product with this id cannot be found");
        existing.setRole(updated.getRole());
        existing.setFirstName(updated.getFirstName());
        existing.setLastName(updated.getLastName());
        existing.setEmail(updated.getEmail());
        existing.setPassword(updated.getPassword());

        return UserMapper.toDto(repository.save(existing));
    }
}

