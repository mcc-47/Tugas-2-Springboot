/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.server.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ASUS
 */
@Entity
@Table(name = "university")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Universitys.findAll", query = "SELECT u FROM Universitys u")})
public class Universitys implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "university_id")
    private Integer universityId;
    @Basic(optional = false)
    @Column(name = "university_name")
    private String universityName;
    @Basic(optional = false)
    @Column(name = "counts")
    private int counts;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "universityId")
    private List<Educations> educationsList;

    public Universitys() {
    }

    public Universitys(Integer universityId) {
        this.universityId = universityId;
    }

    public Universitys(Integer universityId, String universityName, int counts) {
        this.universityId = universityId;
        this.universityName = universityName;
        this.counts = counts;
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

    public int getCounts() {
        return counts;
    }

    public void setCounts(int counts) {
        this.counts = counts;
    }

    @XmlTransient
    public List<Educations> getEducationsList() {
        return educationsList;
    }

    public void setEducationsList(List<Educations> educationsList) {
        this.educationsList = educationsList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (universityId != null ? universityId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Universitys)) {
            return false;
        }
        Universitys other = (Universitys) object;
        if ((this.universityId == null && other.universityId != null) || (this.universityId != null && !this.universityId.equals(other.universityId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mii.server.entities.Universitys[ universityId=" + universityId + " ]";
    }
    
}
