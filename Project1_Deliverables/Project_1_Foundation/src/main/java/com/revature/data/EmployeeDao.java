package com.revature.data;

import com.revature.entity.Employee;

import java.util.*;
public interface EmployeeDao {

    public Employee insert(Employee employee);

    public Employee getByAccountId(int accountId);
    public Employee getByUsername(String username);

    public boolean checkUsername(String username);
    public boolean loginEmployee(Employee employee);

    public List<Employee> getAllEmployees();

    public Employee update(Employee employee);

    public boolean delete(int accountId);


}
