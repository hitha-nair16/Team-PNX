package com.pnx.services;

import com.pnx.models.MeetingRoom;
import com.pnx.models.Users;
import com.pnx.models.Users;


import com.pnx.dao.MeetingRoomDao;

import java.sql.Connection;
import java.util.List;

public class MeetingRoomServiceImpl implements MeetingRoomService {
    private MeetingRoomDao meetingRoomDao;
    
    public void setmeetingRoomDAO(MeetingRoomDao dao)
    {
    	meetingRoomDao=dao;
    }

    // Create a new meeting room


	@Override
	public boolean createMeetingRoom(MeetingRoom room, String userRole) {
		// TODO Auto-generated method stub
        return meetingRoomDao.insertMeetingRoom(room, userRole);
	}

	@Override
	public boolean updateMeetingRoom(MeetingRoom room, String userRole) {
		// TODO Auto-generated method stub
        return meetingRoomDao.updateMeetingRoom(room, userRole);
	}

	@Override
	public MeetingRoomService getMeetingRoomByName(String name) {
		// TODO Auto-generated method stub
        return meetingRoomDao.getMeetingRoomByName(name);
	}

	@Override
	public boolean deleteMeetingRoom(String name, String userRole) {
		// TODO Auto-generated method stub
		return meetingRoomDao.deleteMeetingRoom(name,userRole);
	}

	@Override
	public List<MeetingRoom> getAllMeetingRooms() {
		return meetingRoomDao.readAllMeetingRooms();
	}


    // Add more service methods as needed for your application
}
