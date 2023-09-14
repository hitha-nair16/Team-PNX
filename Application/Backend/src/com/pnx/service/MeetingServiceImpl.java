package com.pnx.services;

import java.util.List;

import com.pnx.models.Meeting;
import com.pnx.models.Users.UserRole;
import com.pnx.dao.MeetingDao;
import com.pnx.dao.MeetingDao;
import com.pnx.exceptions.DatabaseException;
import com.pnx.exceptions.MeetingNotFoundException;
import com.pnx.exceptions.UnauthorizedAccessException;

public class MeetingServiceImpl implements MeetingService {
    private MeetingDao meetingDAO;

	public void setMeetingDAO(MeetingDao meetingDAO) {
		this.meetingDAO = meetingDAO;
	}

   
    @Override
    public Meeting getMeetingById(int id) throws MeetingNotFoundException, DatabaseException {
        try {
            return meetingDAO.findById(id);
        } 
        catch (MeetingNotFoundException e) {
            throw e; // Re-throw MeetingNotFoundException
        } 
    }

    @Override
    public List<Meeting> getAllMeetings() throws DatabaseException {
        try {
            return meetingDAO.findAll();
        } catch (DatabaseException e) {
            throw e; // Re-throw DatabaseException
        }
    }

    @Override
    public List<Meeting> getMeetingsByOrganizer(int organizerUserId) throws DatabaseException {
        return meetingDAO.findByOrganizer(organizerUserId);
    }

    @Override
    public void createMeeting(Meeting meeting, UserRole userRole) throws UnauthorizedAccessException, DatabaseException {
        if (userRole == UserRole.ADMIN || userRole == UserRole.MANAGER) {
            try {
                meetingDAO.create(meeting);
            } catch (DatabaseException e) {
                throw e; // Re-throw DatabaseException
            }
        } else {
            throw new UnauthorizedAccessException("Only Admins and Managers can create meetings.");
        }
    }

   
    @Override
    public void deleteMeeting(int id, UserRole userRole) throws MeetingNotFoundException, UnauthorizedAccessException, DatabaseException {
        if (userRole == UserRole.ADMIN || userRole == UserRole.MANAGER) {
            try {
                meetingDAO.delete(id);
            } catch (MeetingNotFoundException e) {
                throw e; // Re-throw MeetingNotFoundException
            } catch (UnauthorizedAccessException e) {
                throw e; // Re-throw UnauthorizedAccessException
            } catch (DatabaseException e) {
                throw e; // Re-throw DatabaseException
            }
        } else {
            throw new UnauthorizedAccessException("Only Admins and Managers can delete meetings.");
        }
    }

	@Override
	public void updateMeeting(Meeting meeting, UserRole userRole)
			throws MeetingNotFoundException, UnauthorizedAccessException, DatabaseException {
		// TODO Auto-generated method stub
		if (userRole == UserRole.ADMIN) {
            try {
                meetingDAO.update(meeting);
            } catch (MeetingNotFoundException e) {
                throw e; // Re-throw MeetingNotFoundException
            } catch (UnauthorizedAccessException e) {
                throw e; // Re-throw UnauthorizedAccessException
            } catch (DatabaseException e) {
                throw e; // Re-throw DatabaseException
            }
        } else {
            throw new UnauthorizedAccessException("Only Admins can update meetings.");
        }
		
	}

	

  
}