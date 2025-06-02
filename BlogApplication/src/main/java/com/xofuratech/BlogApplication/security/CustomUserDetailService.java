package com.xofuratech.BlogApplication.security;

import com.xofuratech.BlogApplication.entities.User;
import com.xofuratech.BlogApplication.exceptions.ResourceNotFoundException;
import com.xofuratech.BlogApplication.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {
    @Autowired
    private UserRepo userRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Loading  user from database by email as username
        User user = userRepo.findByEmail(username).orElseThrow(() -> new ResourceNotFoundException("User", "email", 0));
        return user;
    }
}
