package com.example.SpringWebApplication.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.function.Function;

@Configuration
public class SpringSecurityConfiguration {
    // LDAP or database

    @Bean
    public InMemoryUserDetailsManager createMemoryUserDetailsManager() {
        UserDetails user1 = createNewUser("mayank", "pass");
        UserDetails user2 = createNewUser("u2", "pass");
        return new InMemoryUserDetailsManager(user1, user2);
    }

    public UserDetails createNewUser(String name, String password) {
        Function<String, String> passwordEncoder
                = input -> passwordEncoder().encode(input);
        UserDetails userDetails = User.builder()
                .passwordEncoder(passwordEncoder)
                .username(name)
                .password(password)
                .roles("USER", "ADMIN")
                .build();
        return userDetails;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


}
