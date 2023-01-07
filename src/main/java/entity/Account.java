/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import enumeration.UserRole;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Huy
 */
public class Account {
    private Long id;
    private String username;
    private String password;
    private String role;
    private Boolean isActive;
    
    public Account() {}

    public Account(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.isActive = true;
    }

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
        this.isActive = true;
        this.role = "STAFF";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }
    
    @Override
    public String toString() {
        return "Account{" + "id=" + id + ", username=" + username + ", password=" + password + ", role=" + role + ", isActive=" + isActive + '}';
    }
    
    
}
