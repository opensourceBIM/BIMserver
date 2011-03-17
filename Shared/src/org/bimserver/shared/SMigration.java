package org.bimserver.shared;

public class SMigration {
	private int number;
	private String description;
	private boolean executed;

	public void setNumber(int number) {
		this.number = number;
	}

	public int getNumber() {
		return number;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public void setExecuted(boolean executed) {
		this.executed = executed;
	}

	public boolean isExecuted() {
		return executed;
	}
}
