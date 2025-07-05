package com.easybank.easybank.model;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;

import java.io.Serializable;

@Entity
@Table(name = "authorities")
public class Authorities implements GrantedAuthority, Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private  String role;
    public Authorities(){}
    public Authorities(String role){
        this.role=role;
    }
    @Override
    public String getAuthority() {
        return this.role;
    }
    public void SetRole(String role){
        this.role=role;
    };
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    
    public void setUser (User user){
        this.user = user;
    }

    public String getRole() {
        return role;
    }

    public User getUser() {
        return user;
    }
}
