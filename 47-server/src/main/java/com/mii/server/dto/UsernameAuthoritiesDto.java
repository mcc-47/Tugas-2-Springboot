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
public class UsernameAuthoritiesDto {
    private String username;
    private List<String> role;
    private List<String> privilege;

    public UsernameAuthoritiesDto() {
    }

    public UsernameAuthoritiesDto(String username, List<String> role) {
        this.username = username;
        this.role = role;
    }

    public UsernameAuthoritiesDto(String username, List<String> role, List<String> privilege) {
        this.username = username;
        this.role = role;
        this.privilege = privilege;
    }



    public String getUsername() {
        return username;
    }

    public List<String> getRole() {
        return role;
    }

    public List<String> getPrivilege() {
        return privilege;
    }

}
