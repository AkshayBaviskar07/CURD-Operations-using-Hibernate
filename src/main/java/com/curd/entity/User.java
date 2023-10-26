package com.curd.entity;

import java.util.Random;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_details")
public class User {
	
	@Id
	private int userId;
	private String userName;
	private String userCourse;
	private String userCity;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String userName, String userCourse, String userCity) {
		super();
		this.userId = new Random().nextInt(1000);
		this.userName = userName;
		this.userCourse = userCourse;
		this.userCity = userCity;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserCourse() {
		return userCourse;
	}

	public void setUserCourse(String userCourse) {
		this.userCourse = userCourse;
	}

	public String getUserCity() {
		return userCity;
	}

	public void setUserCity(String userCity) {
		this.userCity = userCity;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userCourse=" + userCourse + ", userCity="
				+ userCity + "]";
	}
	
	

}
