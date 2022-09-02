package com.revature.controller;

import com.revature.entity.Employee;

import java.util.Scanner;
public class CommandLine {
    public static void menu() {
        System.out.println("Which menu do you want to see?");
        System.out.println("1 - Employee menu");
        System.out.println("2 - Manager menu");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                EmployeeCommandLineInterface.menu();
                break;
            case 2:
                ManagerCommandLineInterface.menu();
                break;
            default:
                System.out.println("Please choose 1 or 2");
                break;
        }
    }
}
