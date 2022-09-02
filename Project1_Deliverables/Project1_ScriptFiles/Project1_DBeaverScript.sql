create database employees;

drop table if exists employee;
drop table if exists ticket;
drop table if exists manager;



create table employee (accountId serial primary key, firstName varchar(50), lastName varchar(50), email varchar(50), username varchar(50) unique, password varchar(50), address varchar(50), phoneNumber integer, position varchar(50) default 'employee');
--create table ticket (ticketId serial primary key, amount float, salary float, dateSubmitted varchar(50), description varchar(300), sender varchar(50), status varchar(50));
create table manager (accountId serial primary key, firstName varchar(50), lastName varchar(50), email varchar(50), username varchar(50) unique, password varchar(50), address varchar(50), phoneNumber integer, position varchar(50) default 'manager');
create table ticket (ticketId serial primary key, amount float, salary float, dateSubmitted varchar(50), description varchar(300), status varchar(50) default 'pending', sender varchar(50));


select * from employee; 
select * from ticket; 
select * from manager;  


select * from ticket where ticketId = 2;

