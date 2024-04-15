package com.crud.application.controller;

import java.util.List;

import com.crud.application.model.User;
import com.crud.application.model.UserDao;

public class UserController {
             UserDao userDao = new UserDao();
             
             
             public void addUser(int id,String username,String email){
            	 User user = new User();
            	 user.setId(id);
            	 user.setUserName(username);
            	 user.setEmail(email);
            	 userDao.addUser(user);
             }


			public void updateUser(int userId, String userName, String userEmail) {
				User user = new User();
           	    user.setId(userId);
            	 user.setUserName(userName);
            	 user.setEmail(userEmail);
            	 userDao.updateUser(user);
				
			}


			public void deleteUser(int userId) {
				userDao.deleteUser(userId);
				
			}


			public List<User> getAllUsers() {
				
				return userDao.getAllUsers();
			}
}

