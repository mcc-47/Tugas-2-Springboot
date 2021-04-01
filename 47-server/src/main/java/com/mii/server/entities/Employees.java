/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.server.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ASUS
 */
@Entity
@Table(name = "employee")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Employees.findAll", query = "SELECT e FROM Employees e")})
public class Employees implements Serializable {

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "employees", fetch = FetchType.LAZY)
    private Users users;

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "prefix")
    private String prefix;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "employee_id")
    private Integer employeeId;
    @Basic(optional = false)
    @Column(name = "employee_name")
    private String employeeName;
    @Basic(optional = false)
    @Column(name = "birth_date")
    @Temporal(TemporalType.DATE)
    private Date birthDate;
    @Basic(optional = false)
    @Column(name = "gender")
    private String gender;
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "employees")
    private Addresses villageId;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "employees")
    private Contacts phone;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "employees")
    private Contacts linkedin;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "employees")
    private Educations major;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "employees")
    private Educations university;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "employees")
    private Educations educations;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "employees")
    private Contacts contacts;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "employees")
    private Addresses addressId;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "employees")
    private Addresses addresses;
    
    
    public Employees() {
    }

    public Employees(String prefix, Integer employeeId, String employeeName, String email) {
        this.prefix = prefix;
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.email = email;
    }
    
   
    public Employees(String prefix, Integer employeeId, String employeeName, Date birthDate, String gender, String email, 
            Educations educations, Contacts contacts, Addresses addresses) {
        this.prefix = prefix;
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.birthDate = birthDate;
        this.gender = gender;
        this.email = email;
        this.educations = educations;
        this.contacts = contacts;
        this.addresses = addresses;
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

    public Addresses getVillageId() {
        return villageId;
    }

    public void setVillageId(Addresses villageId) {
        this.villageId = villageId;
    }

    public Contacts getPhone() {
        return phone;
    }

    public void setPhone(Contacts phone) {
        this.phone = phone;
    }

    public Contacts getLinkedin() {
        return linkedin;
    }

    public void setLinkedin(Contacts linkedin) {
        this.linkedin = linkedin;
    }

    public Educations getMajor() {
        return major;
    }

    public void setMajor(Educations major) {
        this.major = major;
    }

    public Educations getUniversity() {
        return university;
    }

    public void setUniversity(Educations university) {
        this.university = university;
    }

    public Educations getEducations() {
        return educations;
    }

    public void setEducations(Educations educations) {
        this.educations = educations;
    }

    public Contacts getContacts() {
        return contacts;
    }

    public void setContacts(Contacts contacts) {
        this.contacts = contacts;
    }

    public Addresses getAddressId() {
        return addressId;
    }

    public void setAddressId(Addresses addressId) {
        this.addressId = addressId;
    }

    public Addresses getAddresses() {
        return addresses;
    }

    public void setAddresses(Addresses addresses) {
        this.addresses = addresses;
    }
            
   
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (employeeId != null ? employeeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Employees)) {
            return false;
        }
        Employees other = (Employees) object;
        if ((this.employeeId == null && other.employeeId != null) || (this.employeeId != null && !this.employeeId.equals(other.employeeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mii.server.entities.Employees[ employeeId=" + employeeId + " ]";
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }
    
    
}
