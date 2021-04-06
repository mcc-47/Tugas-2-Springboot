/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mii.co.id.mcc.dto;

import static com.google.common.collect.Iterables.any;
import java.util.Collection;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;

/**
 *
 * @author ROG
 */
public class UserSessionDTO {
    private String userName;
    private List<String> authorities;

    public UserSessionDTO() {
    }

    public UserSessionDTO(String userName, List<String> authorities) {
        this.userName = userName;
        this.authorities = authorities;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<String> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<String> authorities) {
        this.authorities = authorities;
    }

    
    
    
    
    
}
