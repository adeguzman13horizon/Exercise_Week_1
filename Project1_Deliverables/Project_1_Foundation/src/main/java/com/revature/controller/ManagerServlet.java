package com.revature.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.data.RTicketsDaoImpl;
import com.revature.entity.Employee;
import com.revature.entity.Manager;
import com.revature.entity.RTickets;
import com.revature.service.EmployeeService;
import com.revature.service.ManagerService;
import com.revature.service.ManagerService;
import com.revature.service.RTicketsService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ManagerServlet extends HttpServlet {
    //manager register/login
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        ManagerService managerService = new ManagerService();
        RTicketsService rTicketsService = new RTicketsService();
        ObjectMapper mapper = new ObjectMapper();
        Manager manager;
        try {
            manager = mapper.readValue(req.getReader(), Manager.class);
        } catch (Exception e) {
            e.printStackTrace();
            resp.sendError(400, "Invalid manager format");
            return;
        }
        //login or register
        String entering = req.getParameter("enter");
        if (entering.equals("login")) {
            manager = managerService.login(manager.getUsername(), manager.getPassword());
            out.println("<h1>Login Success</h1>");
            out.println("<h2>You are currently logged in!</h2>");
            //When logged in as manager, you can process ticket either by approving or denying

        } else if (entering.equals("register")) {

            manager = managerService.insert(manager);
            out.println(manager);
            out.println("<h2>You have successfully registered an account with us!</h2>");

        }
        if (manager == null) {
            resp.sendError(400, "Invalid credentials");
            return;
        }
        out.println(manager.getUsername() + " is authorized to login as a manager\nYour account ID is: " + manager.getAccountId());
        req.getSession().setAttribute("username", manager.getUsername());

    }


    // managers can update/process ticket status
    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        RTicketsService rTicketsService = new RTicketsService();
       // RTickets rTickets = new RTickets();
        Manager manager = new Manager();
        EmployeeService employeeService = new EmployeeService();
        ObjectMapper mapper = new ObjectMapper();
        RTickets rTickets;
        try {
            rTickets = mapper.readValue(req.getReader(), RTickets.class);
            System.out.println("ticket : " + rTickets);
        } catch (Exception e) {
            e.printStackTrace();
            resp.sendError(400, "Invalid employee format");
            return;
        }
    //    int ticketId;
        String username;
     //   String status;
        // try to get the person id from the session:
        try {
            username = (String) req.getSession().getAttribute("username");
            rTickets.setUsername(username);
           // out.println(rTickets.getUsername());
        } catch (Exception e) {
            // if we don't get the id, we send a 401 (authantication) error
            resp.sendError(401, "Must be logged in to process ticket.");
            return;
        }
        rTickets = rTicketsService.getTicketId(rTickets.getTicketId());
        // update the ticket status:
       if(rTickets.getStatus().equalsIgnoreCase("pending")) {
            try {
                String entering = req.getParameter("change");

                if (entering.equals("approved")) {
                    rTickets.setStatus("approved");
                    rTickets = rTicketsService.updateStatus(rTickets.getTicketId(), rTickets.getStatus());
                    out.println("<h1>successfully approved</h1>");
                    out.println("Ticket status changed successfully!");

                } //else {out.println("STAT CANNOT BE ALTERED!");}

                else if (entering.equals("denied")) {
                    rTickets.setStatus("denied");
                    rTickets = rTicketsService.updateStatus(rTickets.getTicketId(), rTickets.getStatus());
                    out.println("<h1>successfully denied</h1>");
                    out.println("Ticket status changed successfully!");
                } //else {out.println("STAT CANNOT BE ALTERED!");}

                else if (entering.equals("pending")) {
                    rTickets.setStatus("pending");
                    rTickets = rTicketsService.updateStatus(rTickets.getTicketId(), rTickets.getStatus());
                    out.println("<h1>still pending</h1>");
                    out.println("Ticket status changed successfully!");
                }
                if (rTickets == null) {
                    resp.sendError(400, "Invalid credentials");
                    return;
                }
            } catch (Exception e) {
                e.printStackTrace();
                resp.sendError(400, "Make sure ticketId exists!");
                return;
            }
         } else {
           out.println("THIS TICKET CANNOT BE ALTERED!");
       }
        //out.println("Ticket status changed successfully!");
        //out.println(rTickets);
        out.println(rTicketsService.getTicketId(rTickets.getTicketId()));
    }



}
