package com.curd.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.curd.entity.User;
import com.curd.helper.FactoryProvider;

public class UserDao {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static Session session = FactoryProvider.getFactory().openSession();
	
	public static void insertUser(User user) {
		
		Transaction transaction = session.beginTransaction();
		
		session.save(user);
		transaction.commit();
		
		session.close();
		FactoryProvider.closeFactory();		
	}

	public static void updateUser(int id) throws IOException {
		
		User user = session.get(User.class, id);
		
		System.out.println("Name: "+user.getUserName());
		System.out.println("City: "+user.getUserCity());
		System.out.println("Course: "+user.getUserCourse());
		
		System.out.println("=======================================");
		
		System.out.println("Name: ");
		String userName = br.readLine();
		System.out.println("City: ");
		String userCity = br.readLine();
		System.out.println("Course: ");
		String userCourse = br.readLine();
		
		user.setUserName(userName);
		user.setUserCity(userCity);
		user.setUserCourse(userCourse);
		
		Transaction transaction = session.beginTransaction();
		session.save(user);
		
		transaction.commit();
		session.close();
		FactoryProvider.closeFactory();
		
	}

	public static void deleteUser(int id) {
		
		User user = session.get(User.class, id);
		
		if(user != null) {
			Transaction transaction = session.beginTransaction();
			session.delete(user);
			
			transaction.commit();
			session.close();
			FactoryProvider.closeFactory();	
			
		} else {
			System.out.println("User Not Found!");
		}			
	}

	public static void showUserDetails(int userId) {
		
		User user = session.get(User.class, userId);
		
		System.out.println("Name: "+user.getUserName());
		System.out.println("City: "+user.getUserCity());
		System.out.println("Course: "+user.getUserCourse());
		
		session.close();
		FactoryProvider.closeFactory();
		
		System.out.println("******************************************");		
	}
}
