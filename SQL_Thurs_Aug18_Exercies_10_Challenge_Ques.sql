drop table if exists table1;
drop table if exists table2;
drop table if exists table3;


--Q1
create table table1(id integer, value integer);
insert into table1 values(1, -56);
insert into table1 values(2, 76);
insert into table1 values(3, -84);
insert into table1 values(4, 96);
insert into table1 values(5, -47); 
select * from table1;

update table1 set value = value*-1;

--Q2
create table table2(division_id integer, year integer, revenue integer);
insert into table2 values(1, 2018, 60);
insert into table2 values(1, 2021, 40);
insert into table2 values(1, 2020, 70);
insert into table2 values(2, 2021, -10);
insert into table2 values(3, 2018, 20);
insert into table2 values(3, 2016, 40);
insert into table2 values(4, 2021, 50);
select * from table2;

select division_id from table2 where year = 2021 and revenue > 0;

--Q3
create table table3(id integer, year integer);
insert into table3 values(1, 1776);
insert into table3 values(2, 2001);
insert into table3 values(3, 1643);
insert into table3 values(4, 1865);
insert into table3 values(5, 1969);

update table3 set year = year / 100 + 1;
select * from table3;

--Q4
create table table4(id integer, value integer);
insert into table4 values(1, 4);
insert into table4 values(2, 11);
insert into table4 values(3, 57);
insert into table4 values(4, 24);
insert into table4 values(5, 47);

select*from table4;
select case when value % 2 = 0 then 'even' when value % 2 = 1 then 'odd' end as even_odd from table4;

--Q5
create table table5(id integer, name varchar(50), age integer);
insert into table5 values(1, 'Bob', 21);
insert into table5 values(2, 'Sam', 19);
insert into table5 values(3, 'Jill', 18);
insert into table5 values(4, 'Jim', 21);
insert into table5 values(5, 'Sally', 19);
insert into table5 values(6, 'Jess', 20);
insert into table5 values(7, 'Will', 21);

select*from table5;
select age, count(name) from table5 group by age having count(name) >= 1 order by age asc;

--Q6
create table table6(id integer, name varchar(50));
insert into table6 values(1, 'Bob');
insert into table6 values(2, 'Sam');
insert into table6 values(3, 'Jill');
insert into table6 values(4, 'Jim');
insert into table6 values(5, 'Sally');
insert into table6 values(6, 'Jess');
insert into table6 values(7, 'Will');

select concat ('Hi,', name, '! How are you today?') as Greeting from table6;

--Q7
create table table7(id integer, name varchar(50), amount integer);
insert into table7 values(1, 'Cup', 11);
insert into table7 values(2, 'Saucer', 22);
insert into table7 values(3, 'Plate', 46);
insert into table7 values(4, 'Fork', 34);
insert into table7 values(5, 'Spoon', 45);
insert into table7 values(6, 'Knife', 78);
insert into table7 values(7, 'Mug', 23);
insert into table7 values(8, 'Glass', 64);
insert into table7 values(9, 'Tumbler', 24);

select*from table7;
select name, amount from table7 order by amount desc limit 5;

--Q8
create table table8(id integer, name varchar(50), country varchar(50));
insert into table8 values(1, 'Bob Smith', 'United States');
insert into table8 values(2, 'Jim Jones', 'China');
insert into table8 values(3, 'Sam White', 'Japan');
insert into table8 values(4, 'Jess Black', 'Canada');
insert into table8 values(5, 'Will Wilson', 'Germany');
insert into table8 values(6, 'Wilson Scott', 'England');
insert into table8 values(7, 'Scott Daniels', 'France');
insert into table8 values(8, 'Daniel Jackson', 'Canada');
insert into table8 values(9, 'Jack Johnson', 'United States');

select*from table8;
(select name from table8 where country notnull) except (select name from table8 where country like 'United States') except (select name from table8 where country like 'Canada');

--Q9
create table table9(id integer, name varchar(50), age integer);
insert into table9 values(1, 'Bob', 21);
insert into table9 values(2, 'Sam', 19);
insert into table9 values(3, 'Jill', 18);
insert into table9 values(4, 'Jim', 21);
insert into table9 values(5, 'Sally', 19);
insert into table9 values(6, 'Jess', 20);
insert into table9 values(7, 'Will', 21);

select distinct age from table9 order by age asc;

--Q10
create table table10(id integer, name varchar(50), age integer);
insert into table10 values(1, 'Bob', 21);
insert into table10 values(2, 'Sam', 19);
insert into table10 values(3, 'Jill', 18);
insert into table10 values(4, 'Jim', 21);
insert into table10 values(5, 'Sally', 19);
insert into table10 values(6, 'Jess', 20);
insert into table10 values(7, 'Will', 21);

select sum(age) as total from table10;

  






