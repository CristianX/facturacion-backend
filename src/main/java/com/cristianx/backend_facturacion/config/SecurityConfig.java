package com.cristianx.backend_facturacion.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Desactiva CSRF para APIs REST
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/login", "/api/register").permitAll() // Endpoints públicos
                        .anyRequest().authenticated() // El resto requiere autenticación
                )
                .httpBasic(Customizer.withDefaults()) // Habilita autenticación básica
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)); // Stateless
        return http.build();
    }
}
