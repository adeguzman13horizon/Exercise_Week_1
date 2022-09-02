
package com.revature.controller;
import com.revature.entity.Manager;
import com.revature.entity.RTickets;
import com.revature.service.ManagerService;
import com.revature.service.RTicketsService;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.*;

    public class ManagerCommandLineInterface {

        public static void printOptions() {

            System.out.println("Manager Menu\n" +
                    "Please select from below:\n" +
                    "1. Register as Manager\n" +
                    "2. Check username if already registered\n" +
                    "3. Login as Manager\n" +
                    "4. Get All managers\n" +
                    "5. Update manager\n" +
                    "6. Delete an manager\n" +
                    "7. Check username if already registered\n" +
                    "8. Process employee tickets\n");

        }

        public static void menu() {
            ManagerService managerService = new ManagerService();
            RTicketsService rTicketsService = new RTicketsService();

            Manager manager = null;
            Scanner intScanner = new Scanner(System.in);
            Scanner stringScanner = new Scanner(System.in);

            while (true) {
                printOptions();

                int choice = intScanner.nextInt();
                switch (choice) {
                    case 1:
                        System.out.println("Register your manager account here\nEnter your first name: ");
                        String firstName = stringScanner.next();
                        System.out.println("Enter your last name: ");
                        String lastName = stringScanner.next();
                        System.out.println("Enter your email: ");
                        String email = stringScanner.next();

                        System.out.println("Please create a username: ");
                        String username = stringScanner.next();
                        if (managerService.checkUsername(username)) {
                            System.err.println("This username has already been registered in our system\nRegister again with an unused username, sorry");
                            continue;
                        }
                        System.out.println("Please create a memorable password: ");
                        String password = stringScanner.next();
                        System.out.println("Enter your home address: ");
                        String address = stringScanner.next();
                        System.out.println("Enter your mobile number: ");
                        int phoneNumber = intScanner.nextInt();
                        System.out.println("You are a registered manager!");
                        //String position = stringScanner.next();

                        Manager newManager = new Manager(firstName, lastName, email, username, password, address, phoneNumber);
                        System.out.println(managerService.insert(newManager));
                        break;
                    case 2:
                        //This WORKED
                        System.out.print("Check Username if it exists: ");
                        String userTry = stringScanner.next();
                        System.out.println(managerService.checkUsername(userTry));
                        break;
                    case 3:
                        System.out.println("Please login to your manager account\nEnter username: ");
                        String userEmp = stringScanner.next();
                        System.out.println("Enter password: ");
                        String passEmp = stringScanner.next();
                        Manager newManager3 = new Manager(userEmp, passEmp);
                        System.out.println(managerService.loginManager(newManager3));
                        if (managerService.loginManager(newManager3)) {
                            System.err.println("Verified credentials success!");
                            boolean inside = true;
                            while (inside) {
                                System.out.println("GlAD TO HAVE YOU BACK. SELECT BELOW!\n" +
                                        "1. Get ticket ID\n" +
                                        "2. View ticket submissions by filtering the status\n" +
                                        "3. EXIT");
                                int insideChoose = intScanner.nextInt();
                                switch (insideChoose) {
                                    case 1:
                                        System.out.print("Enter ticket id: ");
                                        int ticketId = intScanner.nextInt();
                                        System.out.println(rTicketsService.getTicketId(ticketId));
                                        break;
                                    case 2:
                                        System.out.println("coming soon");
                                        break;
                                    case 3:
                                        inside = false;
                                       break;
                                    default:
                                        System.out.println("not available");
                                }
                            }
                        } else {
                            System.out.println("LOGIN INCORRECT");
                        }
                    case 4:
                        List<RTickets> ticketenter = rTicketsService.getAllTickets();
                        for (int e = 0; e < ticketenter.size(); e++) {
                            System.out.println(ticketenter.get(e));
                        }
                        break;
                    case 6:
                        if (manager == null) {
                            System.out.println("You must be logged in to submit a ticket!");
                            break;
                        }
                        System.out.println("Your recent ticket submissions:");
                        for (RTickets rTicketsSend : rTicketsService.getAllTickets()) {
                            System.out.println(rTicketsSend.toString());
                        }
                        // if we've made it here, that means we are logged in and have a username:
                        System.out.print("Enter the id of the ticket you would like:");
                        int ticketIdAssign = intScanner.nextInt();
                        boolean success = rTicketsService.assignTicket(manager.getAccountId(), ticketIdAssign);
                        if (success) {
                            System.out.println("Ticket assign successful!");
                        } else {
                            System.out.println("Something went wrong with the ticket to employee assignment.");
                        }
                        break;
                    case 10:
                        boolean statusLoop = true;
                        while(statusLoop) {
                            System.out.println("Process Employee Tickets ");
                            System.out.println("Set ticket status by selecting the following:\nApproved\nDenied\nPending\nIf you would like to exit, enter:\nexit");

                            String status = stringScanner.nextLine();
                            if (status.equalsIgnoreCase("Approved") || status.equalsIgnoreCase("Denied") || status.equalsIgnoreCase("Pending")) {
                                System.out.println("Enter the ticket ID you want to change: ");
                                int ticketId = intScanner.nextInt();
                                rTicketsService.updateStatus(ticketId, status);

                                System.out.print("Enter same ticket ID again to see changed status: ");
                                int ticketIdFind = intScanner.nextInt();
                                System.out.println(rTicketsService.getTicketId(ticketIdFind));
                                System.out.println("Would you like to see all ticket submissions?\nyes\nno");
                                String decide1 = stringScanner.next();
                                if(decide1.equalsIgnoreCase("yes")){
                                    List<RTickets> ticketIter = rTicketsService.getAllTickets();
                                    for (int t = 0; t < ticketIter.size(); t++) {
                                        System.out.println(ticketIter.get(t));
                                    }
                                } else {
                                    System.out.println("Would like to return to the main manager menu?\nyes");
                                    String decide2 = stringScanner.next();
                                    if(decide2.equalsIgnoreCase("yes")) {
                                        continue;
                                    } else {
                                        System.out.println("Please only enter the given choice(s)");
                                    }
                                }
                            }
                            statusLoop = false;
                        }
                        break;
                    default:
                        System.out.println("Not a valid option");
                        break;


                }

            }
        }


    }



