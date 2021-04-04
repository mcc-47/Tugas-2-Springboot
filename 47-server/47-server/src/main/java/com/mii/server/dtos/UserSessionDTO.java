/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.server.dtos;

import java.util.List;

/**
 *
 * @author William Yangjaya
 */
public class UserSessionDTO {
    private String username;
    private List<String> grantedAuthoritys;

    public UserSessionDTO() {
    }

    public UserSessionDTO(String username, List<String> grantedAuthoritys) {
        this.username = username;
        this.grantedAuthoritys = grantedAuthoritys;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<String> getGrantedAuthoritys() {
        return grantedAuthoritys;
    }

    public void setGrantedAuthoritys(List<String> grantedAuthoritys) {
        this.grantedAuthoritys = grantedAuthoritys;
    }
    
    
}
