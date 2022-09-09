package com.comtrade360.assignment.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class MySecurityConfig {


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/hello-rest").permitAll()
                .antMatchers("/translate").permitAll()
                .antMatchers("/translate/all").permitAll()
                .antMatchers("/h2-console/**").permitAll()
                .antMatchers("/hello").hasAuthority("ROLE_USER")
                .antMatchers("/translate/add").hasAuthority("ROLE_ADMIN")
                .antMatchers("/translate/save").hasAuthority("ROLE_ADMIN")
                .and()
                .csrf().ignoringAntMatchers("/h2-console/**")
                .and()
                .formLogin()
                .and()
                .httpBasic();
        return http.build();
    }

    //Spring Security kept asking for a BCryptPasswordEncoder
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withUsername("user")
                .password(passwordEncoder.encode("userPass"))
                .roles("USER")
                .build());
        manager.createUser(User.withUsername("admin")
                .password(passwordEncoder.encode("adminPass"))
                .roles("USER", "ADMIN")
                .build());
        return manager;
    }
}
