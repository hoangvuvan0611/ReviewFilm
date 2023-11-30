package com.example.reviewfilm.config;

import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Slf4j
@Configuration
@EnableWebSecurity
public class WebSecurityConfig{

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        log.info("securityFilterChain");
        httpSecurity
                .cors()
                .and()
                .csrf()
                .disable()
            .authorizeHttpRequests((authorizationManagerRequestMatcherRegistry) -> authorizationManagerRequestMatcherRegistry
//                    .requestMatchers("/api/v1/movie/**").authenticated()
                    .anyRequest().permitAll()
            ).httpBasic();

        return httpSecurity.build();
    };

    @Bean
    public UserDetailsService userDetailsService(){
        UserDetails user =
                User.withDefaultPasswordEncoder()
                        .username("user")
                        .password("123")
                        .roles("User")
                        .build();
        return new InMemoryUserDetailsManager(user);
    }

//    @Bean
//    public PasswordEncoder passwordEncoder(){
//        return new BCryptPasswordEncoder();
//    }
}
