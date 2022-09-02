package com.revature.data;
import com.revature.entity.Employee;
import com.revature.entity.Manager;
import com.revature.entity.RTickets;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import java.util.*;
import java.sql.*;

public class ManagerDaoImpl implements ManagerDao {
    Connection connection;

    public ManagerDaoImpl() {
        connection = ConnectionFactory.getConnection();
    }

    @Override
    public Manager insert(Manager manager) {
        System.out.println(manager.toString());
        System.out.println("Passing in manager object to the database");

        String sql = "insert into manager values(default, ?, ?, ?, ?, ?, ?, ?, default);";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, manager.getFirstName());
            preparedStatement.setString(2, manager.getLastName());
            preparedStatement.setString(3, manager.getEmail());
            preparedStatement.setString(4, manager.getUsername());
            preparedStatement.setString(5, manager.getPassword());
            preparedStatement.setString(6, manager.getAddress());
            preparedStatement.setInt(7, manager.getPhoneNumber());
            //preparedStatement.setString(8, employee.getPosition());

            System.out.println(preparedStatement.toString());

            int count = preparedStatement.executeUpdate();
            if (count == 1) {
                System.out.println("Manager added to database");
                ResultSet resultSet = preparedStatement.getGeneratedKeys();
                resultSet.next();
                int generatedId = resultSet.getInt(1);
                manager.setAccountId(generatedId);
            } else {
                System.out.println("Something went wrong with insert");
            }
        } catch (SQLException e){
            e.printStackTrace();
            System.out.println("Something went wrong when preparing statement");
        }
        return manager;
    }
    @Override
    public Manager getByAccountId(int accountId) {
        String sql = "select * from manager where accountId = ?;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, accountId);
            System.out.println(preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                int accountIdDb = resultSet.getInt("accountId");
                String usernameDb = resultSet.getString("username");
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");
                String firstName = resultSet.getString("firstName");
                String lastName = resultSet.getString("lastName");

                Manager manager = new Manager(accountIdDb, usernameDb, email, password, firstName, lastName);
                return manager;
            } else {
                System.out.println("Something went wrong when trying to query for manager");
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong when accessing data");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Manager getByUsername(String username) {
        String sql = "select * from manager where username = ?;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);
            System.out.println(preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                int accountIdDb = resultSet.getInt("accountId");
                String usernameDb = resultSet.getString("username");
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");
                String firstName = resultSet.getString("firstName");
                String lastName = resultSet.getString("lastName");

                Manager manager = new Manager(accountIdDb, usernameDb, email, password, firstName, lastName);
                return manager;
            } else {
                System.out.println("Something went wrong when trying to query for manager");
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong when accessing data");
            e.printStackTrace();
        }
        return null;
    }

    //This is to check username if already exist
    public boolean checkUsername(String username) {
        String sql = "select * from manager where username = ?;";
        boolean registeredUsername = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                registeredUsername = true;
                //System.err.println("This username was already registered :(");
            } else {
                System.out.println("This username is available for use!");
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong when accessing username");
            e.printStackTrace();
        }
        return registeredUsername;
    }

    //login method
    public boolean loginManager(Manager manager) {
        String sql = "select * from manager where username = ? and password = ?;";
        boolean loginPass = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, manager.getUsername());
            preparedStatement.setString(2, manager.getPassword());
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
    public List<Manager> getAllManagers() {
        List<Manager> managers = new ArrayList<>();
        String sql = "select * from manager;";
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

                Manager manager = new Manager(accountId, firstName, lastName, email, username, password, address, phoneNumber);
                managers.add(manager);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return managers;
    }

    public Manager update(Manager manager) {
        String sql = "update manager set age = ?, salary = ?, username = ?, email = ?, password = ?, firstName = ?, lastName = ?, where accountId = ?;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            //preparedStatement.setInt(1, employee.getAmount());
            preparedStatement.setInt(1, manager.getAge());
            preparedStatement.setDouble(2, manager.getSalary());
            preparedStatement.setString(3, manager.getUsername());
            preparedStatement.setString(4, manager.getEmail());
            preparedStatement.setString(5, manager.getPassword());
            preparedStatement.setString(6, manager.getFirstName());
            preparedStatement.setString(7, manager.getLastName());
            preparedStatement.setInt(8, manager.getAccountId());

            int count = preparedStatement.executeUpdate();
            if (count == 1) {
                System.out.println("Update successful!");
                return manager;
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
        String sql = "delete from manager where accountId = ?;";
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






}
