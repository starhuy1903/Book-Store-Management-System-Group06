/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.CategoryRevenueDAO;
import entity.CategoryRevenue;
import java.util.List;

/**
 *
 * @author huynguyen
 */
public class CategoryRevenueController {

    public List<CategoryRevenue> get() {
        CategoryRevenueDAO dao = new CategoryRevenueDAO();
        return dao.getAll();
    }
}
