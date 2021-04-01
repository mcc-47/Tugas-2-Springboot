/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.server.dto;

import java.util.List;

/**
 *
 * @author LENOVO-KL
 */
public class LoginDTO {
    private String userName;
    private List<String> roleName;
    private List<String> privilegeName;

    public LoginDTO() {
    }

    public LoginDTO(String userName, List<String> roleName, List<String> privilegeName) {
        this.userName = userName;
        this.roleName = roleName;
        this.privilegeName = privilegeName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<String> getRoleName() {
        return roleName;
    }

    public void setRoleName(List<String> roleName) {
        this.roleName = roleName;
    }

    public List<String> getPrivilegeName() {
        return privilegeName;
    }

    public void setPrivilegeName(List<String> privilegeName) {
        this.privilegeName = privilegeName;
    }
    
    

    
}
