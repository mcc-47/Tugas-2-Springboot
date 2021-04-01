/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.server.dto;

import java.util.List;

/**
 *
 * @author ACER
 */
public class UserSessionDTO {
    private String userName;
    private List<String> roles;
    private List<String> privileges;

    public UserSessionDTO() {
    }

    public UserSessionDTO(String userName, List<String> roles, List<String> privileges) {
        this.userName = userName;
        this.roles = roles;
        this.privileges = privileges;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public List<String> getPrivileges() {
        return privileges;
    }

    public void setPrivileges(List<String> privileges) {
        this.privileges = privileges;
    }
    
    
    
    
    
}
