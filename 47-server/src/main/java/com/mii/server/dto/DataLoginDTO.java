
package com.mii.server.dto;

/**
 *
 * @author ASUS
 */
public class DataLoginDTO {
    private String userName;
    private String userPassword;

    public DataLoginDTO(String userName, String userPassword) {
        this.userName = userName;
        this.userPassword = userPassword;
    }

    public DataLoginDTO() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
    
    
}
