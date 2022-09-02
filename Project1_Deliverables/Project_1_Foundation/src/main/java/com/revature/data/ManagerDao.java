package com.revature.data;

import com.revature.entity.Employee;
import com.revature.entity.Manager;
import com.revature.entity.RTickets;

import java.util.List;

public interface ManagerDao {

    public Manager insert(Manager manager);

    public Manager getByAccountId(int accountId);
    public Manager getByUsername(String username);

    public boolean checkUsername(String username);
    public boolean loginManager(Manager manager);

    public List<Manager> getAllManagers();

    public Manager update(Manager manager);

    public boolean delete(int accountId);




    }
