/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.server.configuration;

import com.mii.server.entities.Users;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 *
 * @author Asus
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
    @Bean
    @Override
    public AuthenticationManager authenticationManager () throws Exception {
        return super.authenticationManagerBean();
    }
    
    @Override
    public void configure(HttpSecurity http)throws Exception{
        http.csrf().disable().authorizeRequests() 
            .antMatchers("/loginDTO").permitAll()
            .antMatchers("/**","/logout").authenticated()
            .and()
            .logout().disable()
            .formLogin().disable()
            .httpBasic();      
    }

//    @Autowired
//    private DataSource dataSource;
//    
//    protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication().withUser("regita5").password("regita123").roles("USER")
//            .and()
//            .withUser("administrator").password("admin123").roles("ADMIN");
//        
//        auth.jdbcAuthentication()
//            .dataSource(dataSource);
//            org.springframework.security.crypto.password.PasswordEncoder encoder = new BCryptPasswordEncoder();
//            .withDefaultSchema()
//            .withUser(Users.withUser("user")
//            .password(password().encode("pass"))
//            .roles("USER"));
//    }
//    
//    @Bean
//    public PasswordEncoder encoder() {
//        return new BCryptPasswordEncoder();
//    }
    
    
    /*
    @Override
    protected void configure(final HttpSecurity http)throws Exception{
    http.authorizeRequests()
            .antMatchers("/").permitAll() //izinkan semua
            .antMatchers("/css/**").permitAll() //izinkan semua
            .antMatchers("/js/**").permitAll() //izinkan semua
            .antMatchers("/fonts/**").permitAll() //izinkan semua
            .antMatchers("/login").permitAll() //izinkan semua (termasuk default spring-security login page
            .anyRequest().authenticated() //selain yang di atas harus authenticated
            .and()
            .formLogin() //login config
            .and()
            .logout() //logout config
            .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
            .logoutSuccessUrl("/")
            ;
   }*/
}

