insert into meeting(unique_id,title,organised_by,meeting_date,start_time,end_time,meeting_type,members_count,meeting_room_info)values(101,"Room 1",11,'2023-08-23','09:30:00','11:00:00',"Online Training",10,"This Room has been Booked");
select * from meeting;
delete from meeting where unique_id=101; 	