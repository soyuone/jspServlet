package com.song.jspservlet;

public class Dbbean {

	private String username;

	private String pass;

	public Dbbean() {
	}

	public Dbbean(String username, String pass) {
		this.username = username;
		this.pass = pass;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
}
