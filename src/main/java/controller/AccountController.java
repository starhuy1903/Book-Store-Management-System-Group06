/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.*;
import dao.*;
import entity.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import view.Login;

/**
 *
 * @author Dai Hai
 */
public class AccountController {

    public List<Account> getAll() {
        AccountDAO da = new AccountDAO();
        return da.getAll();
    }

    public void addAccount(Account acc) {
        AccountDAO da = new AccountDAO();
        
        // TODO: verify username is uniq
        da.create(acc);  
    }

    public Account getAccountByUsername(String username) {
        AccountDAO da = new AccountDAO();
        return da.getByUsername(username);
    }

    public String hashPassword(String password) {
        String resultString = null;

        try {
            MessageDigest m = MessageDigest.getInstance("MD5");
            m.update(password.getBytes());
            byte[] bytes = m.digest();

            StringBuilder s = new StringBuilder();

            for (int i = 0; i < bytes.length; i++) {
                s.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }

            resultString = s.toString();

        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }

        return resultString;
    }

    public void update(Account acc) {
        AccountDAO dao = new AccountDAO();
        dao.update(acc);
    }
    
    public void delete(String username) {
        AccountDAO dao = new AccountDAO();
        dao.deleteByUsername(username);
    }

    private boolean validateUsername(String username) {
        AccountDAO da = new AccountDAO();
        if (da.getByUsername(username) != null) {
            return false;
        }
        return true;
    }
}
