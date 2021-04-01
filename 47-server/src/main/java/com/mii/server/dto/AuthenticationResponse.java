/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.server.dto;

import com.mii.server.entities.Privileges;
import com.mii.server.entities.Roles;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class AuthenticationResponse {
    private String username;
    private List<String> Authorities;

    public AuthenticationResponse() {
    }

    public AuthenticationResponse(String username, List<String> Authorities) {
        this.username = username;
        this.Authorities = Authorities;
    }

    public String getUsername() {
        return username;
    }

    public List<String> getAuthorities() {
        return Authorities;
    }
    
}
