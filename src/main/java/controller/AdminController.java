/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.AdminDAO;
import entity.Admin;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dai Hai
 */
public class AdminController {
    public  Admin getAdmin() {
        AdminDAO da = new AdminDAO();
        return da.getAdmin();
    }
    
    public void update(Admin admin) {
        try {
            AdminDAO da = new AdminDAO();
            da.update(admin);
        } catch (SQLException ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
