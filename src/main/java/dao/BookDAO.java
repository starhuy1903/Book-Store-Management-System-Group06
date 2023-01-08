/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.XJdbc;

/**
 *
 * @author Huy
 */
public class BookDAO extends SystemDAO {

    private static final String TABLE_BOOK = "book";

    private static final String COLUMN_ID = "id";
    private static final String COLUMN_TITLE = "title";
    private static final String COLUMN_STATUS = "status";
    private static final String COLUMN_PUBLISHER = "publisher_id";

    @Override
    public void create(Object entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Object entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void updateStatusWithCondition(String status, String conditionColumn, String condition) {
        String sql = "UPDATE " + TABLE_BOOK + " SET " + COLUMN_STATUS + " = ? WHERE " + conditionColumn + " = ?";
        XJdbc.update(sql, status, condition);
    }

    @Override
    public void delete(Object id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List getAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Object getById(Object id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    protected List getBySql(String sql, Object... args) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public int countByColumn(String collumn, String value) {
        String sql = "SELECT COUNT(id) AS count FROM " + TABLE_BOOK + " WHERE " + collumn + " = ?";
        try {
            ResultSet rs = XJdbc.query(sql, value);
            while(rs.next()) {
                return rs.getInt("count");
            }
            return 0;
        } catch (SQLException ex) {
            Logger.getLogger(BookDAO.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
    }
}
