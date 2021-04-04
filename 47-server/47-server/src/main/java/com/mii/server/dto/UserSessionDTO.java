/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.server.dto;

import java.util.Collection;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;

/**
 *
 * @author ACER
 */
public class UserSessionDTO {
    private String userName;
    private Collection<? extends GrantedAuthority> authorities;

    public UserSessionDTO() {
    }

    public UserSessionDTO(String userName, Collection<? extends GrantedAuthority> authorities) {
        this.userName = userName;
        this.authorities = authorities;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
        this.authorities = authorities;
    }

}
