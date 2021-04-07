/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.server.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author Zahra
 */
@Entity
@Table(name = "users")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Users.findAll", query = "SELECT u FROM Users u")})
public class Users implements UserDetails {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "user_id")
    private Integer userId;
    @Basic(optional = false)
    @Column(name = "user_name")
    private String userName;
    @Basic(optional = false)
    @Column(name = "user_password")
    private String userPassword;
    
//    @Basic(optional = true)
//    @Column(name = "isAccountNonExpired")
//    private boolean isAccountNonExpired = true;
//    @Basic(optional = true)
//    @Column(name = "isAccountNonLocked")
//    private boolean isAccountNonLocked = true;
//    @Basic(optional = true)
//    @Column(name = "isCredentialsNonExpired")
//    private boolean isCredentialsNonExpired = true;
//    @Basic(optional = true)
//    @Column(name = "isEnabled")
//    private boolean isEnabled = true;
    
    @JoinColumn(name = "user_id", referencedColumnName = "employee_id", insertable = false, updatable = false)
    @OneToOne(optional = true, fetch = FetchType.EAGER)
    private Employees employees;
    @JoinTable(name="user_role", joinColumns = {
        @JoinColumn(name="user_id", referencedColumnName = "user_id")}, inverseJoinColumns = {
        @JoinColumn(name="role_id", referencedColumnName = "role_id")})
    @ManyToMany(fetch = FetchType.EAGER)
    @Basic(optional = true)
    private Collection<Role> roleCollection;

    public Users() {
    }

    public Users(Integer userId) {
        this.userId = userId;
    }

    public Users(Integer userId, String userName, String userPassword) {
        this.userId = userId;
        this.userName = userName;
        this.userPassword = userPassword;
    }

    public Users(Integer userId, String userName, String userPassword, Collection<Role> roleCollection) {
        this.userId = userId;
        this.userName = userName;
        this.userPassword = userPassword;
        this.roleCollection = roleCollection;
    }

    public Users(String userName, Integer userId,  Collection<Role> roleCollection) {
        this.userId = userId;
        this.userName = userName;
        this.roleCollection = roleCollection;
    }
    

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

//    public String getUserName() {
//        return userName;
//    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

//    public String getUserPassword() {
//        return userPassword;
//    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    @XmlTransient
    public Collection<Role> getRoleCollection() {
        return roleCollection;
    }

    public void setRoleCollection(Collection<Role> roleCollection) {
        this.roleCollection = roleCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userId != null ? userId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Users)) {
            return false;
        }
        Users other = (Users) object;
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entities.Users[ userId=" + userId + " ]";
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<Role> roles = getRoleCollection();
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        for (Role r : roles) {
            authorities.add(new SimpleGrantedAuthority("ROLE_"+r.getRoleName().toUpperCase()));
            Collection<Privileges> privileges = r.getPrivilegesCollection();
            for (Privileges p : privileges) {
                authorities.add(new SimpleGrantedAuthority(p.getPrivilegeName().toUpperCase()));
            }
        }
        return authorities;
    }

    @Override
    public String getPassword() {
        return this.userPassword;
    }

    @Override
    public String getUsername() {
        return this.userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
//        return this.isAccountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
//        return this.isAccountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
//        return this.isCredentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return true;
//        return this.isEnabled;
    }
    
}
