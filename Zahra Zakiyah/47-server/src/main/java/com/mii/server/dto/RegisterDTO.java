/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.server.dto;

import com.mii.server.entities.Majors;
import com.mii.server.entities.Universities;
import com.mii.server.entities.Villages;
import java.util.Date;

/**
 *
 * @author Zahra
 */
public class RegisterDTO {
    private Integer employeeId;
    private String employeeName;
    private Date employeeBirthdate;
    private String employeeGender;
    private String employeeEmail;
    private String degree;
    private Integer major;
    private Integer university;
    private String phone;
    private String linkedin;
    private String street1;
    private String street2;
    private Integer villageId;
    private String userName;
    private String userPassword;

    public RegisterDTO(Integer employeeId, String employeeName, Date employeeBirthdate, String employeeGender, String employeeEmail, String degree, Integer major, Integer university, String phone, String linkedin, String street1, String street2, Integer villageId, String userName, String userPassword) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.employeeBirthdate = employeeBirthdate;
        this.employeeGender = employeeGender;
        this.employeeEmail = employeeEmail;
        this.degree = degree;
        this.major = major;
        this.university = university;
        this.phone = phone;
        this.linkedin = linkedin;
        this.street1 = street1;
        this.street2 = street2;
        this.villageId = villageId;
        this.userName = userName;
        this.userPassword = userPassword;
    }

    

    public RegisterDTO() {
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public Date getEmployeeBirthdate() {
        return employeeBirthdate;
    }

    public String getEmployeeGender() {
        return employeeGender;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public String getDegree() {
        return degree;
    }

    public Integer getMajor() {
        return major;
    }

    public Integer getUniversity() {
        return university;
    }

    public String getPhone() {
        return phone;
    }

    public String getLinkedin() {
        return linkedin;
    }

    public String getStreet1() {
        return street1;
    }

    public String getStreet2() {
        return street2;
    }

    public Integer getVillageId() {
        return villageId;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

 
}
