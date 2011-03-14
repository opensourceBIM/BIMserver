package org.bimserver.database.migrations;

import org.bimserver.database.Database;
import org.bimserver.database.DatabaseSession;
import org.eclipse.emf.ecore.EPackage;

public class NewPackageChange implements Change {

	private final EPackage ePackage;

	public NewPackageChange(EPackage ePackage) {
		this.ePackage = ePackage;
	}

	@Override
	public void change(Database database, DatabaseSession databaseSession) {
	}
}