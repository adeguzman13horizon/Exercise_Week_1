package com.revature.controller;
import com.revature.entity.Employee;

import java.util.*;
public class RegisterAccount extends Employee {
    private String employeeRole;
    private String address;
    private String birthday;
    private int contactNumber;

    Scanner sc = new Scanner(System.in);

    //constructors
    public RegisterAccount(String employeeRole, String address, String birthday, int contactNumber) {
        //super(accountId, amount, age, username, email, password, firstName, lastName);
        this.employeeRole = employeeRole;
        this.address = address;
        this.birthday = birthday;
        this.contactNumber = contactNumber;
    }

    public RegisterAccount() {
    }


    //getters setters
    public String getEmployeeRole() {
        return employeeRole;
    }

    public void setEmployeeRole(String employeeRole) {
        this.employeeRole = employeeRole;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public int getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(int contactNumber) {
        this.contactNumber = contactNumber;
    }


    //methods
    /*public void registerUserAccountInfo() {
        Map<String, String> persons = new HashMap<>();
        System.out.println("Register your account here\nEnter your first name: ");
        String in1 = sc.next();
        System.out.println("Enter your last name: ");
        String in2 = sc.next();
        System.out.println("Create a username: ");
        String in3 = sc.next();
        System.out.println("Create a password: ");
        String in4 = sc.next();
        System.out.println("Enter your home address: ");
        String in5 = sc.next();
        System.out.println("Finally, your mobile number: ");
        int in6 = sc.nextInt();
        persons.put(in3, in4);
        //System.out.println(persons);

        //setUsername(in3);
        //setPassword(in4);
    }
    */





}
