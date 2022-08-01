package com.javatpoint.beans;

public class UserVO {
	private int id;  
	private String name;
	private String password;
	private String studentID;
	private String email;
	public UserVO() {
		
	}
	public UserVO(String name, String password) {
		super();
		this.name = name;
		this.password = password;
		this.studentID = "UNKNOWN";
		this.email = "UNKNOWN";
	}
	//generate getters and setters  
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getStudentID() {
		return studentID;
	}
	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}
}
