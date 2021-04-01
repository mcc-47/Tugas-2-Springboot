/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.server.dto;

import java.util.Date;

/**
 *
 * @author ACER
 */

public class RegisterDTO {
    private String prefix;
    private Integer idEmployee;
    private String nameEmployee;
    private Date birthdate;
    private String gender;
    private String email;
    private Integer villageId;
    private String phone;
    private String linkedin;
    private Integer majorId;
    private Integer universityId;

    public RegisterDTO() {
    }

    
    public RegisterDTO(String prefix, Integer idEmployee, String nameEmployee, Date birthdate, String gender, String email, Integer villageId, String phone, String linkedin, Integer majorId, Integer universityId) {
        this.prefix = prefix;
        this.idEmployee = idEmployee;
        this.nameEmployee = nameEmployee;
        this.birthdate = birthdate;
        this.gender = gender;
        this.email = email;
        this.villageId = villageId;
        this.phone = phone;
        this.linkedin = linkedin;
        this.majorId = majorId;
        this.universityId = universityId;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public Integer getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(Integer idEmployee) {
        this.idEmployee = idEmployee;
    }

    public String getNameEmployee() {
        return nameEmployee;
    }

    public void setNameEmployee(String nameEmployee) {
        this.nameEmployee = nameEmployee;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
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

    public Integer getVillageId() {
        return villageId;
    }

    public void setVillageId(Integer villageId) {
        this.villageId = villageId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLinkedin() {
        return linkedin;
    }

    public void setLinkedin(String linkedin) {
        this.linkedin = linkedin;
    }

    public Integer getMajorId() {
        return majorId;
    }

    public void setMajorId(Integer majorId) {
        this.majorId = majorId;
    }

    public Integer getUniversityId() {
        return universityId;
    }

    public void setUniversityId(Integer universityId) {
        this.universityId = universityId;
    }
    
    
    
}
