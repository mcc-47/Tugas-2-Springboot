///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.mii.server.configuration;
//
//import com.mii.server.entities.Users;
//import javax.sql.DataSource;
//import org.springframework.beans.factory.annotation.Autowired;

import com.mii.server.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
@import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
    
    @Autowired 
    UserService userService;
    
    
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder(10);
    }
    
    @Bean
    @Override
    public AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManagerBean();
    }
    
    
    @Override
    public void configure(HttpSecurity http)throws Exception{
//        http.authorizeRequests()
//            .antMatchers("/login","/user","/testuser").permitAll()
//            .antMatchers("/hi").permitAll()
//            .antMatchers("/**","/logout").authenticated()
//            .and()
//            .logout().disable()
//            .formLogin().disable()
//            .httpBasic();     
    public void configure(HttpSecurity http)throws Exception{    
         http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/login/**", "/user").permitAll() // public
                .antMatchers("/login/**", "/user","/registrasi").permitAll() // public
                .antMatchers("/**", "/logout").authenticated() // setelah autheticated
                .and()
                .logout().disable()
                .formLogin().disable()
                .httpBasic();
    }

    @Bean
    public DaoAuthenticationProvider authProvider() {
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(userService);
        auth.setPasswordEncoder(passwordEncoder());
        return auth;
    }
    
    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authProvider());
    }
    
}



//    public void configure(HttpSecurity http)throws Exception{
//        http.authorizeRequests()
//            .antMatchers("/login","/user","/testuser").permitAll()
//            .antMatchers("/hi").permitAll()
//            .antMatchers("/**","/logout").authenticated()
//            .and()
//            .logout().disable()
//            .formLogin().disable()
//            .httpBasic(); 
    
//    @Autowired
//    private DataSource dataSource;