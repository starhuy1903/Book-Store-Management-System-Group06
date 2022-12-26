/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import enumeration.UserRole;

/**
 *
 * @author Huy
 */
public class User {
    private Long id;
    private String username;
    private String password;
    private String authority;
    
    public User() {}

    public User(Long id, String username, String password, String authority) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.authority = authority;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.authority = "STAFF";
    }

    public User(Long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }
    
    public User(String username, String password, String authority) {
        this.username = username;
        this.password = password;
        this.authority = authority;
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

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
    
    @Override
    public String toString() {
        return "username=" + username + ", password=" + password ;
    }
    
}
