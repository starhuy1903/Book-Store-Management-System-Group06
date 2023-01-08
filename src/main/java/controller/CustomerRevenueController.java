/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.CustomerRevenueDAO;
import entity.CustomerRevenue;
import java.util.List;

/**
 *
 * @author huynguyen
 */
public class CustomerRevenueController {
    public List<CustomerRevenue> get() {
        CustomerRevenueDAO dao = new CustomerRevenueDAO();
        return dao.getAll();
    }
}
