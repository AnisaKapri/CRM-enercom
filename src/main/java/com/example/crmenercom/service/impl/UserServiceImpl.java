package com.example.crmenercom.service.impl;

import com.example.crmenercom.dto.UserDto;
import com.example.crmenercom.entity.UserEntity;
import com.example.crmenercom.mapper.UserMapper;
import com.example.crmenercom.repository.UserRepository;
import com.example.crmenercom.service.UserService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.persistence.NonUniqueResultException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@NoArgsConstructor
@Transactional(propagation = Propagation.REQUIRED)
public class UserServiceImpl implements UserService {

    private UserRepository repository;

    private BCryptPasswordEncoder passwordEncoder;

    @Override public Boolean existsByEmail(String email) {
        return repository.existsByEmail(email);
    }
    @Override public Boolean existsByEmail(UserDto user) {
        return existsByEmail(user.getEmail());
    }
    @Override public Boolean isValid(UserDto user) {
        return user.equals(findByEmail(user));
    }
    @Override public UserDto findById(Integer id) {
        return repository.findById(id)
                .map(UserMapper::toDto)
                .orElse(null);
    }
    @Override public UserDto findByEmail(String email) {
        return repository.findByEmail(email)
                .map(UserMapper::toDto)
                .orElse(null);
    }
    @Override public UserDto findByEmail(UserDto user) {
        return findByEmail(user.getEmail());
    }
    @Override public List<UserDto> selectAll() {
        return repository.findAll()
                .stream().map(UserMapper::toDto)
                .collect(Collectors.toList());
    }
    @Override public UserDto addUser(UserDto newUser) {
        if (existsByEmail(newUser))
            throw new NonUniqueResultException("This email is already inserted!");
        UserEntity entity = UserMapper.toEntity(newUser);
        return UserMapper.toDto(repository.save(entity));
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }

    @Override public UserDto deleteById(Integer id) {
        UserEntity user = repository.findById(id).orElse(null);
        if (user != null) {
            repository.delete(user);
            return UserMapper.toDto(user);
        } else return null;
    }

    @Override
    public UserEntity save(UserDto registrationDto) {
        UserEntity user = new UserEntity(registrationDto.getFirstName(),
                registrationDto.getLastName(),
                registrationDto.getEmail(),
                passwordEncoder.encode(registrationDto.getPassword()));
        return repository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }

}

