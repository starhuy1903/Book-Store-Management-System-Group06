/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.AdminDAO;
import entity.Admin;
import java.util.List;

/**
 *
 * @author Dai Hai
 */
public class AdminController {

    public List<Admin> getAdmin() {
        AdminDAO da = new AdminDAO();
        return da.getAll();
    }

    public void update(Admin admin) {
        AdminDAO da = new AdminDAO();
        da.update(admin);
    }
}
