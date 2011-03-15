package org.bimserver.database.migrations;

import org.bimserver.database.BimDeadlockException;
import org.bimserver.database.Database;
import org.bimserver.database.DatabaseSession;
import org.eclipse.emf.ecore.EClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NewClassChange implements Change {

	private static final Logger LOGGER = LoggerFactory.getLogger(NewClassChange.class);
	private final EClass eClass;

	public NewClassChange(EClass eClass) {
		this.eClass = eClass;
	}

	@Override
	public void change(Database database, DatabaseSession databaseSession) {
		try {
			LOGGER.info("Creating table: " + getEClass().getName());
			database.createTableIfNotExists(getEClass(), databaseSession);
		} catch (BimDeadlockException e) {
			e.printStackTrace();
		}
	}

	public EClass getEClass() {
		return eClass;
	}
}