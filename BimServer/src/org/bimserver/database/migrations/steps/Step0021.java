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
		
		EClass profileDescriptor = schema.createEClass(schema.getEPackage("store"), "ProfileDescriptor");
		profileDescriptor.getEAnnotations().add(createNoDatabaseAnnotation());
		schema.createEAttribute(profileDescriptor, "name", EcorePackage.eINSTANCE.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(profileDescriptor, "description", EcorePackage.eINSTANCE.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(profileDescriptor, "publicProfile", EcorePackage.eINSTANCE.getEBoolean(), Multiplicity.SINGLE);
		schema.createEAttribute(profileDescriptor, "identifier", EcorePackage.eINSTANCE.getEString(), Multiplicity.SINGLE);

		EClass serviceDescriptor = schema.createEClass(schema.getEPackage("store"), "ServiceDescriptor");
		serviceDescriptor.getEAnnotations().add(createNoDatabaseAnnotation());
		schema.createEAttribute(serviceDescriptor, "name", EcorePackage.eINSTANCE.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(serviceDescriptor, "url", EcorePackage.eINSTANCE.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(serviceDescriptor, "token", EcorePackage.eINSTANCE.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(serviceDescriptor, "identifier", EcorePackage.eINSTANCE.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(serviceDescriptor, "notificationProtocol", schema.getEEnum("log", "AccessMethod"), Multiplicity.SINGLE);
		schema.createEAttribute(serviceDescriptor, "description", EcorePackage.eINSTANCE.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(serviceDescriptor, "trigger", trigger, Multiplicity.SINGLE);
		schema.createEAttribute(serviceDescriptor, "readRevision", EcorePackage.eINSTANCE.getEBoolean(), Multiplicity.SINGLE);
		schema.createEAttribute(serviceDescriptor, "readExtendedData", EcorePackage.eINSTANCE.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(serviceDescriptor, "writeRevision", EcorePackage.eINSTANCE.getEBoolean(), Multiplicity.SINGLE);
		schema.createEAttribute(serviceDescriptor, "writeExtendedData", EcorePackage.eINSTANCE.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(serviceDescriptor, "providerName", EcorePackage.eINSTANCE.getEString(), Multiplicity.SINGLE);
		
		EClass service = schema.createEClass("store", "Service");
		schema.createEAttribute(service, "name", EcorePackage.eINSTANCE.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(service, "serviceName", EcorePackage.eINSTANCE.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(service, "serviceIdentifier", EcorePackage.eINSTANCE.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(service, "providerName", EcorePackage.eINSTANCE.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(service, "url", EcorePackage.eINSTANCE.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(service, "token", EcorePackage.eINSTANCE.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(service, "notificationProtocol", schema.getEEnum("log", "AccessMethod"), Multiplicity.SINGLE);
		schema.createEAttribute(service, "description", EcorePackage.eINSTANCE.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(service, "trigger", trigger, Multiplicity.SINGLE);
		schema.createEAttribute(service, "readRevision", EcorePackage.eINSTANCE.getEBoolean(), Multiplicity.SINGLE);
		schema.createEReference(service, "readExtendedData", schema.getEClass("store", "ExtendedDataSchema"), Multiplicity.SINGLE);
		schema.createEReference(service, "writeRevision", project, Multiplicity.SINGLE);
		schema.createEReference(service, "writeExtendedData", schema.getEClass("store", "ExtendedDataSchema"), Multiplicity.SINGLE);
		schema.createEAttribute(service, "profileIdentifier", EcorePackage.eINSTANCE.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(service, "profileName", EcorePackage.eINSTANCE.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(service, "profileDescription", EcorePackage.eINSTANCE.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(service, "profilePublic", EcorePackage.eINSTANCE.getEBoolean(), Multiplicity.SINGLE);
		
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
		
		EClass tokenClass = schema.createEClass("store", "Token");
		schema.createEAttribute(tokenClass, "tokenString", EcorePackage.eINSTANCE.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(tokenClass, "expires", EcorePackage.eINSTANCE.getELong(), Multiplicity.SINGLE);
		
		schema.createEClass(schema.getEPackage("store"), "ServicePluginDescriptor", schema.getEClass("store", "PluginDescriptor"));
		
		EClass internalServicePluginClass = schema.createEClass(schema.getEPackage("store"), "InternalServicePluginConfiguration", schema.getEClass("store", "PluginConfiguration"));
		schema.createEAttribute(internalServicePluginClass, "remoteAccessible", EcorePackage.eINSTANCE.getEBoolean(), Multiplicity.SINGLE);
		EClass userSettingsClass = schema.getEClass("store", "UserSettings");
		
		schema.createEReference(service, "internalService", schema.getEClass("store", "InternalServicePluginConfiguration"), Multiplicity.SINGLE);

		EReference serviceSettingsReference = schema.createEReference(internalServicePluginClass, "userSettings", userSettingsClass, Multiplicity.SINGLE);
		EReference settingsServicesReference = schema.createEReference(userSettingsClass, "services", internalServicePluginClass, Multiplicity.MANY);
		
		serviceSettingsReference.setEOpposite(settingsServicesReference);
		settingsServicesReference.setEOpposite(serviceSettingsReference);
	}

	@Override
	public String getDescription() {
		return "New classes for external servers";
	}
}