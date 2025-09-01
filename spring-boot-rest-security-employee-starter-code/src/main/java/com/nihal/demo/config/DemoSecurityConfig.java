package com.nihal.demo.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class DemoSecurityConfig {

    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {
        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);

        // extracting user, pswd, active on the basis of username
        jdbcUserDetailsManager.setUsersByUsernameQuery("select user_id, pw, active from members where user_id=?");

        // extracting roles on the basis of username
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery("select user_id, role from roles where user_id=?");

        return jdbcUserDetailsManager;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(configurer -> configurer
                .requestMatchers(HttpMethod.GET, "/api/employees").hasRole("EMPLOYEE")
                .requestMatchers(HttpMethod.GET, "/api/employees/**").hasRole("EMPLOYEE")
                .requestMatchers(HttpMethod.POST, "/api/employees").hasRole("MANAGER")
                .requestMatchers(HttpMethod.PUT, "/api/employees").hasRole("MANAGER")
                .requestMatchers(HttpMethod.PATCH, "/api/employees/**").hasRole("MANAGER")
                .requestMatchers(HttpMethod.DELETE, "/api/employees/**").hasRole("ADMIN"));

        // use HTTP Basic Authentication
        http.httpBasic(Customizer.withDefaults());

        // disable Cross Site Request Forgery (CSRF)
        // in general, not required for stateless REST APIs that use POST, PUT, DELETE
        // and/or PATCH
        http.csrf(csrf -> csrf.disable());

        return http.build();
    }
}

/*
 * @Bean
 * public InMemoryUserDetailsManager userDetailsManager() {
 * UserDetails shyam =
 * User.builder().username("shyam").password("{noop}shyam123").roles("EMPLOYEE")
 * .build();
 * UserDetails raju =
 * User.builder().username("raju").password("{noop}raju123").roles("EMPLOYEE",
 * "MANAGER")
 * .build();
 * UserDetails babuRao =
 * User.builder().username("babuRao").password("{noop}babuRao123")
 * .roles("EMPLOYEE", "MANAGER", "ADMIN").build();
 * 
 * return new InMemoryUserDetailsManager(shyam, raju, babuRao);
 * }
 */