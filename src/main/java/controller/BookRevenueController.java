/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.BookRevenueDAO;
import entity.BookRevenue;
import java.util.List;

/**
 *
 * @author huynguyen
 */
public class BookRevenueController {
    public List<BookRevenue> get() {
        BookRevenueDAO dao = new BookRevenueDAO();
        return dao.getAll();
    }
}
