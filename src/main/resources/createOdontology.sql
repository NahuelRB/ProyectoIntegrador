'create table IF NOT EXISTS patient(id int auto_increment primary key,name varchar(255),lastname varchar (255),address varchar (50),dni varchar (20),highdate varchar(50));
'create table IF NOT EXISTS dentist(id int auto_increment primary key,name varchar(255),lastname varchar (255),tuition varchar (50));
'create table IF NOT EXISTS turnos(id int auto_increment primary key,fechaHora varchar(100));
'create table IF NOT EXISTS address(id int auto_increment primary key,name varchar(50), number integer, country varchar(20));
'insert into address(name,number,country) values ('11 de septiembre','2070','Argentina')
'insert into address(name,number,country) values ('Bellaco','1000','Puerto Rico')
'insert into address(name,number,country) values ('Toro','10000','España')
