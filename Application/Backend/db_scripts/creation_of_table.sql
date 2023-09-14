create database meetings;
use meetings;
create table users
(
unique_id int primary key,
name varchar(30) not null,
email varchar(30) ,
phone varchar(10),
credits int,
role varchar(10) not null
);
create table meeting
(
unique_id int primary key,
title varchar(100),
organised_by int,
meeting_date date,
start_time time,
end_time time,
meeting_type varchar(20),
members_count int,
meeting_room_info varchar(50),
constraint foreign key(organised_by) references users(unique_id)
);
create table meeting_room
(
unique_name varchar(20) primary key,
seating_capacity int,
ratings int,
projector int,
wi_fi_connection int,
conference_call_facility int,
whiteboard int,
water_dispenser int,
tv int,
coffee_machine int,
per_hour_cost int
);
create table booking_info(
unique_id int primary key,
meeting_room varchar(30),
_date date,
start_time time,
end_time time,
booked_by int,
constraint foreign key(booked_by)references users(unique_Id)
);