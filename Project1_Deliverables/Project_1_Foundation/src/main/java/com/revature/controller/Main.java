package com.revature.controller;
import com.revature.entity.RTickets;

import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LoginAccount l = new LoginAccount();
        //l.registerUserAccountInfo();
        //l.enterLoginInfo();
        RegisterAccount r = new RegisterAccount();

        boolean b = true;
        while (b) {
            System.out.println("Welcome to the Employee Reimbursement Expense System!\n" +
                    "Please select from the menu:\n" +
                    "1. Register Your Account\n" +
                    "2. Log in to Your Account\n" +
                    "3. Submit a Reimbursement Ticket\n" +
                    "4. View Reimbursement Ticket Status\n" +
                    "5. View Registered Accounts\n" +
                    "6. Log Out of Application");
            int selection = sc.nextInt();
            switch (selection) {
                case 1:
                    l.registerUserAccountInfo();
                    l.validateUsername();
                    break;
                case 2:
                    l.enterLoginInfo();
                    break;
                case 3:
                    //RTickets rt = new RTickets();
                   // rt.submitTicket();
                    break;
                case 4:
                    System.out.println("...this will be available soon.");
                    break;
                case 5:
                    System.out.println("Only one account was made.");
                    break;
                case 6:
                    System.out.println("You successfully logged out!");
                    b = false;
                    break;
                default:
                    System.out.println("Please select the options above only.");
            }
        }









    }
}
