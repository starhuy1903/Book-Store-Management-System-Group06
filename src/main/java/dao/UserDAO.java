/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;


import entity.User;
import util.XJdbc;
import java.sql.*;
import java.util.*;

/**
 *
 * @author Dai Hai
 */
public class UserDAO extends SystemDAO<User, Long>{
    private static final String TABLE_USER = "user";
    
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_USERNAME = "username";
    private static final String COLUMN_PASSWORD = "password_identity";
    private static final String COLUMN_AUTHORITY = "authority";

    @Override
    public void create(User user) {
        String sql = "INSERT INTO " + TABLE_USER + " (" + COLUMN_ID + ", " + COLUMN_USERNAME + ", " + COLUMN_PASSWORD + ", " + COLUMN_AUTHORITY + ") VALUES (?, ?, ?, ?)";
        XJdbc.update(sql, user.getId(), user.getUsername(),user.getPassword(), user.getAuthority());
    }

    @Override
    public void update(User user) {
        String sql = "UPDATE " + TABLE_USER + " SET " + COLUMN_USERNAME + "=?, " + COLUMN_PASSWORD + "=? WHERE " + COLUMN_ID + "=?";
        XJdbc.update(sql, user.getUsername(),user.getPassword(), user.getId());
    }

    @Override
    public void delete(Long id) {
        String sql = "DELETE FROM " + TABLE_USER + " WHERE " + COLUMN_ID + " = ?";
        XJdbc.update(sql, id);
    }

    @Override
    public List<User> getAll() {
        String sql = "SELECT * FROM " + TABLE_USER;
            return this.getBySql(sql);
    }

    @Override
    public User getById(Long id) {
        String sql = "SELECT * FROM " + TABLE_USER + " WHERE " + COLUMN_ID + " = ?";
        List<User> list = this.getBySql(sql, id);
        return !list.isEmpty() ? list.get(0) : null;
    }
    
    public User getByUsernameAndPassword(String userName, String pass) {
        String sql = "SELECT * FROM " + TABLE_USER + " WHERE " + COLUMN_USERNAME + " = ? AND " + COLUMN_PASSWORD + " = ?";
        List<User> list = this.getBySql(sql, userName,pass);
        System.out.println("list= "+list.get(1));
        return !list.isEmpty() ? list.get(1) : null;
    }

    @Override
    protected List<User> getBySql(String sql, Object... args) {
        List<User> list = new ArrayList<>();
        try {
            ResultSet rs = XJdbc.query(sql, args);
            while (rs.next()) {
                User entity = new User();
                entity.setId(rs.getLong(COLUMN_ID));
                entity.setUsername(rs.getString(COLUMN_USERNAME));
                entity.setPassword(rs.getString(COLUMN_PASSWORD));
                entity.setAuthority(rs.getString(COLUMN_AUTHORITY));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
