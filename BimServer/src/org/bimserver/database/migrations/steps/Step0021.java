package org.bimserver.database.migrations.steps;

import org.bimserver.database.migrations.Migration;
import org.bimserver.database.migrations.Schema;
import org.bimserver.database.migrations.Schema.Multiplicity;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

public class Step0021 extends Migration {

	@Override
	public void migrate(Schema schema) {
		EClass user = schema.getEClass("store", "User");
		EClass project = schema.getEClass("store", "Project");

		EEnum trigger = schema.createEEnum("store", "Trigger");
		schema.createEEnumLiteral(trigger, "NEW_REVISION");
		schema.createEEnumLiteral(trigger, "NEW_PROJECT");
		
		EClass serverDescriptor = schema.createEClass(schema.getEPackage("store"), "ServerDescriptor");
		schema.createEAttribute(serverDescriptor, "title", EcorePackage.eINSTANCE.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(serverDescriptor, "url", EcorePackage.eINSTANCE.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(serverDescriptor, "description", EcorePackage.eINSTANCE.getEString(), Multiplicity.SINGLE);

		EClass service = schema.createEClass("store", "Service");
		schema.createEAttribute(service, "name", EcorePackage.eINSTANCE.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(service, "url", EcorePackage.eINSTANCE.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(service, "token", EcorePackage.eINSTANCE.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(service, "notificationProtocol", schema.getEEnum("log", "AccessMethod"), Multiplicity.SINGLE);
		schema.createEAttribute(service, "description", EcorePackage.eINSTANCE.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(service, "trigger", trigger, Multiplicity.SINGLE);
		schema.createEAttribute(service, "readRevision", EcorePackage.eINSTANCE.getEBoolean(), Multiplicity.SINGLE);
		schema.createEAttribute(service, "readExtendedData", EcorePackage.eINSTANCE.getEBoolean(), Multiplicity.SINGLE);
		schema.createEReference(service, "writeRevision", project, Multiplicity.SINGLE);
		schema.createEReference(service, "writeExtendedData", project, Multiplicity.SINGLE);
		
		EReference serviceProject = schema.createEReference(service, "project", project, Multiplicity.SINGLE);
		EReference projectServices = schema.createEReference(project, "services", service, Multiplicity.MANY);
		
		serviceProject.setEOpposite(projectServices);
		projectServices.setEOpposite(serviceProject);
		
		EReference serviceUser = schema.createEReference(service, "user", user, Multiplicity.SINGLE);
		EReference userServices = schema.createEReference(user, "services", service, Multiplicity.MANY);
		
		serviceUser.setEOpposite(userServices);
		userServices.setEOpposite(serviceUser);
		
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