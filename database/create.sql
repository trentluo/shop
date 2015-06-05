create database shop;
use shop;

--t_user
create table t_user(uuid varchar(50) primary key,username varchar(200),passwd varchar(200),email varchar(200),mobile varchar(20),userType int,userStatus varchar(20),currLogin timestamp,lastLogin timestamp,createDate timestamp,updateDate timestamp not null default current_timestamp on update current_timestamp,extension varchar(1000));
--t_user_type
create table t_user_type(typeId int,typeName varchar(200),createDate timestamp);