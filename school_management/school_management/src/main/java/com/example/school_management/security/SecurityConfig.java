package com.example.school_management.security;

import com.example.school_management.service.AccountService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider(AccountService accountService) {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(accountService);
        daoAuthenticationProvider.setPasswordEncoder(bCryptPasswordEncoder());
        return daoAuthenticationProvider;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(
                configurer ->
                        configurer.requestMatchers("/home")
                                .permitAll()
                                .requestMatchers(("/parent/**")).hasRole("PARENT")
                                .requestMatchers(("/student/**")).hasRole("STUDENT")
                                .requestMatchers(("/teacher/**")).hasRole("TEACHER")
                                .requestMatchers(("/admin/**")).hasRole("ADMIN")
                                .requestMatchers("/accessdenied").permitAll()
                                .requestMatchers("/auth/**").permitAll()
                                .anyRequest().authenticated()

        ).formLogin(
                form -> form.loginPage("/auth/login")
                        .loginProcessingUrl("/authenticateTheUser")
                        .defaultSuccessUrl("/", true)
                        .permitAll()
        ).exceptionHandling(
                exception ->
                        exception.accessDeniedPage("/auth/accessdenied")
        );
        http.httpBasic(Customizer.withDefaults());
        http.csrf(csrf -> csrf.disable());
        return http.build();
    }
}
