/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.server.dtos;
import com.mii.server.entities.Employees;
import com.mii.server.entities.Addresses;
import java.util.Date;
/**
 *
 * @author User
 */
public class EmployeeAddressDto {
    private String prefix;
    private String employeeName;
    private Date birthDate;
    private String gender;
    private String email;


    public EmployeeAddressDto() {
    }

//    public EmployeeAddressDto(String employeeName, String birthDate, String gender, String email, String prefix) {
//        this.employeeName = employeeName;
//        this.birthDate = birthDate;
//        this.gender = gender;
//        this.email = email;
//        this.prefix = prefix;
//
//    }

    public EmployeeAddressDto(String prefix, String employeeName, Date birthDate, String gender, String email) {
        this.prefix = prefix;
        this.employeeName = employeeName;
        this.birthDate = birthDate;
        this.gender = gender;
        this.email = email;
       
      
    }

    

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

//    public String getStreet1() {
//        return street1;
//    }
//
//    public void setStreet1(String street1) {
//        this.street1 = street1;
//    }

    
    
    
   
    
}
