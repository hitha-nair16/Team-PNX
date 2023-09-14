package com.pnx.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.pnx.models.Users;

public class UserDaoImpl implements UserDao{
	
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

	    public UserDaoImpl(Connection connection) {
	        this.connection = connection;
	    }
	    private Users extractUserFromResultSet(ResultSet resultSet) throws SQLException {
	        int userId = resultSet.getInt("unique_id");
	        String username = resultSet.getString("name");
	        String email = resultSet.getString("email");
            String phone=resultSet.getString("phone");
            Double credits=resultSet.getDouble("credits");
            String role=resultSet.getString("role");
	        return new Users(userId, username, email,phone,credits,role);
	    }

	@Override
	public List<Users> readUsers() {
		List<Users> usersList = new ArrayList<>();
        String sql = "SELECT * FROM users"; // Assuming "users" is the name of your users table

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Users user = extractUserFromResultSet(resultSet);
                usersList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return usersList;	}

}
