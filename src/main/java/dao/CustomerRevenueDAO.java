/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.CustomerRevenue;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.XJdbc;

/**
 *
 * @author huynguyen
 */
public class CustomerRevenueDAO {
    public List<CustomerRevenue> getAll() {
        String sql = "SELECT c.name, c.email, SUM(o.actual_total) AS price FROM book_store_g6.order as o\n" +
"		JOIN customer AS c ON (o.customer_id = c.id)\n" +
"        GROUP BY c.name, c.email;";
        return this.getBySql(sql);
    }
    
    private List<CustomerRevenue> getBySql(String sql, Object... args) {
        List<CustomerRevenue> list = new ArrayList<>();
        try {
            ResultSet rs = XJdbc.query(sql, args);
            while (rs.next()) {
                CustomerRevenue cr = new CustomerRevenue();
                cr.setCustomerName(rs.getString(1));
                cr.setPhoneNumber(rs.getString(2));
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
