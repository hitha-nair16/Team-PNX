package com.pnx.service;

import java.util.List;

import com.hsbc.exceptions.DatabaseException;
import com.hsbc.exceptions.MeetingNotFoundException;
import com.hsbc.exceptions.UnauthorizedAccessException;
import com.pnx.models.Meeting;
import com.pnx.models.Users.UserRole;

public interface MeetingService {
	Meeting getMeetingById(int id) throws MeetingNotFoundException, DatabaseException;
    List<Meeting> getAllMeetings() throws DatabaseException;
    List<Meeting> getMeetingsByOrganizer(int organizerUserId) throws DatabaseException;
    void createMeeting(Meeting meeting, UserRole userRole) throws UnauthorizedAccessException, DatabaseException;
    void updateMeeting(Meeting meeting, UserRole userRole) throws MeetingNotFoundException, UnauthorizedAccessException, DatabaseException;
    void deleteMeeting(int id, UserRole userRole) throws MeetingNotFoundException, UnauthorizedAccessException, DatabaseException;
}