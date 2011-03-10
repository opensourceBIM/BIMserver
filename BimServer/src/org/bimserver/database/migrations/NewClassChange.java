package org.bimserver.database.migrations;

import org.bimserver.database.BimDeadlockException;
import org.bimserver.database.Database;
import org.bimserver.database.DatabaseSession;
import org.eclipse.emf.ecore.EClass;

public class NewClassChange implements Change {

	private final EClass eClass;

	public NewClassChange(EClass eClass) {
		this.eClass = eClass;
	}

	@Override
	public void change(Database database, DatabaseSession databaseSession) {
		try {
			database.createTableIfNotExists(eClass, databaseSession);
		} catch (BimDeadlockException e) {
			e.printStackTrace();
		}
	}
}