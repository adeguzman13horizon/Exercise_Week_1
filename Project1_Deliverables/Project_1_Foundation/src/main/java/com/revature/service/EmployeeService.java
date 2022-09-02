package com.revature.service;

import com.revature.data.DaoFactory;
import com.revature.data.EmployeeDao;
import com.revature.data.ManagerDao;
import com.revature.entity.Employee;
import com.revature.entity.Manager;

import java.util.*;

public class EmployeeService {

    public Employee insert(Employee employee) {
        System.out.println("In the service layer, getting the DAO and calling the insert DAO method");
        EmployeeDao employeeDao = DaoFactory.getEmployeeDao();
        return employeeDao.insert(employee);

    }

    public Employee getByAccountId(int accountId) {
        EmployeeDao employeeDao = DaoFactory.getEmployeeDao();
        return employeeDao.getByAccountId(accountId);
    }

    public Employee getByUsername(String username) {
        EmployeeDao employeeDao = DaoFactory.getEmployeeDao();
        return employeeDao.getByUsername(username);
    }

    //this one is a test
    public boolean checkUsername(String username) {
        EmployeeDao employeeDao = DaoFactory.getEmployeeDao();
        return employeeDao.checkUsername(username);
    }

    public boolean loginEmployee(Employee employee) {
        EmployeeDao employeeDao = DaoFactory.getEmployeeDao();
        return employeeDao.loginEmployee(employee);
    }

    public List<Employee> getAllEmployees() {
        EmployeeDao employeeDao = DaoFactory.getEmployeeDao();
        return employeeDao.getAllEmployees();
    }

    public Employee updateEmployee(Employee employee) {
        EmployeeDao employeeDao = DaoFactory.getEmployeeDao();
        return employeeDao.update(employee);
    }

    public boolean deleteEmployee(int accountId) {
        EmployeeDao employeeDao = DaoFactory.getEmployeeDao();
        return employeeDao.delete(accountId);
    }



    public Employee register(Employee employee) {
        EmployeeDao employeeDao = DaoFactory.getEmployeeDao();
        Employee employee1 = employeeDao.insert(employee);
        return employee1;
    }

    public Employee login(String username, String password) {
        // business logic where we check the password:
        EmployeeDao employeeDao = DaoFactory.getEmployeeDao();
        Employee employee = employeeDao.getByUsername(username);
        if (password.equals(employee.getPassword())) {
            return employee;
        }
        return null;
    }

    public Employee login2(int accountId, String password) {
        // business logic where we check the password:
        EmployeeDao employeeDao = DaoFactory.getEmployeeDao();
        Employee employee = employeeDao.getByAccountId(accountId);
        if (password.equals(employee.getPassword())) {
            return employee;
        }
        return null;
    }








}
