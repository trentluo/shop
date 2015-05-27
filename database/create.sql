create database shop;
use shop;

--t_user
create table t_user(UUID varchar(32) primary key,USERNAME varchar(200),PASSWD varchar(200),EMAIL varchar(200),MOBILE varchar(20),USERTYPE int,USERSTATUS int,CUURLOGIN timestamp,LASTLOGIN timestamp,CREATEDATE timestamp,UPDATEDATE timestamp,EXTENSION varchar(1000));
--t_user_type
create table t_user_type(TYPEID int,TYPENAME varchar(200),CREATEDATE timestamp);