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
    public List<User> getAll(){
        UserDAO da = new UserDAO();
        return da.getAll();
    }
 
    
//    public boolean getByUsernameAndPassword(String userName, String pass){
//        //System.out.println("user= "+userName+ " pass= "+pass);
//        UserDAO da = new UserDAO();
//        User check = da.getByUsernameAndPassword(userName, pass);
//        System.out.println("Id"+" = "+check.getId());
//        return  check!=null ? true: false;
//    }
    
    public String hashPassword(String password) {
        String resultString=null;
        
        try {
            
            MessageDigest m = MessageDigest.getInstance("MD5");
            m.update(password.getBytes());
            byte[] bytes=m.digest();
            
            StringBuilder s = new StringBuilder();
            
            for(int i=0;i<bytes.length;i++){
                s.append(Integer.toString((bytes[i]&0xff) + 0x100,16).substring(1));
            }
            
            resultString=s.toString();
            
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return resultString;
    }
    
    public  void update(User user) {
        UserDAO dao = new UserDAO();
        dao.update(user);
    }
}
