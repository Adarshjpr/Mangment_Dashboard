package com.example.classCrud12.secureConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;

import com.example.classCrud12.jwt.JwtAuthFilter;


@Configuration //
public class SecureConfig {
@Autowired
    private JwtAuthFilter jwtAuthFilter ;
    @Bean
    public  PasswordEncoder pEncoder(){    // passwordEncoder    
   return new BCryptPasswordEncoder();
}
   @Bean
public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http.authorizeHttpRequests(auth -> auth.requestMatchers("/user").authenticated()
    .requestMatchers("/admin").hasRole("ADMIN")
    .anyRequest().permitAll()

    )

        .csrf(csrf -> csrf.disable())
        
        .formLogin(form -> form.disable())
        .httpBasic(h ->h.disable())
            .addFilterBefore(
    jwtAuthFilter,
                UsernamePasswordAuthenticationFilter.class
        );

        ; // Disable CSRF for testing
           
    
        return http.build();
}

}
