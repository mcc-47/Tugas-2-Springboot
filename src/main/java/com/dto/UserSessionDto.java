/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dto;

import com.entities.Role;
import java.util.Collection;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;

/**
 *
 * @author jakab
 */
public class UserSessionDto {
    
    private String userName;
    private List<String> grantedAuthorities;

    public UserSessionDto() {
    }

    public UserSessionDto(String userName) {
        this.userName = userName;
    }

    public UserSessionDto(String userName, List<String> grantedAuthorities) {
        this.userName = userName;
        this.grantedAuthorities = grantedAuthorities;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<String> getGrantedAuthorities() {
        return grantedAuthorities;
    }

    public void setGrantedAuthorities(List<String> grantedAuthorities) {
        this.grantedAuthorities = grantedAuthorities;
    }

}
