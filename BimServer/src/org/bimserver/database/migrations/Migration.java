package org.bimserver.database.migrations;

import org.bimserver.database.Database;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;

public abstract class Migration {
	
	public EcorePackage ecorePackage = EcorePackage.eINSTANCE;

	public abstract void migrate(Schema schema);

	public void upgrade(Database database) {
	}

	protected EAnnotation createEmbedsReference() {
		EAnnotation embedsReferenceAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
		embedsReferenceAnnotation.setSource("embedsreference");
		return embedsReferenceAnnotation;
	}
	
	public abstract String getDescription();
}