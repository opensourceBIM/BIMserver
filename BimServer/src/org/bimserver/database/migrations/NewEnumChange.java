package org.bimserver.database.migrations;

import org.bimserver.database.Database;
import org.bimserver.database.DatabaseSession;
import org.eclipse.emf.ecore.EEnum;

public class NewEnumChange implements Change {

	public NewEnumChange(EEnum eEnum) {
	}

	@Override
	public void change(Database database, DatabaseSession databaseSession) {
	}
}
