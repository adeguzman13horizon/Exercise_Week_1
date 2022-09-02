package com.revature.data;
import com.revature.entity.Employee;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import java.util.*;
import java.sql.*;

public class EmployeeDaoImpl implements EmployeeDao {

    Connection connection;

    public EmployeeDaoImpl() {
        connection = ConnectionFactory.getConnection();
    }
    @Override
    public Employee insert(Employee employee) {
        System.out.println(employee.toString());
        System.out.println("Passing in employee object to the database");

        String sql = "insert into employee values(default, ?, ?, ?, ?, ?, ?, ?, default);";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, employee.getFirstName());
            preparedStatement.setString(2, employee.getLastName());
            preparedStatement.setString(3, employee.getEmail());
            preparedStatement.setString(4, employee.getUsername());
            preparedStatement.setString(5, employee.getPassword());
            preparedStatement.setString(6, employee.getAddress());
            preparedStatement.setInt(7, employee.getPhoneNumber());
            //preparedStatement.setString(8, employee.getPosition());


            System.out.println(preparedStatement.toString());

            int count = preparedStatement.executeUpdate();
            if (count == 1) {
                System.out.println("Employee added to database");
                ResultSet resultSet = preparedStatement.getGeneratedKeys();
                resultSet.next();
                int generatedId = resultSet.getInt(1);
                employee.setAccountId(generatedId);
            } else {
                System.out.println("Something went wrong with insert");
            }
        } catch (SQLException e){
            e.printStackTrace();
            System.out.println("Something went wrong when preparing statement");
        }
        return employee;
    }
    @Override
    public Employee getByAccountId(int accountId) {
        String sql = "select * from employee where accountId = ?;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, accountId);
            System.out.println(preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                int accountIdDb = resultSet.getInt("accountId");
                //int amount = resultSet.getInt("amount");
                //int age = resultSet.getInt("age");
                //double salary = resultSet.getDouble("salary");
                String usernameDb = resultSet.getString("username");
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");
                String firstName = resultSet.getString("firstName");
                String lastName = resultSet.getString("lastName");

                Employee employee = new Employee(accountIdDb, usernameDb, email, password, firstName, lastName);
                return employee;
            } else {
                System.out.println("Something went wrong when trying to query for employee");
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong when accessing data");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Employee getByUsername(String username) {
        String sql = "select * from employee where username = ?;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);
            System.out.println(preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                int accountIdDb = resultSet.getInt("accountId");
                //int amount = resultSet.getInt("amount");
                //int age = resultSet.getInt("age");
                //double salary = resultSet.getDouble("salary");
                String usernameDb = resultSet.getString("username");
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");
                String firstName = resultSet.getString("firstName");
                String lastName = resultSet.getString("lastName");

                Employee employee = new Employee(accountIdDb, usernameDb, email, password, firstName, lastName);
                return employee;
            } else {
                System.out.println("Something went wrong when trying to query for employee");
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong when accessing data");
            e.printStackTrace();
        }
        return null;
    }

    //This is to check username if already exist
    public boolean checkUsername(String username) {
        String sql = "select * from employee where username = ?;";
        boolean registeredUsername = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                    registeredUsername = true;
                    //System.err.println("This username was already registered :(");
            } else {
                System.out.println("This username can is available for use!");
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong when accessing username");
            e.printStackTrace();
        }
        return registeredUsername;
    }

    //login method
    public boolean loginEmployee(Employee employee) {
        String sql = "select * from employee where username = ? and password = ?;";
        boolean loginPass = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, employee.getUsername());
            preparedStatement.setString(2, employee.getPassword());
            System.out.println(preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();
            loginPass = resultSet.next();
        } catch (SQLException e) {
            System.out.println("Something went wrong while logging in");
            e.printStackTrace();
        }
        return loginPass;
    }

    //This is where we collect all employees recorded and
    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        String sql = "select * from employee;";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                int accountId = resultSet.getInt("accountId");
                String firstName = resultSet.getString("firstName");
                String lastName = resultSet.getString("lastName");
                String email = resultSet.getString("email");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                String address = resultSet.getString("address");
                int phoneNumber = resultSet.getInt("phoneNumber");

                Employee employee = new Employee(accountId, firstName, lastName, email, username, password, address, phoneNumber);
                employees.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }

    public Employee update(Employee employee) {
        String sql = "update employee set username = ?, email = ?, password = ?, firstName = ?, lastName = ?, where accountId = ?;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            //preparedStatement.setInt(1, employee.getAmount());
          //  preparedStatement.setInt(1, employee.getAge());
          //  preparedStatement.setDouble(2, employee.getSalary());
            preparedStatement.setString(1, employee.getUsername());
            preparedStatement.setString(2, employee.getEmail());
            preparedStatement.setString(3, employee.getPassword());
            preparedStatement.setString(4, employee.getFirstName());
            preparedStatement.setString(5, employee.getLastName());
            preparedStatement.setInt(6, employee.getAccountId());

            int count = preparedStatement.executeUpdate();
            if (count == 1) {
                System.out.println("Update successful!");
                return employee;
            } else {
                System.out.println("Unexpected event occurred with update");
                if (count == 0) {
                    System.out.println("Rows unaffected");
                } else {
                    System.out.println("Many rows were affected");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean delete(int accountId) {
        String sql = "delete from employee where accountId = ?;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, accountId);

            int count = preparedStatement.executeUpdate();
            if(count == 1) {
                System.out.println("Deletion successful!");
                return true;
            }
            else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
        //insert method #2 that passes in a String value for use with a servlet
    public Employee insert(String username) {
        Employee employee = new Employee(username);
        System.out.println(employee.toString());
        System.out.println("Passing in employee object to the database");

        String sql = "insert into employee values(default, ?, ?, ?, ?, ?, ?, ?, default);";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, employee.getFirstName());
            preparedStatement.setString(2, employee.getLastName());
            preparedStatement.setString(3, employee.getEmail());
            preparedStatement.setString(4, employee.getUsername());
            preparedStatement.setString(5, employee.getPassword());
            preparedStatement.setString(6, employee.getAddress());
            preparedStatement.setInt(7, employee.getPhoneNumber());
            //preparedStatement.setString(8, employee.getPosition());


            System.out.println(preparedStatement.toString());

            int count = preparedStatement.executeUpdate();
            if (count == 1) {
                System.out.println("Employee added to database");
                ResultSet resultSet = preparedStatement.getGeneratedKeys();
                resultSet.next();
                int generatedId = resultSet.getInt(1);
                employee.setAccountId(generatedId);
            } else {
                System.out.println("Something went wrong with insert");
            }
        } catch (SQLException e){
            e.printStackTrace();
            System.out.println("Something went wrong when preparing statement");
        }
        return employee;
    }




    }


