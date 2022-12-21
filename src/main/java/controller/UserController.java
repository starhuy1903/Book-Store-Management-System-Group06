/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package controller;
import java.util.*;
import dao.*;
import entity.*;

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
    
    public  void update(User user) {
        UserDAO dao = new UserDAO();
        dao.update(user);
    }
}
