package com.example.polls.security;

import com.example.polls.exception.ResourceNotFoundException;
import com.example.polls.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
        return UserPrincipal
            .create(userRepository
                        .findByUsernameOrEmail(usernameOrEmail, usernameOrEmail)
                        .orElseThrow(() -> new UsernameNotFoundException(
                            "User not found with username or email: " + usernameOrEmail)));
    }

    @Transactional
    public UserDetails loadUserById(Long id) {
        return UserPrincipal
            .create(userRepository
                        .findById(id)
                        .orElseThrow(() -> new ResourceNotFoundException("User", "id", id)));
    }
}
