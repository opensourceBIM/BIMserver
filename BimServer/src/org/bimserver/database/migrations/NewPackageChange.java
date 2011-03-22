package org.bimserver.database.migrations;

import org.bimserver.database.Database;
import org.bimserver.database.DatabaseSession;
import org.eclipse.emf.ecore.EPackage;

public class NewPackageChange implements Change {

	public NewPackageChange(EPackage ePackage) {
	}

	@Override
	public void change(Database database, DatabaseSession databaseSession) {
	}
}