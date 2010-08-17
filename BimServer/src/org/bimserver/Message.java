package org.bimserver;

public enum Message {
	PASSWORD_SUCCESFULLY_CHANGED("Password succesfully changed");
	
	private final String message;

	Message(String message) {
		this.message = message;
	}
	
	public static String get(int id) {
		return values()[id].message;
	}
}