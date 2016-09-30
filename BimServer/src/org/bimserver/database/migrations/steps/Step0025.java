package org.bimserver.database.migrations.steps;

import org.bimserver.database.DatabaseSession;
import org.bimserver.database.migrations.Migration;
import org.bimserver.database.migrations.Schema;
import org.bimserver.database.migrations.Schema.Multiplicity;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EcorePackage;

public class Step0025 extends Migration {

	@Override
	public void migrate(Schema schema, DatabaseSession databaseSession) {
		EClass newServiceDescriptor = schema.createEClass("store", "NewServiceDescriptor");
		schema.createEAttribute(newServiceDescriptor, "name", EcorePackage.eINSTANCE.getEString());
		schema.createEAttribute(newServiceDescriptor, "description", EcorePackage.eINSTANCE.getEString());
		schema.createEAttribute(newServiceDescriptor, "provider", EcorePackage.eINSTANCE.getEString());
		schema.createEAttribute(newServiceDescriptor, "url", EcorePackage.eINSTANCE.getEString());
		schema.createEAttribute(newServiceDescriptor, "inputs", EcorePackage.eINSTANCE.getEString(), Multiplicity.MANY);
		schema.createEAttribute(newServiceDescriptor, "outputs", EcorePackage.eINSTANCE.getEString(), Multiplicity.MANY);
		
		EClass formatSerializerMap = schema.createEClass("store", "FormatSerializerMap");
		schema.createEAttribute(formatSerializerMap, "format", EcorePackage.eINSTANCE.getEString());
		schema.createEReference(formatSerializerMap, "serializers", schema.getEClass("store", "SerializerPluginConfiguration"), Multiplicity.MANY).getEAnnotations().add(createEmbedsReferenceAnnotation());
		
		EClass actionClass = schema.createEClass("store", "Action");
		
		EClass storeExtendedDataClass = schema.createEClass("store", "StoreExtendedData", actionClass);

		EEnum serviceStatus = schema.createEEnum("store", "ServiceStatus");
		schema.createEEnumLiteral(serviceStatus, "NEW");
		schema.createEEnumLiteral(serviceStatus, "AUTHENTICATED");
		
		EClass newServiceClass = schema.createEClass("store", "NewService");
		schema.createEAttribute(newServiceClass, "name", EcorePackage.eINSTANCE.getEString());
		schema.createEAttribute(newServiceClass, "provider", EcorePackage.eINSTANCE.getEString());
		schema.createEAttribute(newServiceClass, "description", EcorePackage.eINSTANCE.getEString());
		schema.createEAttribute(newServiceClass, "url", EcorePackage.eINSTANCE.getEString());
		schema.createEAttribute(newServiceClass, "input", EcorePackage.eINSTANCE.getEString());
		schema.createEAttribute(newServiceClass, "oauthCode", EcorePackage.eINSTANCE.getEString());
		schema.createEAttribute(newServiceClass, "status", serviceStatus);
		schema.createEReference(newServiceClass, "serializer", schema.getEClass("store", "SerializerPluginConfiguration"));
		schema.createEAttribute(newServiceClass, "output", EcorePackage.eINSTANCE.getEString());
		schema.createEReference(newServiceClass, "action", actionClass);
		
		schema.createEReference(schema.getEClass("store", "Project"), "newServices", newServiceClass, Multiplicity.MANY);
	}

	@Override
	public String getDescription() {
		return "New Service Interface";
	}
}