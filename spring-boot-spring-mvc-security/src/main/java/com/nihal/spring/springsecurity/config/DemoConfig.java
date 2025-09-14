package com.nihal.spring.springsecurity.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
/*
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
 */
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class DemoConfig {
    /*
     * @Bean
     * public InMemoryUserDetailsManager userDetailsManager() {
     * UserDetails john =
     * User.builder().username("john").password("{noop}test123").roles("EMPLOYEE").
     * build();
     * UserDetails mary =
     * User.builder().username("mary").password("{noop}test123").roles("EMPLOYEE",
     * "MANAGER")
     * .build();
     * UserDetails susan =
     * User.builder().username("susan").password("{noop}test123").roles("ADMIN",
     * "EMPLOYEE",
     * "MANAGER").build();
     * 
     * return new InMemoryUserDetailsManager(john, mary, susan);
     * }
     */

    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {
        JdbcUserDetailsManager userDetailsManager = new JdbcUserDetailsManager(dataSource);
        userDetailsManager.setUsersByUsernameQuery("select username, password, enabled from users where username=?");
        userDetailsManager
                .setAuthoritiesByUsernameQuery("select username, authority from authorities where username=?");
        return userDetailsManager;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(configurer -> configurer
                .requestMatchers("/").hasRole("EMPLOYEE")
                .requestMatchers("/leaders/**").hasRole("MANAGER")
                .requestMatchers("/systems/**").hasRole("ADMIN")
                .anyRequest().authenticated())
                .formLogin(form -> form.loginPage("/login")
                        .loginProcessingUrl("/authenticateTheUser")
                        .permitAll())
                .logout(logout -> logout.permitAll())
                .exceptionHandling(configurer -> configurer.accessDeniedPage("/access-denied"));

        return http.build();
    }
}
