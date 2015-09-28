package by.khrapovitsky.model;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="roles")
public class Role implements Serializable,GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "userRoleId",unique = true, nullable = false)
    private Integer userRoleId;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "username", nullable = false)
    private User user;
    @Column(name = "role", nullable = false, length = 45)
    private String role;

    public Role(User user, String role) {
        this.user = user;
        this.role = role;
    }

    public Role() {
    }

    public Integer getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(Integer userRoleId) {
        this.userRoleId = userRoleId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String getAuthority() {
        return role;
    }

}
