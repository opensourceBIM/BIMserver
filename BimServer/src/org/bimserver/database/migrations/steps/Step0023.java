package org.bimserver.database.migrations.steps;

import org.bimserver.database.migrations.Migration;
import org.bimserver.database.migrations.Schema;
import org.bimserver.database.migrations.Schema.Multiplicity;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

public class Step0023 extends Migration {

	@Override
	public void migrate(Schema schema) {
		EClass revisionClass = schema.getEClass("store", "Revision");
		EClass projectClass = schema.getEClass("store", "Project");
		EClass extendedDataClass = schema.getEClass("store", "ExtendedData");
		EClass logActionClass = schema.getEClass("log", "LogAction");
		EPackage logPackage = schema.getEPackage("log");
		
		EClass extendedDataAddedToRevision = schema.createEClass(logPackage, "ExtendedDataAddedToRevision", logActionClass);
		schema.createEReference(extendedDataAddedToRevision, "revision", revisionClass, Multiplicity.SINGLE);
		schema.createEReference(extendedDataAddedToRevision, "extendedData", extendedDataClass, Multiplicity.SINGLE);
		
		EClass extendedDataAddedToProject = schema.createEClass(logPackage, "ExtendedDataAddedToProject", logActionClass);
		schema.createEReference(extendedDataAddedToProject, "project", projectClass, Multiplicity.SINGLE);
		schema.createEReference(extendedDataAddedToProject, "extendedData", extendedDataClass, Multiplicity.SINGLE);
	}

	@Override
	public String getDescription() {
		return null;
	}
}
