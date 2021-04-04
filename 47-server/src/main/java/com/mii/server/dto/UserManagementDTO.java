/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.server.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.mii.server.entities.Addresses;
import com.mii.server.entities.Districts;
import com.mii.server.entities.Subdistricts;
import com.mii.server.entities.Villages;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.persistence.JoinColumn;

/**
 *
 * @author LENOVO-KL
 */

public class UserManagementDTO {
   private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
   private String Prefix;
   private Integer employeeId;
   private String employeeName;
   private Date birthDate;
   private String gender;
   private String email;
   private Integer addressId;
   private String street1;
   private String street2;
   private Integer villageId;
   private String villageName;
   private String zipCode;
   private Integer subdistrictId;
   private String subdistrictName;
   private String kab;
   private Integer districtId;
   private String districtName;
   private Integer provinceId;
   private String provinceName;
   private Integer contactId;
   private String phone;
   private String linkedin;
   private Integer educationId;
   private String degeree;
   private Integer majorId;
   private String majorName;
   private Integer universityId;
   private String universityName;
   private Integer userId;
   private String userName;
   private String userPassword;
   private Integer roleId;
   private String roleName;
    public UserManagementDTO(Integer villageId) {
        this.villageId = villageId;
    }
    //buat insert
    public UserManagementDTO(String Prefix, Integer employeeId, 
            String employeeName, Date birthDate, String gender, String email,
            Integer villageId, String phone, String linkedin, String degeree, Integer majorId, 
            Integer universityId) {
        this.Prefix = Prefix;
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.birthDate = birthDate;
        this.gender = gender;
        this.email = email;
        this.villageId = villageId;
        this.phone = phone;
        this.linkedin = linkedin;
        this.degeree = degeree;
        this.majorId = majorId;
        this.universityId = universityId;
    }
    
    //buat-regis-sama-login
    public UserManagementDTO(String Prefix, Integer employeeId, String employeeName, Date birthDate, String gender, String email, Integer villageId, String phone, String linkedin, Integer majorId, Integer userId, String userName, String userPassword) {
        this.Prefix = Prefix;
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.birthDate = birthDate;
        this.gender = gender;
        this.email = email;
        this.villageId = villageId;
        this.phone = phone;
        this.linkedin = linkedin;
        this.majorId = majorId;
        this.userId = userId;
        this.userName = userName;
        this.userPassword = userPassword;
        
    }

    public UserManagementDTO(String Prefix, Integer employeeId, String employeeName, Date birthDate, String gender, String email, Integer villageId, String phone, String linkedin, String degeree, Integer majorId, Integer universityId, String userName, String userPassword) {
        this.Prefix = Prefix;
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.birthDate = birthDate;
        this.gender = gender;
        this.email = email;
        this.villageId = villageId;
        this.phone = phone;
        this.linkedin = linkedin;
        this.degeree = degeree;
        this.majorId = majorId;
        this.universityId = universityId;
        this.userName = userName;
        this.userPassword = userPassword;
    }
    

    public UserManagementDTO(String Prefix, Integer employeeId, String employeeName, Date birthDate, String gender, String email, Integer villageId, String phone, String linkedin, Integer majorId, Integer universityId, String userName, String userPassword, String roleName) {
        this.Prefix = Prefix;
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.birthDate = birthDate;
        this.gender = gender;
        this.email = email;
        this.villageId = villageId;
        this.phone = phone;
        this.linkedin = linkedin;
        this.majorId = majorId;
        this.universityId = universityId;
        this.userName = userName;
        this.userPassword = userPassword;
        this.roleName = roleName;
    }
    


    
  //buat nampilin
    public UserManagementDTO(String Prefic, Integer employeeId,
            String employeeName, Date birthDate, String gender,
            String email, String street1, String street2, String villageName, 
            String zipCode, String subdistrictName, String kab, String districtName,
            String provinceName) {
        this.Prefix = Prefix;
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.birthDate = birthDate;
        this.gender = gender;
        this.email = email;
        this.street1 = street1;
        this.street2 = street2;
        this.villageName = villageName;
        this.zipCode = zipCode;
        this.subdistrictName = subdistrictName;
        this.kab = kab;
        this.districtName = districtName;
        this.provinceName = provinceName;
    }
    
    
    
    public UserManagementDTO(){
        
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
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
  
    public String getPrefix() {
        return Prefix;
    }

    public void setPrefix(String Prefix) {
        this.Prefix = Prefix;
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

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
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

    public Integer getVillageId() {
        return villageId;
    }

    public void setVillageId(Integer villageId) {
        this.villageId = villageId;
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

    public Integer getSubdistrictId() {
        return subdistrictId;
    }

    public void setSubdistrictId(Integer subdistrictId) {
        this.subdistrictId = subdistrictId;
    }

    public String getSubdistrictName() {
        return subdistrictName;
    }

    public void setSubdistrictName(String subdistrictName) {
        this.subdistrictName = subdistrictName;
    }

    public String getKab() {
        return kab;
    }

    public void setKab(String kab) {
        this.kab = kab;
    }

    public Integer getDistrictId() {
        return districtId;
    }

    public void setDistrictId(Integer districtId) {
        this.districtId = districtId;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public Integer getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Integer provinceId) {
        this.provinceId = provinceId;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public Integer getContactId() {
        return contactId;
    }

    public void setContactId(Integer contactId) {
        this.contactId = contactId;
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

    public Integer getEducationId() {
        return educationId;
    }

    public void setEducationId(Integer educationId) {
        this.educationId = educationId;
    }

    public String getDegeree() {
        return degeree;
    }

    public void setDegeree(String degeree) {
        this.degeree = degeree;
    }

    public Integer getMajorId() {
        return majorId;
    }

    public void setMajorId(Integer majorId) {
        this.majorId = majorId;
    }

    public String getMajorName() {
        return majorName;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }

    public Integer getUniversityId() {
        return universityId;
    }

    public void setUniversityId(Integer universityId) {
        this.universityId = universityId;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }
    

   


    
    
   
}
