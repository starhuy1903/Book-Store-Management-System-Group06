/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.sql.Date;

/**
 *
 * @author Huy
 */
public class Employee {
    private Long id;
    private String name;
    private Date date_of_birth;
    private String bank_account;
    private boolean is_activate_account;
    private Long userId;

    public Employee() {
    }

    public Employee(Long id, String name, Date date_of_birth, String bank_account, boolean is_activate_account, Long userId) {
        this.id = id;
        this.name = name;
        this.date_of_birth = date_of_birth;
        this.bank_account = bank_account;
        this.is_activate_account = is_activate_account;
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(Date date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public String getBank_account() {
        return bank_account;
    }

    public void setBank_account(String bank_account) {
        this.bank_account = bank_account;
    }

    public boolean isIs_activate_account() {
        return is_activate_account;
    }

    public void setIs_activate_account(boolean is_activate_account) {
        this.is_activate_account = is_activate_account;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
    
    
}
