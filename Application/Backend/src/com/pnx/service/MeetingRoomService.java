package com.pnx.services;

import java.util.List;

import com.pnx.models.Users;
import com.pnx.models.*;
public interface MeetingRoomService {
	public boolean createMeetingRoom(MeetingRoom room, String userRole);
    public boolean updateMeetingRoom(MeetingRoom room, String userRole);
    public boolean deleteMeetingRoom(String name, String userRole);
    public MeetingRoomService getMeetingRoomByName(String name);
    public List<MeetingRoom> getAllMeetingRooms();
}
