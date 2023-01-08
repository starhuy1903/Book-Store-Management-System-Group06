/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.CategoryRevenue;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.XJdbc;

/**
 *
 * @author huynguyen
 */
public class CategoryRevenueDAO {
    public List<CategoryRevenue> getAll() {
        String sql = "SELECT bc.name AS category, SUM(li.quantity) AS quantity, SUM(o.actual_total) AS total_price FROM line_item AS li JOIN book_store_g6.order AS o ON (li.order_id =  o.id) JOIN book ON (li.book_id = book.ID) JOIN book_category AS bc ON (book.category_id = bc.id) GROUP BY bc.name;";
        return this.getBySql(sql);
    }
    
    private List<CategoryRevenue> getBySql(String sql, Object... args) {
        List<CategoryRevenue> list = new ArrayList<>();
        try {
            ResultSet rs = XJdbc.query(sql, args);
            while (rs.next()) {
                CategoryRevenue cr = new CategoryRevenue();
                cr.setName(rs.getString(1));
                cr.setQuantity(rs.getInt(2));
                cr.setTotalPrice(rs.getInt(3));              

                list.add(cr);
            }
            rs.getStatement().close();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
