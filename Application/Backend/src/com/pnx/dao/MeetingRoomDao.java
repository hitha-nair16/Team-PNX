package com.pnx.dao;

import java.util.List;

import com.pnx.models.MeetingRoom;
import com.pnx.models.Users;
import com.pnx.services.MeetingRoomService;

public interface MeetingRoomDao {
	public boolean insertMeetingRoom(MeetingRoom room, String userRole);
    public boolean updateMeetingRoom(MeetingRoom room, String userRole);
    public boolean deleteMeetingRoom(String name, String userRole);
    public MeetingRoomService getMeetingRoomByName(String name);
    public List<MeetingRoom> readAllMeetingRooms();
}
