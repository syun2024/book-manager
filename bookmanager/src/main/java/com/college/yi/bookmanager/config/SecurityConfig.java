package com.college.yi.bookmanager.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@MapperScan("com.college.yi.bookmanager.mapper")
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http.formLogin(login -> login
                    .permitAll()
                    .failureUrl("/login?error")
            )
            .authorizeHttpRequests(requests -> requests
                    .requestMatchers("/login").permitAll()
                    .requestMatchers(HttpMethod.GET,"/api/books").hasAnyRole("USER","ADMIN")
                    .requestMatchers(HttpMethod.POST,"/api/books/create").hasRole("ADMIN")
                    .requestMatchers(HttpMethod.PUT,"/api/books/update/**").hasRole("ADMIN")
                    .requestMatchers(HttpMethod.DELETE,"/api/books/delete/**").hasRole("ADMIN")
                    .anyRequest().authenticated()
                    );
        
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
