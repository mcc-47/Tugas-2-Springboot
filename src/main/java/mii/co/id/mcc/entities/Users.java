/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package  mii.co.id.mcc.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
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
import mii.co.id.mcc.entities.Employees;
import mii.co.id.mcc.entities.Privileges;
import mii.co.id.mcc.entities.Roles;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author ACER
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
    @JoinTable(name = "user_role", joinColumns = {
        @JoinColumn(name = "user_id", referencedColumnName = "user_id")}, inverseJoinColumns = {
        @JoinColumn(name = "role_id", referencedColumnName = "role_id")})
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Roles> rolesList;
//    @ManyToMany(mappedBy = "usersList", fetch = FetchType.LAZY)
////    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
////    @JsonBackReference
////    @JsonIgnore
//    private List<Roles> rolesList;
    @JoinColumn(name = "user_id", referencedColumnName = "employee_id", insertable = false, updatable = false)
    @OneToOne(optional = true, fetch = FetchType.LAZY)
//    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
//    @JsonBackReference
//    @JsonIgnore
    private Employees employees;

    public Users() {
    }

    public Users(Integer userId) {
        this.userId = userId;
    }

    public Users(Integer userId, String userName, String userPassword, List<Roles> rolesList) {
        this.userId = userId;
        this.userName = userName;
        this.userPassword = userPassword;
        this.rolesList = rolesList;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public Employees getEmployees() {
        return employees;
    }

    public void setEmployees(Employees employees) {
        this.employees = employees;
    }

    @XmlTransient
    public List<Roles> getRolesList() {
        return rolesList;
    }

    public void setRolesList(List<Roles> rolesList) {
        this.rolesList = rolesList;
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
        return "com.mii.server.entities.Users[ userId=" + userId + " ]";
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
//        List<Roles> roles = getRolesList();
//        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
//        for (Roles r : roles) {
//            authorities.add(new SimpleGrantedAuthority(r.getRoleName()));
//            Collection<Privileges> privileges = r.getPrivilegesList();
//            for (Privileges p : privileges) {
//                authorities.add(new SimpleGrantedAuthority(p.getPrivilegeName()));
//            }
//        }
//        return authorities;

          List<GrantedAuthority> authorities = new ArrayList<>();
          this.getRolesList().forEach((rolesList) -> {
                authorities.add(new SimpleGrantedAuthority("ROLE_" + rolesList.getRoleName().toUpperCase()));
          });
          
          return authorities;

    }
    

    @Override
    public String getPassword() {
        return userPassword;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isAccountNonLocked() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isCredentialsNonExpired() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isEnabled() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}