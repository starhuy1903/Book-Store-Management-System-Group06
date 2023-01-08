/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import enumeration.ActiveStatus;
import enumeration.Role;

/**
 *
 * @author Huy
 */
public class Account {
    private Long id;
    private String username;
    private String password;
    private Role role;
    private ActiveStatus isActive;
    
    public Account() {}

    public Account(String username, String password, Role role) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.isActive = ActiveStatus.ENABLED;
    }

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
        this.isActive = ActiveStatus.ENABLED;
        this.role = Role.STAFF;
    }
    
    public Account(String username, String password, Role role, ActiveStatus isActive) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.isActive = isActive;
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public ActiveStatus getIsActive() {
        return isActive;
    }

    public void setIsActive(ActiveStatus isActive) {
        this.isActive = isActive;
    }
    
    @Override
    public String toString() {
        return "Account{" + "id=" + id + ", username=" + username + ", password=" + password + ", role=" + role + ", isActive=" + isActive + '}';
    }
    
    
}
