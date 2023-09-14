package com.pnx.dao;

import java.util.List;

import com.pnx.models.MeetingRoom;
import com.pnx.models.Users.UserRole;
import com.pnx.services.MeetingRoomService;

public interface MeetingRoomDao {
	public boolean insertMeetingRoom(MeetingRoomService room, UserRole userRole);
    public boolean updateMeetingRoom(MeetingRoomService room, UserRole userRole);
    public boolean deleteMeetingRoom(String name, UserRole userRole);
    public MeetingRoomService getMeetingRoomByName(String name);
    public List<MeetingRoom> readAllMeetingRooms();
}
