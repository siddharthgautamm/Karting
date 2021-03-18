package kart.model;

//Admin model class
public class Admin {

	private static String userName;
	private static String password;

	static {
		userName = "admin";
		password = "admin";
	}

	public String getPassword() {
		return "admin";
	}

	public String getUserName() {
		return "admin";
	}

}
