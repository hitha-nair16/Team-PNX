package com.pnx.dao;
import com.pnx.models.*;
import java.util.List;

import com.pnx.models.Meeting;
import com.pnx.exceptions.DatabaseException;
import com.pnx.exceptions.MeetingNotFoundException;
import com.pnx.exceptions.UnauthorizedAccessException;

import java.util.List;

public interface MeetingDao {
    Meeting findById(int id) throws MeetingNotFoundException;
    List<Meeting> findAll() throws DatabaseException;
    void create(Meeting meeting) throws DatabaseException;
    void update(Meeting meeting) throws MeetingNotFoundException, UnauthorizedAccessException, DatabaseException;
    void delete(int id) throws MeetingNotFoundException, UnauthorizedAccessException, DatabaseException;
	List<Meeting> findByOrganizer(int organizerUserId);
}


