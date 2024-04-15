package com.crud.application.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;



public class UserDao {
            private static final String URL = "jdbc:mysql://localhost:3306/test";
            private static final String USERNAME = "root";
            private static final String PASSWORD = "Madhan@1698";
            
            public void addUser(User user){
            	//database connection
            	try{
            		Connection connection = getConnection();
//            		Connection connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
            		
            		PreparedStatement preparedStatement = connection.prepareStatement("insert into user(id,username,email) values (?,?,?)");
            		preparedStatement.setInt(1, user.getId());
            		preparedStatement.setString(2, user.getUserName());
            		preparedStatement.setString(3, user.getEmail());
            		preparedStatement.executeUpdate();
            	}catch(SQLException e){
            		e.printStackTrace();
            	}
            	
            }

			public void updateUser(User user) {
				try{
					Connection connection = getConnection();
//					Connection connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
 
            		PreparedStatement preparedStatement = connection.prepareStatement("update user set username=?,email=? where id=?");
        		
            		preparedStatement.setString(1, user.getUserName());
            		preparedStatement.setString(2, user.getEmail());
            		preparedStatement.setInt(3, user.getId());
            		preparedStatement.executeUpdate();
				}catch(SQLException e){
					e.printStackTrace();
				}
				
			}

			public void deleteUser(int userId) {
				try{
					Connection connection = getConnection();
//					Connection connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
  
            		PreparedStatement preparedStatement = connection.prepareStatement("delete from user where id=?");
        		
            	
            		preparedStatement.setInt(1, userId);
            		preparedStatement.executeUpdate();
				}catch(SQLException e){
					e.printStackTrace();
				}
				
			}

			public List<User> getAllUsers() {
				List<User> users = new ArrayList<>();
				try{
					Connection connection = getConnection();
//					Connection connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
    
            		java.sql.Statement statement = connection.createStatement();
        		     ResultSet resultset = statement.executeQuery("select * from user");
        		     while(resultset.next()){
        		    	 User user = new User();
        		    	 user.setId(resultset.getInt("id"));
        		    	 user.setUserName(resultset.getString("userName"));
        		    	 user.setEmail(resultset.getString("email"));
        		    	 users.add(user);
        		     }
            	

				}catch(SQLException e){
					e.printStackTrace();
				}
				
				return users;
			}
//=================================================================================================//	
		    public static Connection getConnection() throws SQLException {

		        try {
		            Class.forName("com.mysql.cj.jdbc.Driver");
		        	System.out.println("Connected succesfully");
		        } catch (ClassNotFoundException e) {
		            e.printStackTrace();
		        }
        	
		        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
		    }
			
}
