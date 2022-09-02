package com.revature.data;

import com.revature.entity.Employee;
import com.revature.entity.RTickets;

import java.util.List;

public interface RTicketsDao {

    public RTickets submitRTicket(RTickets rTickets);

    public RTickets getTicketId(int ticketId);
    //public boolean checkUsername(String username);


    public List<RTickets> getAllTickets();

    public RTickets update(RTickets rTickets);

    public boolean delete(int accountId);

    public boolean assignTicket(int accountId, int ticketId);
    public List<RTickets> getSubmittedTickets(int accountId);
    public RTickets updateStatus(int ticketId, String status);

    public RTickets submitRTicket(String sender);

    public RTickets updateStatus(int ticketId, double amount, double salary, String description, String reimbursementType, String dateSubmitted, String status, String sender, String reviewer, String username);

    public List<RTickets> getTicketsFromEmployee(String sender);

    public RTickets getTicketStatus(String status);

    public List<RTickets> getTicketsFilterStatus(String status, String sender);






    }