package com.pnx.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.pnx.exceptions.DatabaseException;
import com.pnx.exceptions.MeetingNotFoundException;
import com.pnx.exceptions.UnauthorizedAccessException;
import com.pnx.models.Meeting;

public class MeetingDaoImpl implements MeetingDao {
    private Connection connection; // Database connection setup is required.

private Statement stmt = null;
	
	private void openResources() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb", "root", "root@123");
		stmt = connection.createStatement();
	}
	private void closeResources() throws SQLException {
		stmt.close();
		connection.close();
	}
	
    // Constructor to inject database connection.
    public MeetingDaoImpl() throws DatabaseException {
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
    public Meeting findById(int id) {
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
            }
        } catch (SQLException e) {
            // Handle database error
            e.printStackTrace();
        }
        return null;
    }

    private Meeting mapResultSetToMeeting(ResultSet resultSet) {
		return null;
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
    
            List<Meeting> meetings = new ArrayList<>();

            try {
                String sql = "SELECT * FROM meetings";
                PreparedStatement statement = connection.prepareStatement(sql);
                ResultSet resultSet = statement.executeQuery();

                while (resultSet.next()) {
                    // Map each database row to a Meeting object and add it to the list
                    Meeting meeting1 = mapResultSetToMeeting(resultSet);
                    meetings.add(meeting1);
                }

                
            } catch (SQLException e) {
                // Handle database error
                e.printStackTrace();
                throw new DatabaseException("Error while fetching all meetings");
            }
        }

    @Override
    public void update(Meeting meeting) throws MeetingNotFoundException, UnauthorizedAccessException, DatabaseException {
    	Meeting existingMeeting = findById(meeting.getId());
        

        String sql = "UPDATE meetings SET title = ?, meeting_date = ?, start_time = ?, end_time = ?, type = ? " +
                     "WHERE id = ?";
        
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, meeting.getTitle());
            statement.setDate(2, java.sql.Date.valueOf(meeting.getMeetingDate()));
            statement.setTime(3, java.sql.Time.valueOf(meeting.getStartTime()));
            statement.setTime(4, java.sql.Time.valueOf(meeting.getEndTime()));
            statement.setString(5, meeting.getType().name());
        statement.setString(5, meeting.getType().name());
        statement.setInt(6, meeting.getId());

        int rowsUpdated = statement.executeUpdate();
        if (rowsUpdated == 0) {
            throw new MeetingNotFoundException("Meeting not found with ID: " + meeting.getId());
        }
    } catch (SQLException e) {
        throw new DatabaseException("Error while updating the meeting");
    }
}
    

    @Override
    public void delete(int id) throws MeetingNotFoundException, UnauthorizedAccessException, DatabaseException {
    	  Meeting existingMeeting = findById(id);
    	    
    	    

    	    String sql = "DELETE FROM meetings WHERE id = ?";
    	    
    	    try (PreparedStatement statement = connection.prepareStatement(sql)) {
    	        statement.setInt(1, id);

    	        int rowsDeleted = statement.executeUpdate();
    	        if (rowsDeleted == 0) {
    	            throw new MeetingNotFoundException("Meeting not found with ID: " + id);
    	        }
    	    } catch (SQLException e) {
    	        throw new DatabaseException("Error while deleting the meeting");
    	    }
    	  
    }
    
    private Meeting extractMeetingFromResultSet(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String title = resultSet.getString("title");
        int organizedByUserId = resultSet.getInt("organized_by_user_id");
        java.sql.Date meetingDate = resultSet.getDate("meeting_date");
        java.sql.Time startTime = resultSet.getTime("start_time");
        java.sql.Time endTime = resultSet.getTime("end_time");
        String typeStr = resultSet.getString("type");

        Meeting.MeetingType type = Meeting.MeetingType.valueOf(typeStr);

        // Create and return a Meeting object
        return new Meeting();
    }

	@Override
	public List<Meeting> findByOrganizer(int organizerUserId) {
		  List<Meeting> meetings = new ArrayList<>();
	        String sql = "SELECT * FROM meetings WHERE organized_by_user_id = ?";
	        try (PreparedStatement statement = connection.prepareStatement(sql)) {
	            statement.setInt(1, organizerUserId);
	            ResultSet resultSet = statement.executeQuery();

	            while (resultSet.next()) {
	                Meeting meeting = extractMeetingFromResultSet(resultSet);
	                meetings.add(meeting);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return meetings;
	    }	

	
	}





