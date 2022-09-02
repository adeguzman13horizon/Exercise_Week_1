package com.revature.data;

import com.revature.entity.RTickets;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RTicketsDaoImpl implements RTicketsDao{
    Connection connection;

    public RTicketsDaoImpl() {
        connection = ConnectionFactory.getConnection();
    }

    @Override
    public RTickets submitRTicket(RTickets rTickets) {
        System.out.println(rTickets.toString());
        System.out.println("Passing in ticket object to the database");

        //String sql = "insert into tickets values(default, ?, ?, ?, ?, ?, ?, (select accountId from employee where accountId = ?));";
        String sql = "insert into ticket values(default, ?, ?, ?, ?, ?, ?);";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setDouble(1, rTickets.getAmount());
            preparedStatement.setDouble(2, rTickets.getSalary());
            preparedStatement.setString(3, rTickets.getDateSubmitted());
            preparedStatement.setString(4, rTickets.getDescription());
            preparedStatement.setString(5, rTickets.getStatus());
            preparedStatement.setString(6, rTickets.getSender());

            //preparedStatement.setString(8, rTickets.getReviewer());

            System.out.println(preparedStatement.toString());

            int count = preparedStatement.executeUpdate();
            if (count == 1) {
                System.out.println("Reimbursement ticket added to database");
                ResultSet resultSet = preparedStatement.getGeneratedKeys();
                resultSet.next();
                int generatedId = resultSet.getInt(1);
                rTickets.setTicketId(generatedId);
            } else {
                System.out.println("Something went wrong with ticket submission");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Something went wrong when preparing statement");
        }
        return rTickets;
    }


    @Override
    public RTickets getTicketId(int ticketId) {
        String sql = "select * from ticket where ticketId = ?;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, ticketId);
            System.out.println(preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                int ticketIdDb = resultSet.getInt("ticketId");
                int amount = resultSet.getInt("amount");
                double salary = resultSet.getDouble("salary");
                String dateSubmitted = resultSet.getString("dateSubmitted");
                String description = resultSet.getString("description");
                String status = resultSet.getString("status");
                String sender = resultSet.getString("sender");
                //String reviewer = resultSet.getString("reviewer");

                RTickets rTickets = new RTickets(ticketIdDb, amount, salary, dateSubmitted, description, status, sender);
                return rTickets;
            } else {
                System.out.println("Something went wrong when trying to query for ticket");
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong when accessing data");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<RTickets> getAllTickets() {
        List<RTickets> rTickets = new ArrayList<>();
        String sql = "select * from ticket;";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                int ticketId = resultSet.getInt("ticketId");
                int amount = resultSet.getInt("amount");
                double salary = resultSet.getDouble("salary");
                String dateSubmitted = resultSet.getString("dateSubmitted");
                String description = resultSet.getString("description");
                String status = resultSet.getString("status");
                String sender = resultSet.getString("sender");
                //String reviewer = resultSet.getString("reviewer");

                RTickets rTickets2 = new RTickets(ticketId, amount, salary, dateSubmitted, description, status, sender);
                rTickets.add(rTickets2);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rTickets;
    }

    public RTickets update(RTickets rTickets) {
        String sql = "update ticket set amount = ?, salary = ?, dateSubmitted = ?, description = ?, status = ?, sender = ? where ticketId = ?;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setDouble(1, rTickets.getAmount());
            preparedStatement.setDouble(2, rTickets.getSalary());
            preparedStatement.setString(3, rTickets.getDateSubmitted());
            preparedStatement.setString(4, rTickets.getDescription());
            preparedStatement.setString(5, rTickets.getStatus());
            preparedStatement.setString(6, rTickets.getSender());
            //preparedStatement.setString(7, rTickets.getReviewer());
            preparedStatement.setInt(7, rTickets.getTicketId());

            int count = preparedStatement.executeUpdate();
            if (count == 1) {
                System.out.println("Update successful!");
                return rTickets;
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
    public boolean delete(int ticketId) {
        String sql = "delete from ticket where ticketId = ?;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, ticketId);

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

    //THIS WILL BE FOR MANAGERS WHO APPROVE OR DENY A PENDING TICKET
    @Override
    public boolean assignTicket(int accountId, int ticketId) {
        // TODO check if id is null
        String sql = "update ticket set sender = ? where ticketId = ?;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, accountId);
            preparedStatement.setInt(2, ticketId);
            int count = preparedStatement.executeUpdate();
            // if we've successfully update the table, we can return true
            if(count == 1) return true;
        } catch(SQLException e) {
            e.printStackTrace();
        }
        // for failure situations, we return false
        return false;
    }

    @Override
    public List<RTickets> getSubmittedTickets(int accountId) {
        String sql = "select * from ticket where ticketId = ?;";
        List<RTickets> rTicketsList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, accountId);
            ResultSet resultSet = preparedStatement.executeQuery();


            while(resultSet.next()) {
                // for the current row, extract the data
                int ticketIdDb = resultSet.getInt("ticketId");
                int amount = resultSet.getInt("amount");
                double salary = resultSet.getDouble("salary");
                String dateSubmitted = resultSet.getString("dateSubmitted");
                String description = resultSet.getString("description");
                String status = resultSet.getString("status");
                String sender = resultSet.getString("sender");
                RTickets rTickets = new RTickets(ticketIdDb, amount, salary, dateSubmitted, description, status, sender);

                // add the current pet to the list of pets that we're returning:
                rTicketsList.add(rTickets);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rTicketsList;
    }

    // only update a certain field/column:
    public RTickets updateStatus(int ticketId, String status) {
        String sql = "update ticket set status = ? where ticketId = ?;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, status);
            preparedStatement.setInt(2, ticketId);
            RTickets rTickets = new RTickets(ticketId, status);

            int count = preparedStatement.executeUpdate();
            if (count == 1) {
                System.out.println("Update successful!");
                return rTickets;
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

    public RTickets submitRTicket(String sender) {
       RTickets rTickets = new RTickets(sender);
        System.out.println(rTickets.toString());
        System.out.println("Passing in ticket object to the database");

        //String sql = "insert into tickets values(default, ?, ?, ?, ?, ?, ?, (select accountId from employee where accountId = ?));";
        String sql = "insert into ticket values(default, ?, ?, ?, ?, ?, ?);";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setDouble(1, rTickets.getAmount());
            preparedStatement.setDouble(2, rTickets.getSalary());
            preparedStatement.setString(3, rTickets.getDateSubmitted());
            preparedStatement.setString(4, rTickets.getDescription());
            preparedStatement.setString(5, rTickets.getStatus());
            preparedStatement.setString(6, rTickets.getSender());

            //preparedStatement.setString(8, rTickets.getReviewer());
            System.out.println(preparedStatement.toString());

            int count = preparedStatement.executeUpdate();
            if (count == 1) {
                System.out.println("Reimbursement ticket added to database");
                ResultSet resultSet = preparedStatement.getGeneratedKeys();
                resultSet.next();
                int generatedId = resultSet.getInt(1);
                rTickets.setTicketId(generatedId);
            } else {
                System.out.println("Something went wrong with ticket submission");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Something went wrong when preparing statement");
        }
        return rTickets;
    }

    public RTickets updateStatus(int ticketId, double amount, double salary, String description, String reimbursementType, String dateSubmitted, String status, String sender, String reviewer, String username) {
        String sql = "update ticket set status = ? where ticketId = ?;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, status);
            preparedStatement.setInt(2, ticketId);
            RTickets rTickets = new RTickets(ticketId, status);

            int count = preparedStatement.executeUpdate();
            if (count == 1) {
                System.out.println("Update successful!");
                return rTickets;
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
    public List<RTickets> getTicketsFromEmployee(String sender) {
        List<RTickets> rTicketsList = new ArrayList<>();
        // use store procedure:
        String sql = "select * from ticket where sender = ?;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,sender);
            System.out.println(preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                int ticketIdDb = resultSet.getInt("ticketId");
                int amount = resultSet.getInt("amount");
                double salary = resultSet.getDouble("salary");
                String dateSubmitted = resultSet.getString("dateSubmitted");
                String description = resultSet.getString("description");
                String status = resultSet.getString("status");
                String senderDb = resultSet.getString("sender");
                RTickets rTickets = new RTickets(ticketIdDb, amount, salary, dateSubmitted, description, status, senderDb);

                rTicketsList.add(rTickets);

            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return rTicketsList;
    }

    @Override
    public RTickets getTicketStatus(String status) {
        String sql = "select * from ticket where status = ?;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, status);
            System.out.println(preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                int ticketIdDb = resultSet.getInt("ticketId");
                int amount = resultSet.getInt("amount");
                double salary = resultSet.getDouble("salary");
                String dateSubmitted = resultSet.getString("dateSubmitted");
                String description = resultSet.getString("description");
                String statusDb = resultSet.getString("status");
                String sender = resultSet.getString("sender");
                //String reviewer = resultSet.getString("reviewer");

                RTickets rTickets = new RTickets(ticketIdDb, amount, salary, dateSubmitted, description, statusDb, sender);
                return rTickets;
            } else {
                System.out.println("Something went wrong when trying to query for ticket");
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong when accessing data");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<RTickets> getTicketsFilterStatus(String status, String sender) {
        List<RTickets> rTicketsList = new ArrayList<>();
        // use store procedure:
        String sql = "select * from ticket where status = ? and sender = ?;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,status);
            preparedStatement.setString(2,sender);
            System.out.println(preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                int ticketIdDb = resultSet.getInt("ticketId");
                int amount = resultSet.getInt("amount");
                double salary = resultSet.getDouble("salary");
                String dateSubmitted = resultSet.getString("dateSubmitted");
                String description = resultSet.getString("description");
                String statusDb = resultSet.getString("status");
                String senderDb = resultSet.getString("sender");
                RTickets rTickets = new RTickets(ticketIdDb, amount, salary, dateSubmitted, description, statusDb, senderDb);

                rTicketsList.add(rTickets);

            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return rTicketsList;
    }




    // THIS WILL BE FOR MAKING TICKET APPROVED, DENIED OR PENDING BY MANAGER
    // only update a certain field/column:
//    public Pet updateFood(int id, String food) {
//        String sql = "update pet set food = ? where id = ?;";
//        PreparedStatement preparedStatement = connection.prepareStatement();
//        preparedStatement.setString(food);
//        preparedStatement.setInt(2, id);
//
//    }

}
