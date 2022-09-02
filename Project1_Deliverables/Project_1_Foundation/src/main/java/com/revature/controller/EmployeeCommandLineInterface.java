package com.revature.controller;

import com.revature.entity.Employee;
import com.revature.entity.RTickets;
import com.revature.service.EmployeeService;
import com.revature.service.RTicketsService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeCommandLineInterface {

    public static void printOptions() {

        System.out.println("Welcome to the Employee Reimbursement Expense System!\n" +
                "Please select from the menu:\n" +
                "1. Register Your Account\n" +
                "2 Get employee by id\n" +
                "3 Get All employees\n" +
                "4. Update employee\n" +
                "5. Delete an employee\n" +
                "6. Check username if already registered\n" +
                "7. Login via username\n" +
                "8. Submit employee reimbursement ticket\n" +
                "9. Get Ticket by ID\n" +
                "10. Get All Tickets\n" +
                "11. Update reimbursement ticket\n" +
                "12. Login via username\n" +
                "13. Get employee by username\n" +
                "14. Assign employee a ticket\n" +
                "15. Get All Submitted Tickets\n" +
                "16. Register as Manager\n" +
                "17. Login as Manager");

    }

    public static void menu() {
        EmployeeService employeeService = new EmployeeService();
        RTicketsService rTicketsService = new RTicketsService();

        Employee employee = null;
        Scanner intScanner = new Scanner(System.in);
        Scanner stringScanner = new Scanner(System.in);

        while (true) {
           printOptions();

            int choice = intScanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Register your employee account here\nEnter your first name: ");
                    String firstName = stringScanner.next();
                    System.out.println("Enter your last name: ");
                    String lastName = stringScanner.next();
                    System.out.println("Enter your email: ");
                    String email = stringScanner.next();

                        System.out.println("Please create a username: ");
                        String username = stringScanner.next();
                        if(employeeService.checkUsername(username)) {
                            System.out.println("This username has already been registered in our system\nRegister again with an unused username, sorry");
                            continue;
                        }
                    System.out.println("Please create a memorable password: ");
                    String password = stringScanner.next();
                    System.out.println("Enter your home address: ");
                    String address = stringScanner.next();
                    System.out.println("Enter your mobile number: ");
                    int phoneNumber = intScanner.nextInt();
                    System.out.println("You are automatically a registered employee!");
                    //String position = stringScanner.next();

                    Employee newEmployee = new Employee(firstName, lastName, email, username, password, address, phoneNumber);
                    System.out.println(employeeService.insert(newEmployee));
                    break;
                case 2:
                    System.out.print("Enter in an account id: ");
                    int accountId2 = intScanner.nextInt();
                    System.out.println(employeeService.getByAccountId(accountId2));
                    break;
                case 3:
                    List<Employee> employees = employeeService.getAllEmployees();
                    for (int i = 0; i < employees.size(); i++) {
                        System.out.println(employees.get(i));
                    }
                    break;
                case 4:
                    System.out.println("Enter employee info");
                    System.out.print("Employee Account ID: ");
                    int accountId = intScanner.nextInt();
                   // System.out.print("Employee Reimbursement Amount: ");
                  //  int amount2 = intScanner.nextInt();
                   // System.out.print("Employee Age: ");
                   // int age2 = intScanner.nextInt();
                  //  System.out.print("Employee Salary: ");
                  //  String salary2 = stringScanner.next();
                    System.out.print("Employee Username: ");
                    String username2 = stringScanner.next();
                    System.out.print("Employee email: ");
                    String email2 = stringScanner.next();
                    System.out.print("Employee Password: ");
                    String password2 = stringScanner.next();
                    System.out.print("Employee First Name: ");
                    String firstName2 = stringScanner.next();
                    System.out.print("Employee Last Name: ");
                    String lastName2 = stringScanner.next();
                    Employee newEmployee2 = new Employee(accountId, username2, email2, password2, firstName2, lastName2);
                    System.out.println(employeeService.updateEmployee(newEmployee2));
                    break;
                case 5:
                    System.out.println("Enter in Account ID to delete");
                    System.out.print("Employee Account ID: ");
                    accountId = intScanner.nextInt();
                    if (employeeService.deleteEmployee(accountId)) {
                        System.out.println("Employee successfully deleted");
                    } else {
                        System.out.println("Something went wrong when deleting employee");
                    }
                    break;
                case 6:
                    System.out.print("Check Username if it exists: ");
                    String userTry = stringScanner.next();
                    System.out.println(employeeService.checkUsername(userTry));
                    break;
                case 7:
                    System.out.println("Please login to your employee account\nEnter username: ");
                    String userEmp = stringScanner.next();
                    System.out.println("Enter password: ");
                    String passEmp = stringScanner.next();
                    Employee newEmployee3 = new Employee(userEmp, passEmp);
                    System.out.println(employeeService.loginEmployee(newEmployee3));
                    if(employeeService.loginEmployee(newEmployee3)) {
                        System.out.println("LOGIN SUCCESSFUL!");
                        boolean inside = true;
                        while (inside) {
                            System.out.println("GlAD TO HAVE YOU BACK. SELECT BELOW!\n" +
                                    "1. Get ticket ID\n" +
                                    "2. View ticket submissions by filtering the status\n" +
                                    "3. EXIT");
                                    int insideChoose = intScanner.nextInt();
                                    switch (insideChoose) {
                                        case 1: System.out.print("Enter ticket id: ");
                                            int ticketId = intScanner.nextInt();
                                            System.out.println(rTicketsService.getTicketId(ticketId));
                                            break;
                                        case 3: inside = false;
                                            break;
                                        default:
                                            System.out.println("not available");
                                    }
                        }
                    } else {
                        System.out.println("LOGIN INCORRECT");
                    }
                    break;
                case 8:
                    System.out.println("Fill out and submit your employee reimbursement ticket here\nEnter an amount: ");
                    double amount = intScanner.nextDouble();
                    System.out.println("Enter your average salary: ");
                    double salary = intScanner.nextDouble();
                    System.out.println("Enter the date of submission: ");
                    String dateSubmitted = stringScanner.nextLine();
                    //System.out.println("Enter your current position: ");
                    //String position = stringScanner.next();
                    System.out.println("Describe the reason of your reimbursement request: ");
                    String description = stringScanner.nextLine();
                    System.out.println("Enter your full name: ");
                    String sender = stringScanner.nextLine();
                    String status = "pending";

                    RTickets rTickets = new RTickets(amount, salary, dateSubmitted, description, status, sender);
                    System.out.println(rTicketsService.submitRTicket(rTickets));
                    break;
                case 9:
                    System.out.print("Enter ticket id: ");
                    int ticketId = intScanner.nextInt();
                    System.out.println(rTicketsService.getTicketId(ticketId));
                    break;
                default:
                    System.out.println("Not a valid option.");
                    break;
                case 10:
                    List<RTickets> ticketEnter = rTicketsService.getAllTickets();
                    for (int e = 0; e < ticketEnter.size(); e++) {
                        System.out.println(ticketEnter.get(e));
                    }
                    break;
                case 11:
                    System.out.println("Update your employee reimbursement ticket here\nEnter an amount: ");
                    double amountU = intScanner.nextDouble();
                    System.out.println("Enter your average salary: ");
                    double salaryU = intScanner.nextDouble();
                    System.out.println("Enter the date of submission: ");
                    String dateSubmittedU = stringScanner.nextLine();
                    //System.out.println("Enter your current position: ");
                    //String position = stringScanner.next();
                    System.out.println("Describe the reason of your reimbursement request: ");
                    String descriptionU = stringScanner.nextLine();
                    System.out.println("Enter your full name: ");
                    String senderU = stringScanner.nextLine();
                    String statusU = "pending";
                    System.out.println("Enter ticketId to change: ");
                    int ticketIdU = intScanner.nextInt();

                    RTickets rTicketsU = new RTickets(amountU, salaryU, dateSubmittedU, descriptionU, statusU, senderU, ticketIdU);
                    System.out.println(rTicketsService.updateRTickets(rTicketsU));
                    break;
                case 12:
                    //Employee employee = null;
                    if(employee != null) {
                        System.out.println("You are already logged in!");
                        break;
                    }
                    System.out.print("Enter username => ");
                    username = stringScanner.nextLine();
                    System.out.print("Enter password => ");
                    password = stringScanner.nextLine();
                    employee = employeeService.login(username, password);
                    if(employee == null) {
                        System.err.println("Login unsuccessful!");
                    } else {
                        System.out.println("You are back " + employee.getFirstName() + employee.getLastName());
                    }
                    break;
                case 13:
                    System.out.print("Enter in a username: ");
                    String usernameTest = stringScanner.next();
                    System.out.println(employeeService.getByUsername(usernameTest));
                    break;
                case 14:
                    //employee = null;
                    if (employee == null) {
                        System.out.println("You must be logged in to submit a ticket!");
                        break;
                    }
                    System.out.println("Your recent ticket submissions:");
                    for(RTickets rTicketsSend : rTicketsService.getAllTickets()) {
                        System.out.println(rTicketsSend.toString());
                    }
                    // if we've made it here, that means we are logged in and have a username:
                    System.out.print("Enter the id of the ticket you would like:");
                    int ticketIdAssign = intScanner.nextInt();
                    boolean success = rTicketsService.assignTicket(employee.getAccountId(), ticketIdAssign);
                    if (success) {
                        System.out.println("Ticket assign successful!");
                    }
                    else {
                        System.out.println("Something went wrong with the ticket to employee assignment.");
                    }
                    break;
                case 15:
                    if (employee == null) {
                        System.out.println("Please log in first");
                        break;
                    }
                    List<RTickets> rTicketsList = rTicketsService.getSubmittedTickets(employee.getAccountId());

                    System.out.println("Here are your submitted tickets:");
                    for(RTickets rTicketsPrint : rTicketsList) {
                        System.out.println(rTicketsPrint);
                    }
                    break;
                case 16:

                    //This only a test (don't need to use this)
                    System.out.println("Submit your employee reimbursement ticket here\nEnter an amount: ");
                    double amountT = intScanner.nextDouble();
                    System.out.println("Enter your average salary: ");
                    double salaryT = intScanner.nextDouble();
                    System.out.println("Enter the date of submission: ");
                    String dateSubmittedT = stringScanner.nextLine();
                    //System.out.println("Enter your current position: ");
                    //String positionT = stringScanner.next();
                    System.out.println("Describe the reason of your reimbursement request: ");
                    String descriptionT = stringScanner.nextLine();
                    String statusT = "pending";
                    System.out.println("Enter your full name: ");
                    String senderT = stringScanner.nextLine();

                    rTickets = new RTickets(amountT, salaryT, dateSubmittedT, descriptionT, statusT, senderT);
                    System.out.println(rTicketsService.submitRTicket(rTickets));
                    break;





            }

        }
    }



    }

