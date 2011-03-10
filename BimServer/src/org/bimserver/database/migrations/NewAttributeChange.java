package org.bimserver.database.migrations;

import org.bimserver.database.BimDeadlockException;
import org.bimserver.database.ColumnDatabase;
import org.bimserver.database.Database;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.RecordIterator;
import org.eclipse.emf.ecore.EAttribute;

public class NewAttributeChange implements Change {

	private final EAttribute eAttribute;

	public NewAttributeChange(EAttribute eAttribute) {
		this.eAttribute = eAttribute;
	}

	@Override
	public void change(Database database, DatabaseSession databaseSession) {
		ColumnDatabase columnDatabase = database.getColumnDatabase();
		try {
			RecordIterator recordIterator = columnDatabase.getRecordIterator(eAttribute.getEContainingClass().getName(), databaseSession);
			recordIterator.
		} catch (BimDeadlockException e) {
			e.printStackTrace();
		}
	}
}