/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.server.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 *
 * @author ASUS
 */
@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter{
    
    @Bean
    @Override
    public AuthenticationManager authenticationManager() throws Exception{
        return authenticationManagerBean();
    }
    
    @Override
    public void configure (HttpSecurity http)throws Exception{
        http.authorizeRequests()
                .antMatchers("/login", "/district").permitAll()
                .antMatchers("/**","logout").authenticated()
                .and()
                .logout().disable()
                .formLogin().disable()
                .httpBasic();
    }
}
