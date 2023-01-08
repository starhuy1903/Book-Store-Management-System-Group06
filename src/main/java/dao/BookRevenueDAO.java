/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.BookRevenue;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.XJdbc;

/**
 *
 * @author huynguyen
 */
public class BookRevenueDAO {
    
    public List<BookRevenue> getAll() {
        String sql = "SELECT book.title, sum(line_item.quantity) AS quantity, sum(book_store_g6.order.actual_total) as total_price FROM line_item JOIN book_store_g6.order ON (line_item.order_id = book_store_g6.order.id) JOIN book ON (line_item.book_id = book.ID) GROUP BY book.title";
        return this.getBySql(sql);
    }
    
    private List<BookRevenue> getBySql(String sql, Object... args) {
        List<BookRevenue> list = new ArrayList<>();
        try {
            ResultSet rs = XJdbc.query(sql, args);
            while (rs.next()) {
                BookRevenue br = new BookRevenue();
                br.setTitle(rs.getString(1));
                br.setQuantity(rs.getInt(2));
                br.setTotalPrice(rs.getInt(3));              

                list.add(br);
            }
            rs.getStatement().close();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
