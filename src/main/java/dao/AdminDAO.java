/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import util.XJdbc;
import java.sql.*;
import java.util.*;
import entity.*;
/**
 *
 * @author Dai Hai
 */
public class AdminDAO {
    private static final String TABLE_ADMIN = "admin";
    
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_DOB = "date_of_birth";
    private static final String COLUMN_USERID = "user_id";
    
    public Admin getAll() {
        String sql = "SELECT * FROM " + TABLE_ADMIN;
            return this.getBySql(sql);
    }
    
    
    public void update(Admin admin) {
        String sql = "UPDATE " + TABLE_ADMIN + " SET " + COLUMN_NAME + "=?" + COLUMN_DOB + "=?, "+ COLUMN_USERID + "=?";
        XJdbc.update(sql, admin.getName(),admin.getDate_of_birth(), admin.getUser_id());
    }
    
    Admin getBySql(String sql, Object... args) {
        
        Admin admin=new Admin();
        try {
            ResultSet rs = XJdbc.query(sql, args);
            while (rs.next()) {
                Admin entity = new Admin();
                entity.setId(rs.getLong(COLUMN_ID));
                entity.setName(rs.getString(COLUMN_NAME));
                entity.setDate_of_birth(rs.getDate(COLUMN_DOB));
                //entity.setAuthority(UserRole.valueOf(rs.getString(COLUMN_AUTHORITY)));
                entity.setUser_id(rs.getLong(COLUMN_USERID));
                admin=entity;
            }
            rs.getStatement().getConnection().close();
            return admin;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
      
    }
}
