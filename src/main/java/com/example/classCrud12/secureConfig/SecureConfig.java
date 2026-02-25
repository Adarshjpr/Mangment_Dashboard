package com.example.classCrud12.secureConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Component;


@Configuration //
public class SecureConfig {

    @Bean
    public  PasswordEncoder pEncoder(){    // passwordEncoder    
   return new BCryptPasswordEncoder();
}
@Bean
public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http.authorizeHttpRequests(auth -> auth.requestMatchers("/user").authenticated()
    .anyRequest().permitAll()

    )

        .csrf(csrf -> csrf.disable()); // Disable CSRF for testing
    return http.build();
}

}
