package org.bimserver.database.berkeley;

import com.sleepycat.je.Database;

public class TableWrapper {
	private Database database;
	private boolean transactional;

	public TableWrapper(Database database, boolean transactional) {
		this.database = database;
		this.transactional = transactional;
	}
	
	public boolean isTransactional() {
		return transactional;
	}
	
	public Database getDatabase() {
		return database;
	}
}
