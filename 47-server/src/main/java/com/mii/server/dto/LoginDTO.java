
package com.mii.server.dto;

import java.util.List;


public class LoginDTO {
    
    private String userName;
    private List<String> grantedAuthoritys;

    public LoginDTO(String userName, List<String> grantedAuthoritys) {
        this.userName = userName;
        this.grantedAuthoritys = grantedAuthoritys;
    }

    public LoginDTO() {
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