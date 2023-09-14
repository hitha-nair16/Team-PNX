package com.pnx.services;

import java.util.List;

import com.pnx.models.Users.UserRole;
import com.pnx.models.*;
public interface MeetingRoomService {
	public boolean createMeetingRoom(MeetingRoomService room, UserRole userRole);
    public boolean updateMeetingRoom(MeetingRoomService room, UserRole userRole);
    public boolean deleteMeetingRoom(String name, UserRole userRole);
    public MeetingRoomService getMeetingRoomByName(String name);
    public List<MeetingRoom> getAllMeetingRooms();
}
