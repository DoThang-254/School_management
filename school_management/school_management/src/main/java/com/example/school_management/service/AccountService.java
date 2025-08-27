package com.example.school_management.service;

import com.example.school_management.model.Account;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface AccountService extends UserDetailsService {
    public void save(Account acc);
    public Account findByUsername(String username);
    
}
