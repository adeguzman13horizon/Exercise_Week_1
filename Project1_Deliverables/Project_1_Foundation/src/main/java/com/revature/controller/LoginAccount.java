package com.revature.controller;
import com.revature.entity.Employee;

import java.util.*;
public class LoginAccount extends Employee {
    private String in3;
    private String in4;
    Scanner sc = new Scanner(System.in);

    //constructors
    public LoginAccount(int accountId, int amount, int age, String username, String email, String password, String firstName, String lastName) {
        //super(accountId, amount, age, username, email, password, firstName, lastName);
        //this.sc = sc;
    }

    public LoginAccount() {
    }


    //getters setters



    //methods
    public void registerUserAccountInfo() {
        //Map<String, String> persons = new HashMap<>();
        System.out.println("Register your account here\nEnter your first name: ");
        String in1 = sc.next();
        System.out.println("Enter your last name: ");
        String in2 = sc.next();
        System.out.println("Please create a username: ");
        in3 = sc.next();
        System.out.println("Now please create a memorable password: ");
        in4 = sc.next();
        System.out.println("Enter your home address: ");
        String in5 = sc.next();
        System.out.println("Then enter your mobile number: ");
        int in6 = sc.nextInt();
        //persons.put(in3, in4);
        //System.out.println(persons);

    }


    public void enterLoginInfo() {
        boolean myBool = true;
        while (myBool) {
            System.out.println("Please login to verify: ");
            System.out.println("Username: ");
            String input3 = sc.next();
            System.out.println("Password: ");
            String input4 = sc.next();
            setUsername(in3);
            setPassword(in4);
            if (in3.equals(input3) && in4.equals(input4)) {
                System.out.println("Welcome");
                break;
            } else if (in3.equals(input3) && !in4.equals(input4)) {
                System.out.println("Password is incorrect");
            } else if (!in3.equals(input3) && in4.equals(input4)) {
                System.out.println("Username does not exist");
            } else {
                System.out.println("Sorry try again");   
            }
        }
    }

    public void validateUsername() {
        System.out.println("Please enter a username to see if it's registered with us: ");
        String validInput = sc.next();
        if (validInput.equals(in3)) {
            System.out.println("This username is already registered with us");
        } else {
            System.out.println("This username has not been taken!");
        }
    }





}
