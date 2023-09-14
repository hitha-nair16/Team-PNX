package com.pnx.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.pnx.models.BookingInformation;

public class BookingInfoDaoImpl implements BookingInfoDao {

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

	    public BookingInfoDaoImpl(Connection connection) {
	        this.connection = connection;
	    }
	    private BookingInformation extractBookingInformationFromResultSet(ResultSet resultSet) throws SQLException {
	        int id = resultSet.getInt("Unique_id");
	        String meetingroom=resultSet.getString("meeting_room");
	        String date=resultSet.getString("date");
	        String stime=resultSet.getString("start_time");
	        String etime=resultSet.getString("end_time");
	        int userid=resultSet.getInt("Booked_by");
	       	        return new BookingInformation(id,meetingroom,date,stime,etime,userid);
	    }
	@Override
	public List<BookingInformation> readAllBooking() {
		 List<BookingInformation> bookings = new ArrayList<>();
	        String sql = "SELECT * FROM booking_information";
	        try (PreparedStatement statement = connection.prepareStatement(sql)) {
	            ResultSet resultSet = statement.executeQuery();

	            while (resultSet.next()) {
	                BookingInformation booking = extractBookingInformationFromResultSet(resultSet);
	                bookings.add(booking);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return bookings;
	}

	@Override
	public BookingInformation readBooking(int bookingId) {
		 String sql = "SELECT * FROM booking_information WHERE booking_id = ?";
	        try (PreparedStatement statement = connection.prepareStatement(sql)) {
	            statement.setInt(1, bookingId);
	            ResultSet resultSet = statement.executeQuery();

	            if (resultSet.next()) {
	                return extractBookingInformationFromResultSet(resultSet);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return null;
	}

}
