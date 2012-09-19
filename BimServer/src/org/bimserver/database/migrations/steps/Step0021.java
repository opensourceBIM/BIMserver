package org.bimserver.database.migrations.steps;

import org.bimserver.database.migrations.Migration;
import org.bimserver.database.migrations.Schema;
import org.bimserver.database.migrations.Schema.Multiplicity;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

public class Step0021 extends Migration {

	@Override
	public void migrate(Schema schema) {
		EClass externalServer = schema.createEClass(schema.getEPackage("store"), "ExternalServer");
		schema.createEAttribute(externalServer, "title", EcorePackage.eINSTANCE.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(externalServer, "url", EcorePackage.eINSTANCE.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(externalServer, "description", EcorePackage.eINSTANCE.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(externalServer, "token", EcorePackage.eINSTANCE.getEString(), Multiplicity.SINGLE);
		EClass userClass = schema.getEClass("store", "User");
		EReference userExternalServer = schema.createEReference(externalServer, "user", userClass, Multiplicity.SINGLE);
		EReference serverUser = schema.createEReference(userClass, "servers", externalServer, Multiplicity.MANY);
		
		userExternalServer.setEOpposite(serverUser);
		serverUser.setEOpposite(userExternalServer);

		EClass externalProfile = schema.createEClass("store", "ExternalProfile");
		EReference externalServerProfiles = schema.createEReference(externalServer, "profiles", externalProfile, Multiplicity.MANY);
		EReference externalProfileServer = schema.createEReference(externalProfile, "server", externalServer, Multiplicity.SINGLE);

		externalServerProfiles.setEOpposite(externalProfileServer);
		externalProfileServer.setEOpposite(externalServerProfiles);
		
		schema.createEAttribute(externalProfile, "name", EcorePackage.eINSTANCE.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(externalProfile, "description", EcorePackage.eINSTANCE.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(externalProfile, "readRevision", EcorePackage.eINSTANCE.getEBoolean(), Multiplicity.SINGLE);
		schema.createEAttribute(externalProfile, "readExtendedData", EcorePackage.eINSTANCE.getEBoolean(), Multiplicity.SINGLE);
		schema.createEReference(externalProfile, "writeRevision", schema.getEClass("store", "Project"), Multiplicity.SINGLE);
		schema.createEReference(externalProfile, "writeExtendedData", schema.getEClass("store", "Project"), Multiplicity.SINGLE);
		EReference externalProfileProject = schema.createEReference(externalProfile, "project", schema.getEClass("store", "Project"), Multiplicity.SINGLE);
		EReference projectProfiles = schema.createEReference(schema.getEClass("store", "Project"), "profiles", externalProfile, Multiplicity.MANY);
		
		externalProfileProject.setEOpposite(projectProfiles);
		projectProfiles.setEOpposite(externalProfileProject);
		
		EClass serverSettings = schema.getEClass("store", "ServerSettings");
		schema.createEAttribute(serverSettings, "serviceRepositoryUrl", EcorePackage.eINSTANCE.getEString(), Multiplicity.SINGLE);
		
		schema.createEAttribute(schema.getEClass("store", "ExtendedData"), "mime", EcorePackage.eINSTANCE.getEString(), Multiplicity.SINGLE);
		
		EClass tokenClass = schema.createEClass("store", "Token");
		schema.createEAttribute(tokenClass, "tokenString", EcorePackage.eINSTANCE.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(tokenClass, "expires", EcorePackage.eINSTANCE.getELong(), Multiplicity.SINGLE);
	}

	@Override
	public String getDescription() {
		return "New classes for external servers";
	}
}