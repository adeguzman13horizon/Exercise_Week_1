package com.revature.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.data.EmployeeDao;
import com.revature.entity.Employee;
import com.revature.entity.RTickets;
import com.revature.service.EmployeeService;
import com.revature.service.RTicketsService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.Period;
import java.util.*;

public class EmployeeServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        EmployeeService employeeService = new EmployeeService();
        RTicketsService rTicketsService = new RTicketsService();
        ObjectMapper mapper = new ObjectMapper();
        Employee employee;
        try {
            employee = mapper.readValue(req.getReader(), Employee.class);
        } catch (Exception e) {
            e.printStackTrace();
            resp.sendError(400, "Invalid employee format");
            return;
        }
        //login or register
        String entering = req.getParameter("enter");
        if (entering.equals("login")) {
            employee = employeeService.login(employee.getUsername(), employee.getPassword());
            out.println("<h1>Login Success</h1>");
            out.println("<h2>You are currently logged in!</h2>");
        //When logged in as employee, you submit ticket here

        } else if (entering.equals("register")) {

                employee = employeeService.insert(employee);
                out.println(employee);
                out.println("<h2>You have successfully registered an account with us!</h2>");

        }
        if (employee == null) {
            resp.sendError(400, "Invalid credentials");
            return;
        }
        out.println(employee.getUsername() + " is authorized to login as an employee\nYour account ID is: " + employee.getAccountId());
        req.getSession().setAttribute("username", employee.getUsername());

    }


    //login can be doGet as well
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        //EmployeeService employeeService = new EmployeeService();
        RTicketsService rTicketsService = new RTicketsService();
        RTickets rTickets = new RTickets();
       /* ObjectMapper mapper = new ObjectMapper();
        try {
            rTickets = mapper.readValue(req.getReader(), RTickets.class);
        }catch(Exception e) {
            e.printStackTrace();
            resp.sendError(400, "Invalid ticket format");
            return;
        }*/



        //This is just a TESTING(optional)
     /*   String filtering = req.getParameter("filter");
        if(filtering.equals("approved")) {
            if(rTickets.getStatus().equalsIgnoreCase("approved")) {
                rTickets = rTicketsService.getTicketStatus(rTickets.getStatus());
                out.println(rTickets);
            }
        }

        else if (filtering.equals("denied")) {
            if(rTickets.getStatus().equalsIgnoreCase("denied")) {
                rTickets = rTicketsService.getTicketStatus(rTickets.getStatus());
                out.println(rTickets);
            }

        } else if (filtering.equals("pending")) {
            if(rTickets.getStatus().equalsIgnoreCase("pending")) {
                rTickets = rTicketsService.getTicketStatus(rTickets.getStatus());
                out.println(rTickets);
            }
        }*/

        /*try {
            status = req.getParameter("status");
        } catch (Exception e) {
            resp.sendError(400, "Must include ticket status.");
            return;
        }*/
        // try to get the person id from the session:
        String username;
        // String status;
        try {
            username = (String) req.getSession().getAttribute("username");
        } catch (Exception e) {
            resp.sendError(401, "Must be logged in to view previous submitted tickets");
            return;
        }
            out.println("Displaying " + username +"'s previously submitted tickets: ");
            List<RTickets> rTicketsL = rTicketsService.getTicketsFromEmployee(username);
            for (RTickets rTickets1 : rTicketsL) {
                out.println(rTickets1);
            }
        }

    }







