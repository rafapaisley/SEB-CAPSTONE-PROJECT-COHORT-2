package com.example.refundsapi.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {

    @Autowired
    private ApiKeyFilter apiKeyFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        return http
                .csrf(csrf -> csrf.disable())   // ← FIX CSRF for POST
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/refunds/**").permitAll()  // Allow API calls but protected by filter
                        .anyRequest().authenticated()
                )
                .addFilterBefore(apiKeyFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }
}
