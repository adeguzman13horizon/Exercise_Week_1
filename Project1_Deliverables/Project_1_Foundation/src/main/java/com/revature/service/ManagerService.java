package com.revature.service;

import com.revature.data.DaoFactory;
import com.revature.data.EmployeeDao;
import com.revature.data.ManagerDao;
import com.revature.entity.Employee;
import com.revature.entity.Manager;

import java.util.List;

public class ManagerService {

    public Manager insert(Manager manager) {
        System.out.println("In the service layer, getting the DAO and calling the insert DAO method");
        ManagerDao managerDao = DaoFactory.getManagerDao();
        return managerDao.insert(manager);
    }

    public Manager getByAccountId(int accountId) {
        ManagerDao managerDao = DaoFactory.getManagerDao();
        return managerDao.getByAccountId(accountId);
    }

    public List<Manager> getAllManagers() {
        ManagerDao managerDao = DaoFactory.getManagerDao();
        return managerDao.getAllManagers();
    }

    public Manager updateManager(Manager manager) {
        ManagerDao managerDao = DaoFactory.getManagerDao();
        return managerDao.update(manager);
    }

    public boolean deleteManager(int accountId) {
        ManagerDao managerDao = DaoFactory.getManagerDao();
        return managerDao.delete(accountId);
    }

    public boolean checkUsername(String username) {
        ManagerDao managerDao = DaoFactory.getManagerDao();
        return managerDao.checkUsername(username);
    }

    public Manager register(Manager manager) {
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
    }

    public Manager login(String username, String password) {
        // business logic where we check the password:
        ManagerDao managerDao = DaoFactory.getManagerDao();
        Manager manager = managerDao.getByUsername(username);
        if (password.equals(manager.getPassword())) {
            return manager;
        }
        return null;
    }

    public boolean loginManager(Manager manager) {
        ManagerDao managerDao = DaoFactory.getManagerDao();
        return managerDao.loginManager(manager);
    }


}
