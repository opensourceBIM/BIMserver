package org.bimserver.database.migrations;

import org.bimserver.database.Database;
import org.eclipse.emf.ecore.EcorePackage;

public abstract class Migration {
	
	public EcorePackage ecorePackage = EcorePackage.eINSTANCE;

	public abstract void migrate(Schema schema);

	public void upgrade(Database database) {
	}
	
	public abstract String getDescription();
}