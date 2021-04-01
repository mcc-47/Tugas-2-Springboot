/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.server.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author MyLaptop
 */
@Entity
@Table(name = "education")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Educations.findAll", query = "SELECT e FROM Educations e")})
public class Educations implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = true)
    @Column(name = "prefix")
    private String prefix;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "education_id")
    private Integer educationId;
    @Column(name = "degree")
    private String degree;
    @JoinColumn(name = "education_id", referencedColumnName = "employee_id", insertable = false, updatable = false)
    @OneToOne(optional = true, fetch = FetchType.LAZY)
    private Employees employees;
    @JoinColumn(name = "major_id", referencedColumnName = "major_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Majors majorId;
    @JoinColumn(name = "university_id", referencedColumnName = "university_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Universities universityId;

    public Educations() {
    }

    public Educations(String prefix, Integer educationId, Majors majorId, Universities universityId) {
        this.prefix = prefix;
        this.educationId = educationId;
        this.majorId = majorId;
        this.universityId = universityId;
    }
  
    public Educations(Integer educationId) {
        this.educationId = educationId;
    }

   

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public Integer getEducationId() {
        return educationId;
    }

    public void setEducationId(Integer educationId) {
        this.educationId = educationId;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public Employees getEmployees() {
        return employees;
    }

    public void setEmployees(Employees employees) {
        this.employees = employees;
    }

    public Majors getMajorId() {
        return majorId;
    }

    public void setMajorId(Majors majorId) {
        this.majorId = majorId;
    }

    public Universities getUniversityId() {
        return universityId;
    }

    public void setUniversityId(Universities universityId) {
        this.universityId = universityId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (educationId != null ? educationId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Educations)) {
            return false;
        }
        Educations other = (Educations) object;
        if ((this.educationId == null && other.educationId != null) || (this.educationId != null && !this.educationId.equals(other.educationId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mii.server.entity.Educations[ educationId=" + educationId + " ]";
    }
    
}
