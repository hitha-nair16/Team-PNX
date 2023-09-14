package com.pnx.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hsbc.exceptions.DatabaseException;
import com.hsbc.exceptions.MeetingNotFoundException;
import com.hsbc.exceptions.UnauthorizedAccessException;
import com.pnx.models.Meeting;

public class MeetingDAOImpl implements MeetingDAO {
    private Connection connection; // Database connection setup is required.

    // Constructor to inject database connection.
    public MeetingDAOImpl() {
        try {
            // Replace with your actual database connection details
            String url = "jdbc:mysql://your_database_url";
            String username = "your_username";
            String password = "your_password";
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            // Handle database connection error
            e.printStackTrace();
            throw new DatabaseException("Unable to connect to the database");
        }
    }
    
    @Override
    public Meeting findById(int id) throws MeetingNotFoundException {
        try {
            String sql = "SELECT * FROM meetings WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                // Map the database result to a Meeting object
                Meeting meeting = mapResultSetToMeeting(resultSet);
                return meeting;
            } else {
                throw new MeetingNotFoundException("Meeting with ID " + id + " not found.");
            }
        } catch (SQLException e) {
            // Handle database error
            e.printStackTrace();
            throw new DatabaseException("Error while fetching meeting by ID");
        }
    }

    @Override
    public List<Meeting> findAll() throws DatabaseException {
        List<Meeting> meetings = new ArrayList<>();

        try {
            String sql = "SELECT * FROM meetings";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                // Map each database row to a Meeting object and add it to the list
                Meeting meeting = mapResultSetToMeeting(resultSet);
                meetings.add(meeting);
            }

            return meetings;
        } catch (SQLException e) {
            // Handle database error
            e.printStackTrace();
            throw new DatabaseException("Error while fetching all meetings");
        }
    }

    @Override
    public void create(Meeting meeting) throws DatabaseException {
    	public List<Meeting> findAll() throws DatabaseException {
            List<Meeting> meetings = new ArrayList<>();

            try {
                String sql = "SELECT * FROM meetings";
                PreparedStatement statement = connection.prepareStatement(sql);
                ResultSet resultSet = statement.executeQuery();

                while (resultSet.next()) {
                    // Map each database row to a Meeting object and add it to the list
                    Meeting meeting = mapResultSetToMeeting(resultSet);
                    meetings.add(meeting);
                }

                return meetings;
            } catch (SQLException e) {
                // Handle database error
                e.printStackTrace();
                throw new DatabaseException("Error while fetching all meetings");
            }
        }

    @Override
    public void update(Meeting meeting) throws MeetingNotFoundException, UnauthorizedAccessException, DatabaseException {
        // Implement SQL query to update a meeting.
        // Handle SQLException.
        // If not found, throw MeetingNotFoundException.
        // If unauthorized (e.g., Manager trying to update), throw UnauthorizedAccessException.
    }

    @Override
    public void delete(int id) throws MeetingNotFoundException, UnauthorizedAccessException, DatabaseException {
        // Implement SQL query to delete a meeting.
        // Handle SQLException.
        // If not found, throw MeetingNotFoundException.
        // If unauthorized (e.g., Member trying to delete), throw UnauthorizedAccessException.
    }
}

