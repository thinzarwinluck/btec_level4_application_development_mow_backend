package com.dev.mealsOnWheel.payload;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class Register {
	
private String experience;
	
	private Boolean work_type;
	
	private String previous_work;
	
	private String user_profile;
	@NotBlank
	private String userName;
	
	@Email
	@NotBlank
	private String email; 
	
	@NotBlank
	private String password;
	
	@NotBlank
	private String age;
	
	@NotBlank
	private int latitude;
	
	@NotBlank
	private int longitude;
	
	
	
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public int getLatitude() {
		return latitude;
	}
	public void setLatitude(int latitude) {
		this.latitude = latitude;
	}
	public int getLongitude() {
		return longitude;
	}
	public void setLongitude(int longitude) {
		this.longitude = longitude;
	}
	public String getExperience() {
		return experience;
	}
	public void setExperience(String experience) {
		this.experience = experience;
	}
	public Boolean getWork_type() {
		return work_type;
	}
	public void setWork_type(Boolean work_type) {
		this.work_type = work_type;
	}
	public String getPrevious_work() {
		return previous_work;
	}
	public void setPrevious_work(String previous_work) {
		this.previous_work = previous_work;
	}
	public String getUser_profile() {
		return user_profile;
	}
	public void setUser_profile(String user_profile) {
		this.user_profile = user_profile;
	}
	
	
	
	
	
	
	
	
	
	
	
}
