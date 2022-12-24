/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.*;
import entity.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Dai Hai
 */
public class EmployeeController {
    
    public  Employee getEmployee(Long id) {
        EmployeeDAO da = new EmployeeDAO();
        return da.getEmployee(id);
    }
    
    public void update(Employee employee) {
        try {
            EmployeeDAO dao = new EmployeeDAO();
            dao.update(employee);
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
}
