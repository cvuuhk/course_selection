package edu.hhuc.course_selection.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Collection;
import java.util.List;

@Table(name = "student_login")
@Entity
public class StudentLogin implements UserDetails{
    @Id
    @Column(name = "username", nullable = false, columnDefinition = "char(10)")
    private String username;
    @Column(name = "password", nullable = false, columnDefinition = "char(60)")
    private String password;
    @Column(name = "role", nullable = false, columnDefinition = "varchar(20)")
    private String role = "STUDENT";
    @Column(name = "locked", nullable = false)
    private Boolean locked = false;
    @Column(name = "enabled", nullable = false)
    private Boolean enabled = true;
    @Column(name = "account_expired", nullable = false)
    private Boolean accountExpired = false;
    @Column(name = "credentials_expired", nullable = false)
    private Boolean credentialsExpired = false;
    
    @Override
    public String getUsername(){ return username; }
    @Override
    public boolean isAccountNonExpired(){ return !accountExpired; }
    @Override
    public boolean isAccountNonLocked(){ return !locked; }
    @Override
    public boolean isCredentialsNonExpired(){ return !credentialsExpired; }
    @Override
    public boolean isEnabled(){ return enabled; }
    @Override
    public String getPassword(){ return password; }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities(){
        return List.of(new SimpleGrantedAuthority("ROLE_"+role));
    }
    
    public void setUsername(String username){ this.username = username; }
    public void setPassword(String password){ this.password = password; }
    public void setRole(String role){ this.role = role; }
    public String getRole(){ return role; }
    public void setLocked(Boolean locked){ this.locked = locked; }
    public Boolean getLocked(){ return locked; }
    public void setEnabled(Boolean enabled){ this.enabled = enabled; }
    public Boolean getEnabled(){ return enabled; }
    public void setAccountExpired(Boolean accountExpired){ this.accountExpired = accountExpired; }
    public Boolean getAccountExpired(){ return accountExpired; }
    public void setCredentialsExpired(Boolean credentialsExpired){ this.credentialsExpired = credentialsExpired; }
    public Boolean getCredentialsExpired(){ return credentialsExpired; }
    
    @Override
    public String toString(){
        return "StudentLogin{"+
                "username="+username+'\''+
                "password="+password+'\''+
                "role="+role+'\''+
                "locked="+locked+'\''+
                "enabled="+enabled+'\''+
                "accountExpired="+accountExpired+'\''+
                "credentialsExpired="+credentialsExpired+'\''+
                '}';
    }
}
