package com.pnx.dao;

import java.util.List;

import com.hsbc.exceptions.DatabaseException;
import com.hsbc.exceptions.MeetingNotFoundException;
import com.hsbc.exceptions.UnauthorizedAccessException;
import com.pnx.models.Meeting;

import java.util.List;

public interface MeetingDAO {
    Meeting findById(int id) throws MeetingNotFoundException;
    List<Meeting> findAll() throws DatabaseException;
    void create(Meeting meeting) throws DatabaseException;
    void update(Meeting meeting) throws MeetingNotFoundException, UnauthorizedAccessException, DatabaseException;
    void delete(int id) throws MeetingNotFoundException, UnauthorizedAccessException, DatabaseException;
	List<Meeting> findByOrganizer(int organizerUserId);
}


