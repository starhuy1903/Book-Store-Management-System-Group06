/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Account;
import enumeration.ActiveStatus;
import enumeration.Role;
import util.XJdbc;
import java.sql.*;
import java.util.*;

/**
 *
 * @author Dai Hai
 */
public class AccountDAO extends SystemDAO<Account, Long> {

    private static final String TABLE_USER = "account";

    private static final String COLUMN_ID = "id";
    private static final String COLUMN_USERNAME = "username";
    private static final String COLUMN_PASSWORD = "password";
    private static final String COLUMN_ROLE = "role";
    private static final String COLUMN_IS_ACTIVE = "is_active";

    @Override
    public void create(Account acc) {
        String sql = "INSERT INTO " + TABLE_USER + " (" + COLUMN_USERNAME + ", " + COLUMN_PASSWORD + ", " + COLUMN_ROLE + ", " + COLUMN_IS_ACTIVE + ") VALUES (?, ?, ?, ?)";         
        XJdbc.update(sql, acc.getUsername(), acc.getPassword(), acc.getRole().name(), acc.getIsActive().name());
    }

    @Override
    public void update(Account acc) {
        String sql = "UPDATE " + TABLE_USER + " SET " + COLUMN_PASSWORD + "=?, " + COLUMN_ROLE + "=?, " + COLUMN_IS_ACTIVE + "=? WHERE " + COLUMN_USERNAME + "=?";
        XJdbc.update(sql,acc.getPassword(), acc.getRole().name(), acc.getIsActive().name(), acc.getUsername());
    }

    @Override
    public void delete(Long id) {
        String sql = "DELETE FROM " + TABLE_USER + " WHERE " + COLUMN_ID + " = ?";
        XJdbc.update(sql, id);
    }
    
    public void deleteByUsername(String username) {
        String sql = "DELETE FROM " + TABLE_USER + " WHERE " + COLUMN_USERNAME + " = ?";
        XJdbc.update(sql, username);
    }

    @Override
    public List<Account> getAll() {
        String sql = "SELECT * FROM " + TABLE_USER;
        return this.getBySql(sql);
    }

    @Override
    public Account getById(Long id) {
        String sql = "SELECT * FROM " + TABLE_USER + " WHERE " + COLUMN_ID + " = ?";
        List<Account> list = this.getBySql(sql, id);
        return !list.isEmpty() ? list.get(0) : null;
    }

    public Account getByUsername(String username) {
        String sql = "SELECT * FROM " + TABLE_USER + " WHERE " + COLUMN_USERNAME + " = ?";
        List<Account> list = this.getBySql(sql, username);
        return !list.isEmpty() ? list.get(0) : null;
    }

    @Override
    protected List<Account> getBySql(String sql, Object... args) {
        List<Account> list = new ArrayList<>();
        try {
            ResultSet rs = XJdbc.query(sql, args);
            while (rs.next()) {
                Account entity = new Account();
                entity.setId(rs.getLong(COLUMN_ID));
                entity.setUsername(rs.getString(COLUMN_USERNAME));
                entity.setPassword(rs.getString(COLUMN_PASSWORD));
                entity.setRole(Role.valueOf(rs.getString(COLUMN_ROLE)));
                entity.setIsActive(ActiveStatus.valueOf(rs.getString(COLUMN_IS_ACTIVE)));
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
