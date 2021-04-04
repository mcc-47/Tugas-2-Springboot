/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.server.dto;

import java.util.Collection;

/**
 *
 * @author LENOVO-KL
 */
public class LoginDTO2 {
    private String userName;
    private Collection<String> authorities;

    public LoginDTO2(String userName, Collection<String> authorities) {
        this.userName = userName;
        this.authorities = authorities;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Collection<String> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Collection<String> authorities) {
        this.authorities = authorities;
    }
    
    
}
