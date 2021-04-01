/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.server.dto;

import java.util.Date;


public class UserDTO {
    
    private Integer employeeId;
    private String employeeName;
    private Date employeeBirthdate;
    private String employeeGender;
    private String employeeEmail;
    private String degree;
    private String major;
    private String university;
    private String phone;
    private String linkedin;
    private String street1;
    private String street2;
    private String villageName;
    private String zipCode;
    private String subdistrictName;
    private String kotKab;
    private String districtName;
    private String provinceName;

    public UserDTO(Integer employeeId, String employeeName, Date employeeBirthdate, String employeeGender, String employeeEmail, String degree, String major, String university, String phone, String linkedin, String street1, String street2, String villageName, String zipCode, String subdistrictName, String kotKab, String districtName, String provinceName) {
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
        this.villageName = villageName;
        this.zipCode = zipCode;
        this.subdistrictName = subdistrictName;
        this.kotKab = kotKab;
        this.districtName = districtName;
        this.provinceName = provinceName;
    }

    public UserDTO() {
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

    public String getMajor() {
        return major;
    }

    public String getUniversity() {
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

    public String getVillageName() {
        return villageName;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getSubdistrictName() {
        return subdistrictName;
    }

    public String getKotKab() {
        return kotKab;
    }

    public String getDistrictName() {
        return districtName;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public void setEmployeeBirthdate(Date employeeBirthdate) {
        this.employeeBirthdate = employeeBirthdate;
    }

    public void setEmployeeGender(String employeeGender) {
        this.employeeGender = employeeGender;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setLinkedin(String linkedin) {
        this.linkedin = linkedin;
    }

    public void setStreet1(String street1) {
        this.street1 = street1;
    }

    public void setStreet2(String street2) {
        this.street2 = street2;
    }

    public void setVillageName(String villageName) {
        this.villageName = villageName;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public void setSubdistrictName(String subdistrictName) {
        this.subdistrictName = subdistrictName;
    }

    public void setKotKab(String kotKab) {
        this.kotKab = kotKab;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }
    
    

    
    
}
