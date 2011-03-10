package org.bimserver.database.migrations;

import org.bimserver.database.Database;
import org.eclipse.emf.ecore.EcorePackage;

public abstract class Migration {
	
	protected EcorePackage ecorePackage = EcorePackage.eINSTANCE;

	abstract void migrate(Schema schema);

	public void upgrade(Database database) {
		
	}
}