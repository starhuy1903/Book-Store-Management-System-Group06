/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.AdminDAO;
import entity.Admin;

/**
 *
 * @author Dai Hai
 */
public class AdminController {
    public  Admin getAll() {
        AdminDAO da = new AdminDAO();
        return da.getAll();
    }
    
    public void update(Admin admin) {
        AdminDAO da = new AdminDAO(); 
        da.update(admin);
    }
}
