package com.curd.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.curd.dao.UserDao;
import com.curd.entity.User;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		System.out.println("******************************************");
		System.out.println("          CURD OPERATION      ");
		System.out.println("******************************************");
		
		
		while(true){
			
			System.out.println("Press 1. : Insert User");
			System.out.println("Press 2. : Update User");
			System.out.println("Press 3. : Delete User");
			System.out.println("Press 4. : Show User");
			System.out.println("Press 5. : EXIT");
			
			int choice = Integer.parseInt(br.readLine());
			System.out.println("******************************************");
			
			switch(choice) {
			
			case 1:
				System.out.println("Enter Name: ");
				String name = br.readLine();
				
				System.out.println("Enter City: ");
				String city = br.readLine();
				
				System.out.println("Enter Course: ");
				String course = br.readLine();
				
				User user = new User(name, course, city);
				
				UserDao.insertUser(user);
				
				System.out.println("--------------------------------");
				System.out.println("Registered successfully..");
				System.out.println("Name: "+user.getUserName());
				System.out.println("City: "+user.getUserCity());
				System.out.println("Course: "+user.getUserCourse());
				System.out.println("******************************************");
				
				break;
				
			case 2:
				System.out.println("Enter user-id: ");
				int id = Integer.parseInt(br.readLine());
				
				UserDao.updateUser(id);
				System.out.println("--------------------------------");
				System.out.println("Updated successfully..");
				System.out.println("******************************************");
				
				break;
				
			case 3:
				System.out.println("Enter user-id: ");
				int userId = Integer.parseInt(br.readLine());
				
				UserDao.deleteUser(userId);
				System.out.println("--------------------------------");
				System.out.println("Deleted successfully..");
				System.out.println("******************************************");
				
				break;
				
			case 4:
				System.out.println("Enter user-id: ");
				userId = Integer.parseInt(br.readLine());
				
				UserDao.showUserDetails(userId);
				
				break;
				
			case 5:
				System.out.println("   See you Again!..");
				System.out.println("******************************************");
				return;
		}
	 }
	}
}
