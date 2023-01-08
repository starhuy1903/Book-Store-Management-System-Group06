/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import util.XJdbc;
import java.sql.*;
import entity.*;
import enumeration.ActiveStatus;
import enumeration.Role;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dai Hai
 */
public class AdminDAO extends SystemDAO<Admin, Long> {

    private static final String TABLE_ADMIN = "admin";

    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_DOB = "date_of_birth";
    private static final String COLUMN_USERID = "user_id";
    
    
    @Override
    public void create(Admin entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Admin> getAll() {
        String sql = "SELECT * FROM " + TABLE_ADMIN + " JOIN account ON admin.user_id=account.id";
        return this.getBySql(sql);
    }

    @Override
    public Admin getById(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Admin admin) {
        String sql = "UPDATE " + TABLE_ADMIN + " SET " + COLUMN_NAME + "=?, " + COLUMN_DOB + "=?";
        XJdbc.update(sql, admin.getName(), admin.getDateOfBirth());
    }

    @Override
    protected List<Admin> getBySql(String sql, Object... args) {

        List<Admin> list = new ArrayList<>();
        try {
            ResultSet rs = XJdbc.query(sql, args);
            while (rs.next()) {
                Admin entity = new Admin();
                entity.setId(rs.getLong(COLUMN_ID));
                entity.setName(rs.getString(COLUMN_NAME));
                entity.setDateOfBirth(rs.getDate(COLUMN_DOB));

                String username = rs.getString("username");
                String password = rs.getString("password");
                Role role = Role.valueOf(rs.getString("role"));
                ActiveStatus isActive = ActiveStatus.valueOf(rs.getString("is_active"));
                Account acc = new Account(username, password, role, isActive);

                entity.setAccount(acc);
                list.add(entity);
            }
            rs.getStatement().close();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
