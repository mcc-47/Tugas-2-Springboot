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
    private List<String> grantedAuthoritys;

    public UserSessionDto() {
    }

    public UserSessionDto(String userName) {
        this.userName = userName;
    }

    public UserSessionDto(String userName, List<String> grantedAuthoritys) {
        this.userName = userName;
        this.grantedAuthoritys = grantedAuthoritys;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<String> getGrantedAuthoritys() {
        return grantedAuthoritys;
    }

    public void setGrantedAuthoritys(List<String> grantedAuthoritys) {
        this.grantedAuthoritys = grantedAuthoritys;
    }

}
