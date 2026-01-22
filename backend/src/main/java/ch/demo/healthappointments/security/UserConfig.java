package ch.demo.healthappointments.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.MapReactiveUserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * Utilisateurs en mémoire pour POC uniquement.
 * Authentification simplifiée (HTTP Basic).
 */
@Configuration
public class UserConfig {
      @Bean
    public MapReactiveUserDetailsService users() {

        UserDetails admin = User
            .withUsername("admin")
            .password("{noop}admin")
            .roles("ADMIN")
            .build();

        UserDetails patient = User
            .withUsername("patient")
            .password("{noop}patient")
            .roles("PATIENT")
            .build();

        return new MapReactiveUserDetailsService(admin, patient);
    }
}
