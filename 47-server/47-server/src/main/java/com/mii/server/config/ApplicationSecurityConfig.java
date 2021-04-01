/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.server.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 *
 * @author acer
 */
@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    @Override
    public AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        //http.authorizeRequests().and().logout().disable().formLogin().disable().httpBasic();
        // dicoba menggunakan postman
        http
            .csrf().disable()
            .authorizeRequests()
                .antMatchers("/login/**", "/user").permitAll() // siapapun boleh lewat
                .antMatchers("/**", "/logout").authenticated() // harus terautentikasi terlebih dahulu dan prosesnya di login
                .and()
            .logout().disable()
            .formLogin().disable()
            .httpBasic();
    }

}