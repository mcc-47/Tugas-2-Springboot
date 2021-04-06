/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.configuration;

import com.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 *
 * @author jakab
 */
@Configuration
@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter{
    
    @Autowired
    UserService userService;
    
    @Bean
    public BCryptPasswordEncoder  passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    
    @Bean
    @Override
    public AuthenticationManager authenticationManager() throws Exception{
        return super.authenticationManagerBean();
    }
    
    @Override
    public void configure(HttpSecurity http) throws Exception{
        http
                .csrf().disable()
                .authorizeRequests()
//                .antMatchers("/login").permitAll()
//                .antMatchers("/logout").authenticated()
                .antMatchers("/**").permitAll()
                .and()
                .formLogin().disable()
                .logout().disable()
                .httpBasic();
    }
    
}
