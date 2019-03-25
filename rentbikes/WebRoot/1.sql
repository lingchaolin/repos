create table customers(
identity varchar(20),custname varchar(20)
,sex int,address varchar(20),phone varchar(20)
,career varchar(20),password varchar(20));

create table bikes(
bikenumber varchar(20),biketype varchar(20),color varchar(20)
,price double,rentprice double,deposit double
,isrenting int,description varchar(20));

create table users(username varchar(20),identity varchar(20)
,fullname varchar(20),sex int,address varchar(20)
,phone varchar(20),position varchar(20),userlevel varchar(20)
,password varchar(20));

insert into users(username,identity,fullname,sex,address,phone
,position,userlevel,password) 
values ('henliqi','','linqi',1,'hangzhou','daguan','','admin','admin');

alter table users add column id int AUTO_INCREMENT PRIMARY KEY;
alter table bikes add column id int AUTO_INCREMENT PRIMARY KEY;
alter table customers add column id int AUTO_INCREMENT PRIMARY KEY;
--delete from users;
select * from users;

