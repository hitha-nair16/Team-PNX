package com.pnx.services;

import java.util.List;

import com.pnx.models.Meeting;
import com.pnx.models.Users;
import com.pnx.exceptions.DatabaseException;
import com.pnx.exceptions.MeetingNotFoundException;
import com.pnx.exceptions.UnauthorizedAccessException;

public interface MeetingService {
	Meeting getMeetingById(int id) throws MeetingNotFoundException, DatabaseException;
    List<Meeting> getAllMeetings() throws DatabaseException;
    List<Meeting> getMeetingsByOrganizer(int organizerUserId) throws DatabaseException;
    void createMeeting(Meeting meeting, String userRole) throws UnauthorizedAccessException, DatabaseException;
    void updateMeeting(Meeting meeting, String userRole) throws MeetingNotFoundException, UnauthorizedAccessException, DatabaseException;
    void deleteMeeting(int id, String userRole) throws MeetingNotFoundException, UnauthorizedAccessException, DatabaseException;
}