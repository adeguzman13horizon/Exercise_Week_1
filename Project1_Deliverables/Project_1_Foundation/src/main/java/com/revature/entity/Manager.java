package com.revature.entity;

public class Manager {
    private int accountId;
    private int age;
    private int phoneNumber;
    private double salary;
    private String username;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String address;
    private String position;
    //private String title;
    //private String ticketStatus;

    //constructors
    public Manager(int accountId, int age, int phoneNumber, double salary, String username, String email, String password, String firstName, String lastName, String address) {
        this.accountId = accountId;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.username = username;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }
    //w/o accountId
    public Manager(int age, int phoneNumber, double salary, String username, String email, String password, String firstName, String lastName, String address) {
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.username = username;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }

    //JDBC Constructors

    //default
    public Manager() {

    }

    //insert constructor
    public Manager(String firstName, String lastName, String email, String username, String password, String address, int phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.username = username;
        this.password = password;
        this.address = address;
        this.phoneNumber = phoneNumber;
        //this.position = position;
    }
    //getById
    public Manager(int accountId, int age2, double salary, String username2, String email2, String password2, String firstName2, String lastName2) {
        this.accountId = accountId;
        this.age = age2;
        this.salary = salary;
        this.username = username2;
        this.email = email2;
        this.password = password2;
        this.firstName = firstName2;
        this.lastName = lastName2;
    }

    public Manager(double salary, String username, String email, String password, String firstName, String lastName) {
        //this.age = age;
        this.salary = salary;
        this.username = username;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Manager(String username) {
        this.username = username;
    }

    public Manager(int accountId, int phoneNumber, String username, String email, String password, String firstName, String lastName, String address) {
        this.accountId = accountId;
        this.phoneNumber = phoneNumber;
        this.username = username;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }

    public Manager(int accountId, String firstName, String lastName, String email, String username, String password, String address, int phoneNumber) {
        this.accountId = accountId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.username = username;
        this.password = password;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public Manager(String userEmp, String passEmp) {
        this.username = userEmp;
        this.password = passEmp;
    }
    //getByAccountId
    public Manager(int accountIdDb, String usernameDb, String email, String password, String firstName, String lastName) {
        this.accountId = accountIdDb;
        this.username = usernameDb;
        this.email = email;
        this.password =password;
        this.firstName=firstName;
        this.lastName=lastName;
    }


    //getter setters
    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "accountId=" + accountId +
               // ", age=" + age +
                ", phoneNumber=" + phoneNumber +
              //  ", salary=" + salary +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", position='" + position + '\'' +
                '}';
    }
}
