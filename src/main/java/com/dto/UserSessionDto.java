/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dto;

import com.entities.Role;
import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;

/**
 *
 * @author jakab
 */
public class UserSessionDto {
    
    private String userName;
    private Collection<GrantedAuthority> grantedAuthoritys;

    public UserSessionDto() {
    }

    public UserSessionDto(String userName) {
        this.userName = userName;
    }

    public UserSessionDto(String userName, Collection<GrantedAuthority> grantedAuthoritys) {
        this.userName = userName;
        this.grantedAuthoritys = grantedAuthoritys;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Collection<GrantedAuthority> getRoleCollection() {
        return grantedAuthoritys;
    }

    public void setRoleCollection(Collection<GrantedAuthority> roleCollection) {
        this.grantedAuthoritys = grantedAuthoritys;
    }
    
    
}
