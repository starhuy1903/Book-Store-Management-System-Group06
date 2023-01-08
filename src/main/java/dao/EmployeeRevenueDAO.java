/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.EmployeeRevenue;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.XJdbc;

/**
 *
 * @author huynguyen
 */
public class EmployeeRevenueDAO {
    public List<EmployeeRevenue> getAll() {
        String sql = "SELECT e.name, e.date_of_birth, acc.username, SUM(o.actual_total) AS total_price FROM line_item AS li\n" +
"	JOIN book_store_g6.order AS o ON (li.order_id = o.id)\n" +
"    JOIN employee AS e ON (o.employee_id = e.id)\n" +
"    JOIN account AS acc ON (e.user_id = acc.id)\n" +
"    GROUP BY e.name, e.date_of_birth, acc.username;";
        return this.getBySql(sql);
    }
    
    private List<EmployeeRevenue> getBySql(String sql, Object... args) {
        List<EmployeeRevenue> list = new ArrayList<>();
        try {
            ResultSet rs = XJdbc.query(sql, args);
            while (rs.next()) {
                EmployeeRevenue cr = new EmployeeRevenue();
                cr.setName(rs.getString(1));
                cr.setDob(rs.getDate(2));
                cr.setUsername(rs.getString(3));
                cr.setTotalPrice(rs.getInt(4));              

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
