package com.crud.application.view;

import java.util.List;
import java.util.Scanner;

import com.crud.application.controller.UserController;
import com.crud.application.model.User;

public class MainView {
       private static final UserController userController = new UserController();
      static Scanner scanner = new Scanner(System.in);
       
       
	public static void main(String[] args) {
	         boolean exit = false;
	         
	         while(!exit){
	        	 System.out.println("1.List all users");
	        	 System.out.println("2.Add new user");
	        	 System.out.println("3.Update user");
	        	 System.out.println("4.Delete user");
	        	 System.out.println("5.Exit");
	        	 System.out.println("Enter your choice");
	        	 int choice = scanner.nextInt();
	        	 
	        	 switch(choice){
	        	 case 1:
	        		 listAllUsers();
	        		 break;
	        	 case 2:
	        		 addUser();
	        		 break;
	        	 case 3:
	        		 updateUser();
	        		 break;
	        	 case 4:
	        		 deleteUser();
	        		 break;
	        	 case 5:
	        		 exit = true;
	        		 break;
	        		 default:
	        			 System.out.println("Invalice choice please try again");
	        	 }
	         }
				
		
	}


	private static void deleteUser() {
		System.out.println("Enter user id:");
		int userid = scanner.nextInt();
		userController.deleteUser(userid);
		System.out.println("User deleted successfully!");
		
	}


	private static void updateUser() {
		System.out.println("Enter user id:");
		int userId = scanner.nextInt();
		System.out.println("Enter new user name:");
		String userName = scanner.next();
		System.out.println("Enter new e-mail id");
		String userEmail = scanner.next();
		userController.updateUser(userId,userName,userEmail);
		System.out.println("User updated successfully");
	}

	private static void addUser() {
		System.out.println("Enter user id: ");
		int id = scanner.nextInt();
		System.out.println("Enter user name");
		String username = scanner.next();
		System.out.println("Enter E-mail id");
		String email = scanner.next();
		userController.addUser(id,username,email);
		System.out.println("User added successfully");		
	}


	private static void listAllUsers() {
	
            List<User> users  = userController.getAllUsers();
            System.out.println(users.size());
        
		System.out.println("Liste of users:");
		  
		for(User user:users){
			System.out.println(user.getId()+","+user.getUserName()+","+user.getEmail());
		}
		
		
	}

}






