package com.revature.service;

import com.revature.data.DaoFactory;
import com.revature.data.EmployeeDao;
import com.revature.data.ManagerDao;
import com.revature.data.RTicketsDao;
import com.revature.entity.Employee;
import com.revature.entity.Manager;
import com.revature.entity.RTickets;

import java.util.List;

public class RTicketsService {

    public RTickets submitRTicket(RTickets rTickets) {
        System.out.println("In the service layer, getting the DAO and calling the insert DAO method");
        RTicketsDao rTicketsDao = DaoFactory.getRTicketsDao();
        return rTicketsDao.submitRTicket(rTickets);
    }

    public RTickets getTicketId(int ticketId) {
        RTicketsDao rTicketsDao = DaoFactory.getRTicketsDao();
        return rTicketsDao.getTicketId(ticketId);
    }

    public List<RTickets> getAllTickets() {
        RTicketsDao rTicketsDao = DaoFactory.getRTicketsDao();
        return rTicketsDao.getAllTickets();
    }

    public RTickets updateRTickets(RTickets rTickets) {
        RTicketsDao rTicketsDao = DaoFactory.getRTicketsDao();
        return rTicketsDao.update(rTickets);
    }


    public boolean deleteRTickets(int accountId) {
        RTicketsDao rTicketsDao = DaoFactory.getRTicketsDao();
        return rTicketsDao.delete(accountId);
    }

    public boolean assignTicket(int accountId, int ticketId) {
        RTicketsDao rTicketsDao = DaoFactory.getRTicketsDao();
        return rTicketsDao.assignTicket(accountId, ticketId);
    }

    public List<RTickets> getSubmittedTickets(int accountId) {
        RTicketsDao rTicketsDao = DaoFactory.getRTicketsDao();
        return rTicketsDao.getSubmittedTickets(accountId);
    }

    public RTickets updateStatus(int ticketId, String status) {
        RTicketsDao rTicketsDao = DaoFactory.getRTicketsDao();
        return rTicketsDao.updateStatus(ticketId, status);
    }

    public RTickets submitRTicket(String sender) {
        System.out.println("In the service layer, getting the DAO and calling the insert DAO method");
        RTicketsDao rTicketsDao = DaoFactory.getRTicketsDao();
        return rTicketsDao.submitRTicket(sender);
    }

    public RTickets updateStatus(int ticketId, double amount, double salary, String description, String reimbursementType, String dateSubmitted, String status, String sender, String reviewer, String username) {
        RTicketsDao rTicketsDao = DaoFactory.getRTicketsDao();
        return rTicketsDao.updateStatus(ticketId, amount, salary, description, reimbursementType, dateSubmitted, status, sender, reviewer, username);
    }

    public List<RTickets> getTicketsFromEmployee(String sender) {
        RTicketsDao rTicketsDao = DaoFactory.getRTicketsDao();
        return rTicketsDao.getTicketsFromEmployee(sender);
    }

    public RTickets getTicketStatus(String status) {
        RTicketsDao rTicketsDao = DaoFactory.getRTicketsDao();
        return rTicketsDao.getTicketStatus(status);
    }

    public List<RTickets> getTicketsFilterStatus(String status, String sender) {
        RTicketsDao rTicketsDao = DaoFactory.getRTicketsDao();
        return rTicketsDao.getTicketsFilterStatus(status, sender);
    }








    /*public Manager register(Manager manager) {
        ManagerDao managerDao = DaoFactory.getManagerDao();
        Manager manager1 = managerDao.insert(manager);
        return manager1;
    }

    public Manager login(int accountId, String password) {
        ManagerDao managerDao = DaoFactory.getManagerDao();
        Manager manager = managerDao.getByAccountId(accountId);
        if (password.equals(manager.getPassword())) {
            return manager;
        }
        return null;
    }*/

}
