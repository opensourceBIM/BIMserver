package org.bimserver.database.migrations.steps;

import org.bimserver.database.DatabaseSession;
import org.bimserver.database.migrations.Migration;
import org.bimserver.database.migrations.Schema;
import org.bimserver.database.migrations.Schema.Multiplicity;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EcorePackage;

public class Step0025 extends Migration {

	@Override
	public void migrate(Schema schema, DatabaseSession databaseSession) {
		EClass newServiceDescriptor = schema.createEClass("store", "NewServiceDescriptor");
		schema.createEAttribute(newServiceDescriptor, "name", EcorePackage.eINSTANCE.getEString());
		schema.createEAttribute(newServiceDescriptor, "description", EcorePackage.eINSTANCE.getEString());
		schema.createEAttribute(newServiceDescriptor, "provider", EcorePackage.eINSTANCE.getEString());
		schema.createEAttribute(newServiceDescriptor, "inputs", EcorePackage.eINSTANCE.getEString(), Multiplicity.MANY);
		schema.createEAttribute(newServiceDescriptor, "outputs", EcorePackage.eINSTANCE.getEString(), Multiplicity.MANY);
		
		EClass formatSerializerMap = schema.createEClass("store", "FormatSerializerMap");
		schema.createEAttribute(formatSerializerMap, "format", EcorePackage.eINSTANCE.getEString());
		schema.createEReference(formatSerializerMap, "serializers", schema.getEClass("store", "SerializerPluginConfiguration"), Multiplicity.MANY).getEAnnotations().add(createEmbedsReferenceAnnotation());
	}

	@Override
	public String getDescription() {
		return "New Service Interface";
	}
}