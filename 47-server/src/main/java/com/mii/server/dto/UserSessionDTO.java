/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.server.dto;

import com.mii.server.entities.Role;
import java.util.Collection;

/**
 *
 * @author ASUS
 */
public class UserSessionDTO {
    private String userName;
    private Collection<Role> roleCollection;

    public UserSessionDTO(String userName, Collection<Role> roleCollection) {
        this.userName = userName;
        this.roleCollection = roleCollection;
    }

    public UserSessionDTO() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Collection<Role> getRoleCollection() {
        return roleCollection;
    }

    public void setRoleCollection(Collection<Role> roleCollection) {
        this.roleCollection = roleCollection;
    }
    
    
}
