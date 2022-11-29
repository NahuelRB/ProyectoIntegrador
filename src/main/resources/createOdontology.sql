create table IF NOT EXISTS patient(id int auto_increment primary key,name varchar(255),lastname varchar (255),address varchar (50),dni varchar (20),highdate varchar(50));
create table IF NOT EXISTS dentist(id int auto_increment primary key,name varchar(255),lastname varchar (255),tuition varchar (50));
create table IF NOT EXISTS turnos(id int auto_increment primary key,fechaHora varchar(100));
