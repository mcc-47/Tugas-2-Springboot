/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.server.dto;

/**
 *
 * @author LENOVO-KL
 */
public class DataLogDTO {
    private String UserName;
    private String UserPassword;

    public DataLogDTO() {
    }

    public DataLogDTO(String UserName, String UserPassword) {
        this.UserName = UserName;
        this.UserPassword = UserPassword;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public String getUserPassword() {
        return UserPassword;
    }

    public void setUserPassword(String UserPassword) {
        this.UserPassword = UserPassword;
    }
    
    
    
}
