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
public class EmployeeDAO extends SystemDAO<Employee, Long> {

    private static final String TABLE_EMPLOYEE = "employee";

    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_DOB = "date_of_birth";
    private static final String COLUMN_BANK = "bank_account";
    private static final String COLUMN_USERID = "user_id";

    public Employee getByUserId(Long userId) {
        String sql = "SELECT * FROM " + TABLE_EMPLOYEE + " JOIN account ON (employee.user_id=account.id)" + " WHERE " + COLUMN_USERID + " = ?";
        List<Employee> list = this.getBySql(sql, userId);
        return !list.isEmpty() ? list.get(0) : null;
    }

    @Override
    public Employee getById(Long id) {
        String sql = "SELECT * FROM " + TABLE_EMPLOYEE + " JOIN user ON (employee.user_id=account.id)" + " WHERE " + COLUMN_ID + " = ?";
        List<Employee> list = this.getBySql(sql, id);
        return !list.isEmpty() ? list.get(0) : null;
    }

    @Override
    public List<Employee> getAll() {
        String sql = "SELECT * FROM " + TABLE_EMPLOYEE + " JOIN user ON (employee.user_id=user.id)";
        return this.getBySql(sql);
    }

    @Override
    public void create(Employee employee) {
        String sql = "INSERT INTO " + TABLE_EMPLOYEE + " (" + COLUMN_NAME + ", " + COLUMN_DOB + ", " + COLUMN_BANK + ", " + COLUMN_USERID + ") VALUES (?, ?, ?, ?, ?)";
//        XJdbc.update(sql, employee.getName(), employee.getDateOfBirth(), employee.getBankAccount(), employee.isActivateAccount(), employee.getUserId());
    }

    @Override
    public void update(Employee employee) {
        String sql = "UPDATE " + TABLE_EMPLOYEE + " SET " + COLUMN_NAME + "=?, " + COLUMN_DOB + "=?, " + COLUMN_BANK + "=? WHERE " + COLUMN_ID + " = ?";
        XJdbc.update(sql, employee.getName(), employee.getDateOfBirth(), employee.getBankAccount(),
                employee.getId());
    }

    @Override
    public void delete(Long id) {
        String sql = "DELETE FROM " + TABLE_EMPLOYEE + " WHERE " + COLUMN_ID + " = ?";
        XJdbc.update(sql, id);
    }

    @Override
    protected List<Employee> getBySql(String sql, Object... args) {
        List<Employee> list = new ArrayList<>();
        try {
            ResultSet rs = XJdbc.query(sql, args);
            while (rs.next()) {

                Employee entity = new Employee();
                entity.setId(rs.getLong(COLUMN_ID));
                entity.setName(rs.getString(COLUMN_NAME));
                entity.setDateOfBirth(rs.getDate(COLUMN_DOB));
                entity.setBankAccount(rs.getString(COLUMN_BANK));

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
