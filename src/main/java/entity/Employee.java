/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.util.Date;

/**
 *
 * @author Huy
 */
public class Employee {
    private Long id;
    private String name;
    private Date dob;
    private String bankAccount;
    private boolean isActivateAccount;
    private Long userId;

    public Employee() {
    }
    
    public Employee(String name, Date dob, String bankAccount, Long userId) {
        this.name = name;
        this.dob = dob;
        this.bankAccount = bankAccount;
        this.isActivateAccount = true;
        this.userId = userId;
    }

    public Employee(Long id, String name, Date dob, String bankAccount, boolean isActivateAccount, Long userId) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.bankAccount = bankAccount;
        this.isActivateAccount = isActivateAccount;
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

    public Date getDateOfBirth() {
        return dob;
    }

    public void setDateOfBirth(Date dob) {
        this.dob = dob;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public boolean isActivateAccount() {
        return isActivateAccount;
    }

    public void setIsActivateAccount(boolean isActivateAccount) {
        this.isActivateAccount = isActivateAccount;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
