package com.revature.data;

//Singleton - only one DAO instance
public class DaoFactory {

    private static EmployeeDao employeeDao = null;
    private static ManagerDao managerDao = null;

    private static RTicketsDao rTicketsDao = null;


    private DaoFactory() {

    }

    public static EmployeeDao getEmployeeDao() {
        if(employeeDao == null) {
            System.out.println("This should be only called once (Employee Dao Creation)");
            employeeDao = new EmployeeDaoImpl();
        }
        return employeeDao;
    }

    public static ManagerDao getManagerDao() {
        if(managerDao == null) {
            System.out.println("This should be only called once (Manager Dao Creation)");
            managerDao = new ManagerDaoImpl();
        }
        return managerDao;
    }

    public static RTicketsDao getRTicketsDao() {
        if(rTicketsDao == null) {
            System.out.println("This should be only called once (Reimbursement ticket Dao Creation)");
            rTicketsDao = new RTicketsDaoImpl();
        }
        return rTicketsDao;
    }

}
