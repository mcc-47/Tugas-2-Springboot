/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.server.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 *
 * @author MyLaptop
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
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
         http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/login/**", "/user").permitAll() // public
                .antMatchers("/**", "/logout").authenticated() // setelah autheticated
                .and()
                .logout().disable()
                .formLogin().disable()
                .httpBasic();
    }
    }
    
    

    
//    @Autowired
//    private DataSource dataSource;
    
//        protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        /*auth.inMemoryAuthentication().withUser("arnum").password("arnum123").roles("USER")
//                .and()
//                .withUser("administrator").password("admin123").roles("ADMIN");*/
//        auth.jdbcAuthentication()
//              .dataSource(dataSource);
//
//    }
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//    return new BCryptPasswordEncoder();
//    }
    
    
//    JdbcUserDetailsManager userDetailsService = new JdbcUserDetailsManager();
//        userDetailsService.setDataSource(databaseConfig.getDataSource());
//        org.springframework.security.crypto.password.PasswordEncoder encoder = new BCryptPasswordEncoder();
//        auth.userDetailsService(userDetailsService).passwordEncoder(encoder);
//        auth.jdbcAuthentication().dataSource(databaseConfig.getDataSource());


//        @Override
//        protected void configure(final HttpSecurity http)throws Exception{
//        http.authorizeRequests()
//                .antMatchers("/hi").permitAll() //izinkan semua
//                .antMatchers("/css/**").permitAll() //izinkan semua
//                .antMatchers("/js/**").permitAll() //izinkan semua
//                .antMatchers("/fonts/**").permitAll() //izinkan semua
//                .antMatchers("/login").permitAll() //izinkan semua (termasuk default spring-security login page
//                .anyRequest().authenticated() //selain yang di atas harus authenticated
//                .and()
//                .formLogin() //login config
//                .and()
//                .logout() //logout config
//                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//                .logoutSuccessUrl("/")
//                ;
////    }
