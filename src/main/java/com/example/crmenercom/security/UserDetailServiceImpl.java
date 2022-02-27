package com.example.crmenercom.security;

import com.example.crmenercom.entity.UserEntity;
import com.example.crmenercom.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

public class UserDetailServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;


    public UserDetailServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserEntity user = userRepository.findByEmail(email).orElse(null);
        if (user == null) throw new UsernameNotFoundException(email);
        return User.withUsername(user.getEmail()).password(user.getPassword())
                .authorities("USER", "ADMIN").build();
    }
}
