/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dto;

import java.util.Date;

/**
 *
 * @author jakab
 */
public class EmployeeRegistDto {
    
    private String prefix;
    private Integer employeeId;
    private String employeeName;
    private Date birthDate;
    private String gender;
    private String email;
    private Integer villageId;
    private String degree;
    private Integer majorId;
    private Integer universityId;
    private String phone;
    private String linkedin;

    public EmployeeRegistDto() {
    }

    public EmployeeRegistDto(String prefix, Integer employeeId, String employeeName, Date birthDate, String gender, String email, Integer villageId, String degree, Integer majorId, Integer universityId, String phone, String linkedin) {
        this.prefix = prefix;
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.birthDate = birthDate;
        this.gender = gender;
        this.email = email;
        this.villageId = villageId;
        this.degree = degree;
        this.majorId = majorId;
        this.universityId = universityId;
        this.phone = phone;
        this.linkedin = linkedin;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
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

    public Integer getVillageId() {
        return villageId;
    }

    public void setVillageId(Integer villageId) {
        this.villageId = villageId;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
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
    
}
