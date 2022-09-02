package com.revature.entity;

import java.util.Scanner;

public class RTickets {
    private int ticketId;
    private double amount;
    private double salary;
    private String reimbursementType;
    private String dateSubmitted;
    private String description;
    private String sender;

    private String status;
    private String reviewer;
    private String username;


    Scanner sc = new Scanner(System.in);
    //constructor


    public RTickets(int ticketId, double amount, double salary, String description, String reimbursementType, String dateSubmitted, String status, String sender, String reviewer, String username) {
        this.ticketId = ticketId;
        this.amount = amount;
        this.salary = salary;
        this.description = description;
        this.reimbursementType = reimbursementType;
        this.dateSubmitted = dateSubmitted;
        this.status = status;
        this.sender = sender;
        this.reviewer = reviewer;
        this.username = username;
    }

    public RTickets(double amount, double salary, String description, String reimbursementType, String dateSubmitted, String status, String sender, String reviewer, String username) {
        this.amount = amount;
        this.salary = salary;
        this.description = description;
        this.reimbursementType = reimbursementType;
        this.dateSubmitted = dateSubmitted;
        this.status = status;
        this.sender = sender;
        this.reviewer = reviewer;
        this.username = username;
    }

    public RTickets() {

    }

    public RTickets(double amount, double salary, String dateSubmitted, String description, String status, String sender) {
        this.amount = amount;
        this.salary = salary;
        this.dateSubmitted = dateSubmitted;
        this.description = description;
        this.status = status;
        this.sender = sender;
       // this.status = status;
    }

    //GetByTicketId
    public RTickets(int ticketId, int amount, double salary, String dateSubmitted, String description, String status, String sender) {
        this.ticketId = ticketId;
        this.amount = amount;
        this.salary = salary;
        this.dateSubmitted = dateSubmitted;
        this.description = description;
        this.status = status;
        this.sender = sender;
        //this.status = status;

    }

    public RTickets(double amountU, double salaryU, String dateSubmittedU, String descriptionU, String statusU, String senderU, int ticketIdU) {
        this.amount=amountU;
        this.salary=salaryU;
        this.dateSubmitted=dateSubmittedU;
        this.description=descriptionU;
        this.status=statusU;
        this.sender=senderU;
        this.ticketId=ticketIdU;
    }

    public RTickets(int ticketId, String status) {
        this.ticketId=ticketId;
        this.status=status;
    }
    //RTicketServlet
    public RTickets(String sender) {
        this.amount = amount;
        this.salary = salary;
        this.dateSubmitted = dateSubmitted;
        this.description = description;
        this.status = status;

        this.sender=sender;
    }

    //getter/setter


    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getReimbursementType() {
        return reimbursementType;
    }

    public void setReimbursementType(String reimbursementType) {
        this.reimbursementType = reimbursementType;
    }

    public String getDateSubmitted() {
        return dateSubmitted;
    }

    public void setDateSubmitted(String date) {
        this.dateSubmitted = dateSubmitted;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReviewer() {
        return reviewer;
    }

    public void setReviewer(String reviewer) {
        this.reviewer = reviewer;
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "RTickets{" +
                "ticketId=" + ticketId +
                ", amount=" + amount +
                ", salary=" + salary +
                ", description='" + description + '\'' +
               // ", reimbursementType='" + reimbursementType + '\'' +
                ", dateSubmitted='" + dateSubmitted + '\'' +
                ", status='" + status + '\'' +
                ", sender='" + sender + '\'' +
              //  ", reviewer='" + reviewer + '\'' +
              //  ", username='" + username + '\'' +
              //  ", sc=" + sc +
                '}';
    }

    //methods
    /*
    public void submitTicket() {
        Random rand = new Random();
        System.out.println("Please fill out this reimbursement ticket as an Employee\nEnter a Period:");
        String str1 = sc.nextLine();
        setDate(str1);
        System.out.println("Your period is: " + getDate());
        int i1 = rand.nextInt(999999 + 1);
        setTicketNum(i1);
        System.out.println("Your Ticket No. is: " + getTicketNum());
        System.out.println("Enter a reimbursement amount: ");
        double i2 = sc.nextDouble();
        setAmount(i2);
        System.out.println("Amount requested: $" + getAmount());
        System.out.println("Fill out a description for this reimbursement: ");
        Scanner scan = new Scanner(System.in);
        String str2 = scan.nextLine();
        setDescription(str2);
        System.out.println("Reimbursement Description: " + getDescription());
        System.out.println("Thank you for your reimbursement submission!\nYour submission will be reviewed by a manager momentarily");
    }

     */







}
