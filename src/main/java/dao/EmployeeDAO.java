/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import util.XJdbc;
import java.sql.*;
import entity.*;

/**
 *
 * @author Dai Hai
 */
public class EmployeeDAO {
    private static final String TABLE_EMPLOYEE = "employee";
    
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_DOB = "date_of_birth";
    private static final String COLUMN_BANK = "bank_account";
    private static final String COLUMN_ACTIVE = "is_activate_account";
    private static final String COLUMN_USERID = "user_id";
    
    public Employee getEmployee(Long id) {
        String sql = "SELECT * FROM " + TABLE_EMPLOYEE + " WHERE " + COLUMN_USERID + " = ?";
        
        Employee employee = this.getBySql(sql, id);
        return employee;
    }
    
    public void update(Employee employee) throws SQLException {
        
        String sql = "UPDATE " + TABLE_EMPLOYEE + " SET " + COLUMN_NAME + "=?, " + COLUMN_DOB + "=?, " + COLUMN_BANK + "=?, " + COLUMN_ACTIVE + "=?, " + COLUMN_USERID + "=?"
                 + " WHERE " + COLUMN_ID + " = ?";
        XJdbc.update(sql, employee.getName(),employee.getDateOfBirth(), employee.getBankAccount(), employee.isActivateAccount(), employee.getUserId(), 
                employee.getId());
    }
    
    Employee getBySql(String sql, Object... args) {
        
        Employee employee=new Employee();
        try {
            ResultSet rs = XJdbc.query(sql, args);
            while (rs.next()) {
                Employee entity = new Employee();
                entity.setId(rs.getLong(COLUMN_ID));
                entity.setName(rs.getString(COLUMN_NAME));
                entity.setDateOfBirth(rs.getDate(COLUMN_DOB));
                entity.setBankAccount(rs.getString(COLUMN_BANK));
                entity.setIsActivateAccount(rs.getBoolean(COLUMN_ACTIVE));
                entity.setUserId(rs.getLong(COLUMN_USERID));
                employee=entity;
            }
            rs.getStatement().getConnection().close();
            return employee;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
      
    }
}
