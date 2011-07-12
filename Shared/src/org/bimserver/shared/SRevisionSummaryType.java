package org.bimserver.shared;

public class SRevisionSummaryType {
	private String name;
	private int count;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public void increment(int count) {
		this.count += count;
	}
}
