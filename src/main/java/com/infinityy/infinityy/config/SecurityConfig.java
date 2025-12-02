package com.infinityy.infinityy.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
            .authorizeHttpRequests(auth -> auth
                    .requestMatchers(
                            "/",               // homepage
                            "/home",
                            "/about",
                            "/contact",
                            "/login",
                            "/images/**",
                            "/css/**",
                            "/js/**",
                            "/static/**"
                    ).permitAll()
                    .requestMatchers("/teacher/**").hasRole("TEACHER")
                    .requestMatchers("/parent/**").hasRole("PARENT")
                    .anyRequest().authenticated()
            )
            .formLogin(form -> form
                    .loginPage("/login")
                    .defaultSuccessUrl("/dashboard", true)
                    .permitAll()
            )
            .logout(logout -> logout.logoutSuccessUrl("/login?logout"))
            .csrf(csrf -> csrf.disable());

        return http.build();
    }

    @Bean
public UserDetailsService userDetailsService() {

    UserDetails t1 = User.withUsername("t2001")
            .password("{noop}teacherpass")
            .roles("TEACHER")
            .build();

    UserDetails t2 = User.withUsername("t2002")
            .password("{noop}teach789")
            .roles("TEACHER")
            .build();

    UserDetails p1 = User.withUsername("p1001")
            .password("{noop}parent123")
            .roles("PARENT")
            .build();

    UserDetails p2 = User.withUsername("p1002")
            .password("{noop}kiddo2025")
            .roles("PARENT")
            .build();

    return new InMemoryUserDetailsManager(t1, t2, p1, p2);
}
