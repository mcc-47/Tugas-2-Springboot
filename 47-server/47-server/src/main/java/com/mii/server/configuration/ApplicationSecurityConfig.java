/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.server.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 *
 * @author User
 */

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsService userDetailsService;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
    
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
    }
    

    @Override
    public void configure(HttpSecurity http) throws Exception {
       
        http
            .csrf().disable()
            .authorizeRequests()
            .antMatchers("/login", "/user","/regist/insert","/empall").permitAll()
            .antMatchers("/province","/logout").authenticated() //izinkan path ini kalau authhenticate KE ADMIN DAN TRAINER
            .antMatchers("/district").hasAnyRole("ADMIN")//KONDISI KE 2 SETELAH LINE 53, HANYA BISA DIAKSES OLEH ADMIN
            .antMatchers(HttpMethod.DELETE,"/province/**").hasAuthority("DELETE")//admin gabisa akses kesini 
//JADI ADMIN BISA AKSES PROVINCE DAN DISTRICT
                // DAN TRAINER HANYA BISA PROVINCE
//                    .antMatchers("/district").hasAuthority("ADMIN")
                .and()
//            .logout().disable()
//            .formLogin().disable()
            .httpBasic();
    }
}
