package com.example.school_management.service;

import com.example.school_management.dao.AccountRepository;
import com.example.school_management.model.Account;
import com.example.school_management.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class AccountServiceImp implements AccountService {

    private final PasswordEncoder passwordEncoder;
    private AccountRepository accountRepository;

    @Autowired
    public AccountServiceImp(AccountRepository accountRepository, PasswordEncoder passwordEncoder) {
        this.accountRepository = accountRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        Account acc = accountRepository.findByUsername(username);
        if (acc == null) {
            throw new UsernameNotFoundException(username);

        }
        return new User(acc.getUsername(),
                acc.getPassword(),
                getGrantedAuthorities(acc.getRole()));
    }

    private Collection<GrantedAuthority> getGrantedAuthorities(Role role) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
        return authorities;
    }
}
