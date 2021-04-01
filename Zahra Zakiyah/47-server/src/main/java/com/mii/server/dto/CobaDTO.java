/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.server.dto;

import java.util.Date;

/**
 *
 * @author Zahra
 */
public class CobaDTO {
    
    private Integer employeeId;
    private String employeeName;
    private Date employeeBirthdate;
    private String employeeGender;
    private String employeeEmail;
    private String street1;
    private String street2;
    private String villageName;
    private String zipCode;
    private String subdistrictName;
    private String kotKab;
    private String districtName;
    private String provinceName;  

    public CobaDTO(Integer employeeId, String employeeName, Date employeeBirthdate, String employeeGender, String employeeEmail, String street1, String street2, String villageName, String zipCode, String subdistrictName, String kotKab, String districtName, String provinceName) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.employeeBirthdate = employeeBirthdate;
        this.employeeGender = employeeGender;
        this.employeeEmail = employeeEmail;
        this.street1 = street1;
        this.street2 = street2;
        this.villageName = villageName;
        this.zipCode = zipCode;
        this.subdistrictName = subdistrictName;
        this.kotKab = kotKab;
        this.districtName = districtName;
        this.provinceName = provinceName;
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

    public Date getEmployeeBirthdate() {
        return employeeBirthdate;
    }

    public void setEmployeeBirthdate(Date employeeBirthdate) {
        this.employeeBirthdate = employeeBirthdate;
    }

    public String getEmployeeGender() {
        return employeeGender;
    }

    public void setEmployeeGender(String employeeGender) {
        this.employeeGender = employeeGender;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public String getStreet1() {
        return street1;
    }

    public void setStreet1(String street1) {
        this.street1 = street1;
    }

    public String getStreet2() {
        return street2;
    }

    public void setStreet2(String street2) {
        this.street2 = street2;
    }

    public String getVillageName() {
        return villageName;
    }

    public void setVillageName(String villageName) {
        this.villageName = villageName;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getSubdistrictName() {
        return subdistrictName;
    }

    public void setSubdistrictName(String subdistrictName) {
        this.subdistrictName = subdistrictName;
    }

    public String getKotKab() {
        return kotKab;
    }

    public void setKotKab(String kotKab) {
        this.kotKab = kotKab;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }
    
    
}
