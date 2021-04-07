/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.server.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author Zahra
 */
@Configuration
@EnableWebSecurity
//@EnableGlobalMethodSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {
    
    @Autowired
    private PasswordConfiguration passwordConfig;
    
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception{
        return super.authenticationManagerBean();
    }
//    @Bean
//    public BCryptPasswordEncoder  passwordEncoder(){
//        return new BCryptPasswordEncoder();
//    }
     @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(passwordConfig.authenticationProvider());
    }
    
    @Override
    public void configure(HttpSecurity http) throws Exception{
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/trainer").hasRole("TRAINER")
                .antMatchers("/api/employees/list-all").hasAnyRole("TRAINEE")
                .antMatchers("/trainee").hasAnyRole("TRAINER", "TRAINEE")
                .antMatchers("/login","/registrationMail","/loginuser").permitAll()
//                .antMatchers("/**/","/logout").authenticated()
                .antMatchers("/login").permitAll()
                .and()
                .logout().disable()
                .formLogin().disable()
                .httpBasic();
    }
    
}
//67c3856c-d083-4c90-85c5-c9128ec2791f