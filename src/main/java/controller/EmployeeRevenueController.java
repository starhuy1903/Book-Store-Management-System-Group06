/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.EmployeeRevenueDAO;
import entity.EmployeeRevenue;
import java.util.List;

/**
 *
 * @author huynguyen
 */
public class EmployeeRevenueController {
    public List<EmployeeRevenue> get() {
        EmployeeRevenueDAO dao = new EmployeeRevenueDAO();
        return dao.getAll();
    }
}
