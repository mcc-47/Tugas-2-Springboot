/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.server.dto;

import com.mii.server.entities.Major;
import com.mii.server.entities.University;
import com.mii.server.entities.Village;
import java.util.Date;

/**
 *
 * @author ASUS
 */
public class RegistrationDto {
    private String prefix;
    private int employeeId;
    private String employeeName;
    private Date birthDate;
    private String gender;
    private String email;
    private String phone;
    private String linkedin;
    private int villageId;
    private int majorId;
    private int universityId;
    private String username;
    private String password;

    public RegistrationDto() {
    }

    public RegistrationDto(
            String prefix,
            int employeeId, 
            String employeeName, 
            Date birthDate, 
            String gender, 
            String email, 
            String phone, 
            String linkedin, 
            int villageId, 
            int majorId, 
            int universityId, 
            String username, 
            String password) {
        this.prefix = prefix;
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.birthDate = birthDate;
        this.gender = gender;
        this.email = email;
        this.phone = phone;
        this.linkedin = linkedin;
        this.villageId = villageId;
        this.majorId = majorId;
        this.universityId = universityId;
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getPrefix() {
        return prefix;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public String getGender() {
        return gender;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getLinkedin() {
        return linkedin;
    }

    public int getVillageId() {
        return villageId;
    }

    public int getMajorId() {
        return majorId;
    }

    public int getUniversityId() {
        return universityId;
    }

    
}
