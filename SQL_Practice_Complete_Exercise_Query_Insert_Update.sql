--QUERY
select * from "Employee";


select * from "Employee" where "LastName" = 'King';


select * from "Employee" where "FirstName" = 'Andrew' and "ReportsTo" isnull;


select * from "Album";
select * from "Album" order by "Title" desc;


select "FirstName" from "Customer" order by "City" asc;


select * from "Invoice";
select * from "Invoice" where "BillingAddress" like 'T%';


select * from "Invoice" where "Total" between 15 and 50;

select * from "Employee" where "HireDate" between '2003-06-01' and '2004-03-01';

--INSERT:

insert into "Genre" values (26, 'Korean Pop');
insert into "Genre" values (27, 'Bollywood');

select * from "Employee"; 
insert into "Employee" ("EmployeeId", "LastName", "FirstName", "Title", "ReportsTo", "BirthDate", "HireDate", "Address", "City", "State", "Country", "PostalCode", "Phone", "Fax", "Email") values (12, N'Eugene', N'Dustin', N'Hiring Manager', 5, '1960/12/3', '2007/6/6', N'404 Montgomery Way NW', N'Montreal', N'QC', N'Canada', N'P0J 5U6', N'+1 (800) 200-3050', N'+1 (043) 774-2211', N'dustin@chinookcorp.com');
insert into "Employee" ("EmployeeId", "LastName", "FirstName", "Title", "ReportsTo", "BirthDate", "HireDate", "Address", "City", "State", "Country", "PostalCode", "Phone", "Fax", "Email") values (15, N'Johnson', N'Kevin', N'Trainer', 3, '1955/10/2', '2012/3/1', N'550 Castle Blvd SE', N'Vancouver', N'BC', N'Canada', N'L6T 2I2', N'+1 (800) 320-7065', N'+1 (061) 700-0333', N'Kevin@chinookcorp.com');

select * from "Customer";
insert into "Customer" ("CustomerId", "FirstName", "LastName", "Address", "City", "State", "Country", "PostalCode", "Phone", "Email", "SupportRepId") values (60, N'Willard', N'Frank', N'675 Courts Ave', N'Winnipeg', N'AB', N'Canada', N'F6R 5D3', N'+1 (613) 422-0070', N'wifrank@yachoo.ca', 6);
insert into "Customer" ("CustomerId", "FirstName", "LastName", "Address", "City", "State", "Country", "PostalCode", "Phone", "Email", "SupportRepId") values (61, N'Lee', N'George', N'225 Swords Way', N'Toronto', N'ON', N'Canada', N'J7N 5O1', N'+1 (510) 330-4550', N'legeorge@yachoo.ca', 6);

--UPDATE:

update "Customer" set "FirstName" = 'Robert' where "FirstName" = 'Aaron';
update "Customer" set "LastName"  = 'Walter' where "LastName"  = 'Mitchell';
select * from "Customer" order by "CustomerId" asc;


update "Artist" set "Name" = 'CCR' where "Name" = 'Creedence Clearwater Revival';
select * from "Artist" order by "ArtistId" asc;  

















