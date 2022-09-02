package com.revature;

import com.revature.controller.CommandLine;
import com.revature.controller.EmployeeCommandLineInterface;
import com.revature.controller.ManagerCommandLineInterface;
import com.revature.entity.Employee;
import com.revature.entity.Manager;
import com.revature.service.EmployeeService;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Employee newEmployee = new Employee();
        Manager newManager = new Manager();
        //EmployeeCommandLineInterface ecli = new EmployeeCommandLineInterface();
        //ManagerCommandLineInterface mcli = new ManagerCommandLineInterface();

        //System.out.println( "Hello Wad!" );
      //  CommandLine.menu();

      //  ManagerCommandLineInterface.menu();
        EmployeeCommandLineInterface.menu();


    }
}
