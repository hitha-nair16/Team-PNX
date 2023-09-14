package com.pnx.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.pnx.models.MeetingRoom;
import com.pnx.models.Users;
import com.pnx.services.MeetingRoomService;

public class MeetingRoomDaoImpl implements MeetingRoomDao {
	private Connection connection;
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
	

    public MeetingRoomDaoImpl(Connection connection) {
        this.connection = connection;
    }
    public boolean canPerformOperation(String userRole)
    {
    	if(userRole=="User")return false;
    	return true;
    }
    public boolean canPerformOperationAdmin(String userRole)
    {
    	if(userRole=="Admin")return true;
    	return false;
    }

    private MeetingRoom extractMeetingRoomServiceFromResultSet(ResultSet resultSet) throws SQLException {
        String name = resultSet.getString("name");
        int seatingCapacity = resultSet.getInt("seating_capacity");
        double ratings = resultSet.getDouble("ratings");
        String amenitiesStr = resultSet.getString("amenitiesAvailable");
        // Split the amenities string into a Set<String>
        Set<String> amenities = new HashSet<>(Arrays.asList(amenitiesStr.split(",")));

        MeetingRoom roomService = new MeetingRoom(amenitiesStr, seatingCapacity, ratings, amenities);
        roomService.setName(name);
        roomService.setSeatingCapacity(seatingCapacity);
        roomService.setRatings(ratings);
        roomService.setAmenitiesAvailable(amenities);
       

        // You can set other attributes of MeetingRoomService here

        return roomService;
    }


	@Override
	public boolean insertMeetingRoom(MeetingRoom room, String userRole) {
		  if (canPerformOperation(userRole)) {
	            String sql = "INSERT INTO meeting_rooms (name, seating_capacity, ratings, amenities) VALUES (?, ?, ?, ?)";
	            try (PreparedStatement statement = connection.prepareStatement(sql)) {
	                statement.setString(1, room.getName());
	                statement.setInt(2, room.getSeatingCapacity());
	                statement.setDouble(3, room.getRatings());
	                statement.setString(4, String.join(",", room.getAmenitiesAvailable()));

	                int rowsAffected = statement.executeUpdate();
	                return rowsAffected > 0;
	            } catch (SQLException e) {
	                e.printStackTrace();
	                return false;
	            }
	        }
	        return false;
	}

	@Override
	public boolean updateMeetingRoom(MeetingRoom room, String userRole) {
		  if (canPerformOperationAdmin(userRole)) {
		        String sql = "UPDATE meeting_rooms SET seating_capacity = ?, ratings = ?, amenities = ? WHERE name = ?";
		        try (PreparedStatement statement = connection.prepareStatement(sql)) {
		            statement.setInt(1, room.getSeatingCapacity());
		            statement.setDouble(2, room.getRatings());
		            statement.setString(3, String.join(",", room.getAmenitiesAvailable()));
		            statement.setString(4, room.getName());

		            int rowsAffected = statement.executeUpdate();
		            return rowsAffected > 0;
		        } catch (SQLException e) {
		            e.printStackTrace();
		            return false;
		        }
		    }
		    return false;
	}

	

	@Override
	public MeetingRoom getMeetingRoomByName(String name) {
		 String sql = "SELECT * FROM meeting_rooms WHERE name = ?";
	        try (PreparedStatement statement = connection.prepareStatement(sql)) {
	            statement.setString(1, name);
	            ResultSet resultSet = statement.executeQuery();

	            if (resultSet.next()) {
	                return extractMeetingRoomServiceFromResultSet(resultSet);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return null;
	    
	}

	@Override
	public List<MeetingRoom> readAllMeetingRooms() {
	      List<MeetingRoom> rooms = new ArrayList<>();
	        String sql = "SELECT * FROM meeting_rooms";
	        try (PreparedStatement statement = connection.prepareStatement(sql)) {
	            ResultSet resultSet = statement.executeQuery();

	            while (resultSet.next()) {
	                MeetingRoom room = extractMeetingRoomServiceFromResultSet(resultSet);
	                rooms.add(room);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return rooms;
	}

	@Override
	public boolean deleteMeetingRoom(String name, String userRole) {
		 if (canPerformOperationAdmin(userRole)) {
		        String sql = "DELETE FROM meeting_rooms WHERE name = ?";
		        try (PreparedStatement statement = connection.prepareStatement(sql)) {
		            statement.setString(1, name);

		            int rowsAffected = statement.executeUpdate();
		            return rowsAffected > 0;
		        } catch (SQLException e) {
		            e.printStackTrace();
		            return false;
		        }
		    }
		    return false;
	}

}
