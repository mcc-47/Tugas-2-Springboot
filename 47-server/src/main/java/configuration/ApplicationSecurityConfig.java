/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    @Override
    public AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
            .authorizeRequests()
                .antMatchers("/security", "/login").permitAll() // siapapun boleh lewat
                .antMatchers("/**", "/logout").authenticated() // harus terautentikasi terlebih dahulu dan prosesnya di login
                .and()
            .logout().disable()
            .formLogin().disable()
            .httpBasic();
    }
}

//    @Override
//    public void configure(HttpSecurity http) throws Exception {
//        //http.authorizeRequests().and().logout().disable().formLogin().disable().httpBasic();
//        http.authorizeRequests()
//            .antMatchers("/**", "/admin").hasAnyAuthority("CREATE", "READ", "UPDATE", "DELETE")
//            .antMatchers("/**", "/trainer").hasAuthority("READ")
//            .anyRequest().authenticated()
//            .and()
//            .formLogin()
//                .usernameParameter("email")
//                .defaultSuccessUrl("/users")
//                .permitAll()
//            .and()
//            .logout()
//                .logoutSuccessUrl("/").
//                permitAll();
//    }

