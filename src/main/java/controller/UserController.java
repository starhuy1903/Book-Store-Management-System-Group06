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
public class UserController {

    public List<User> getAll() {
        UserDAO da = new UserDAO();
        return da.getAll();
    }

    public void addUser(String username, String password) {
        UserDAO da = new UserDAO();

        if (validateUsername(username)) {
            User user = new User(username, password);
            da.create(user);
        }
    }

    public User getUserByUsername(String username) {
        UserDAO da = new UserDAO();
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

    public void update(User user) {
        UserDAO dao = new UserDAO();
        dao.update(user);
    }

    private boolean validateUsername(String username) {
        UserDAO da = new UserDAO();
        if (da.getByUsername(username) != null) {
            return false;
        }
        return true;
    }
}
