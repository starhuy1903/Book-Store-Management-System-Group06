/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.*;
import entity.*;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dai Hai
 */
public class EmployeeController {

    public Employee getById(Long id) {
        EmployeeDAO da = new EmployeeDAO();
        return da.getById(id);
    }

    public void addEmployee(String name, Date dob, String bankAccount, Long userId) {
        EmployeeDAO employeeDAO = new EmployeeDAO();

//        Employee employee = new Employee(name, dob, bankAccount, userId);
//        employeeDAO.create(employee);
    }
    
//    public List<EmployeeAccount> 

    public void update(Employee employee) {
        EmployeeDAO dao = new EmployeeDAO();
        dao.update(employee);

    }
}
