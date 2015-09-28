package by.khrapovitsky.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="users")
public class User implements Serializable,UserDetails{

    @Id
    @Column(name = "username",unique = true,nullable = false)
    private String username;
    @Column(name ="name",nullable = true)
    private String name;
    @Column(name="password",nullable = false)
    private String password;
    @Column(name="email",nullable = false,unique = true)
    private String email;
    @Column(name="isEnabled",nullable = false)
    private Boolean isEnabled;
    @Column(name="dateOfRegistration",nullable = false)
    private Timestamp dateOfRegistration;
    @Column(name="dateOfLastUse",nullable = true)
    private Timestamp dateOfLastUse;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user",cascade = CascadeType.ALL)
    private Set<Role> userRole = new HashSet<Role>(0);
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "user",fetch = FetchType.LAZY)
    private Set<Bookmark> bookmarks;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "user",fetch = FetchType.LAZY)
    private Set<FileStatus> fileStatuses;

    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.dateOfRegistration = new Timestamp(new java.util.Date().getTime());
        this.isEnabled = false;
    }

    public User(){
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getIsEnabled() {
        return isEnabled;
    }

    public void setIsEnabled(Boolean isEnabled) {
        this.isEnabled = isEnabled;
    }

    public Timestamp getDateOfRegistration() {
        return dateOfRegistration;
    }

    public void setDateOfRegistration(Timestamp dateOfRegistration) {
        this.dateOfRegistration = dateOfRegistration;
    }

    public Timestamp getDateOfLastUse() {
        return dateOfLastUse;
    }

    public void setDateOfLastUse(Timestamp dateOfLastUse) {
        this.dateOfLastUse = dateOfLastUse;
    }

    public Set<Role> getUserRole() {
        return userRole;
    }

    public void setUserRole(Set<Role> userRole) {
        this.userRole = userRole;
    }

    public Set<Bookmark> getBookmarks() {
        return bookmarks;
    }

    public void setBookmarks(Set<Bookmark> bookmarks) {
        this.bookmarks = bookmarks;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return isEnabled;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return userRole;
    }

}
