package com.ssafy.ws.step5.dto;

public class User {
	//코드를 작성하세요.
	private int userSeq;
	private String userId;
	private String password;
	private String userName;
	private String nickName;
	private String email;
	
	public User(int userSeq, String userId, String userName, String nickName, String email, String password) {
		super();
		this.userSeq = userSeq;
		this.userId = userId;
		this.userName = userName;
		this.nickName = nickName;
		this.password = password;
		this.email = email;
	}
	public User() {
		super();
	}
	//getter setter
	public int getUserSeq() {
		return userSeq;
	}
	public void setUserSeq(int userSeq) {
		this.userSeq = userSeq;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
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
	public void setPassword(String Password) {
		this.password = Password;
	}
	
}
