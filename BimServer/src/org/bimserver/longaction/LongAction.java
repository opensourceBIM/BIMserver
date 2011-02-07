package org.bimserver.longaction;

import java.util.Date;

import org.bimserver.database.store.User;

public abstract class LongAction {

	private Date start;

	public LongAction() {
		start = new Date();
	}
	
	public abstract void execute();

	public abstract String getIdentification();
	
	public abstract User getUser();
	
	public void waitForCompletion() {
		
	}

	public Date getStart() {
		return start;
	}
}