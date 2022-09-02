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

import javax.servlet.http.HttpServlet;

public class RTicketsServlet extends HttpServlet {

    //CHECK THIS OUT W/ RORY
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        RTicketsService rTicketsService = new RTicketsService();
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

        //EmployeeService employeeService = new EmployeeService();
        String sender;
        try {
            sender = (String) req.getSession().getAttribute("username");
            rTickets.setSender(sender);
        } catch (Exception e) {
            resp.sendError(401, "Must be logged in to submit reimbursement ticket");
            return;
        }
        out.println(sender + " submitted a reimbursement ticket!");
        rTickets = rTicketsService.submitRTicket(rTickets);
        out.println(rTickets);



      //  req.getSession().setAttribute("status", rTickets.getStatus());

    }

    //THIS IS FOR FILTERING TO VIEW BY APPROVED, DENIED, PENDING
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       // resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        //EmployeeService employeeService = new EmployeeService();
        RTicketsService rTicketsService = new RTicketsService();
       // RTickets rTickets = new RTickets();
        ObjectMapper mapper = new ObjectMapper();
        RTickets rTickets;
        try {
            rTickets = mapper.readValue(req.getReader(), RTickets.class);
        }catch(Exception e) {
            e.printStackTrace();
            resp.sendError(400, "Invalid ticket format");
            return;
        }
        String sender;
        try {
            sender = (String) req.getSession().getAttribute("username");
            rTickets.setSender(sender);
        } catch (Exception e) {
            resp.sendError(401, "Must be logged in to filter ticket by status");
            return;
        }
        out.println(sender +"'s ticket submission has been successfully filtered by status type!");
        List<RTickets> rTicketsLists = rTicketsService.getTicketsFilterStatus(rTickets.getStatus(), rTickets.getSender());

        for(RTickets rTicketsPrint: rTicketsLists) {
            out.println(rTicketsPrint);
        }
        /*
        if (rTickets == null) {
            resp.sendError(400, "Invalid credentials");
            return;
        }
    } catch (Exception e) {
        e.printStackTrace();
        resp.sendError(400, "Make sure ticketId exists!");
        return;
    }
        /*
        List<RTickets> rTicketsLst = rTicketsService.getTicketsFromEmployee(rTickets.getStatus());
        for (RTickets rTicketsTest : rTicketsLst) {
            out.println(rTicketsTest);
        }*/

        /*try {
            status = req.getParameter("status");
        } catch (Exception e) {
            resp.sendError(400, "Must include ticket status.");
            return;
        }*/
        // try to get the person id from the session:

    }
}
