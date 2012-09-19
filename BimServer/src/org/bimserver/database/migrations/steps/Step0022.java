package org.bimserver.database.migrations.steps;

import org.bimserver.database.migrations.Migration;
import org.bimserver.database.migrations.Schema;
import org.bimserver.database.migrations.Schema.Multiplicity;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EcorePackage;

public class Step0022 extends Migration {

	@Override
	public void migrate(Schema schema) {
		EClass serviceInterface = schema.createEClass("store", "ServiceInterface");
		schema.createEAttribute(serviceInterface, "name", EcorePackage.eINSTANCE.getEString(), Multiplicity.SINGLE);
		
		EClass serviceMethod = schema.createEClass("store", "ServiceMethod");
		schema.createEAttribute(serviceMethod, "name", EcorePackage.eINSTANCE.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(serviceMethod, "doc", EcorePackage.eINSTANCE.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(serviceMethod, "returnDoc", EcorePackage.eINSTANCE.getEString(), Multiplicity.SINGLE);

		EClass serviceField = schema.createEClass("store", "ServiceField");
		EClass serviceType = schema.createEClass("store", "ServiceType");

		schema.createEAttribute(serviceField, "name", EcorePackage.eINSTANCE.getEString(), Multiplicity.SINGLE);
		schema.createEReference(serviceField, "type", serviceType, Multiplicity.SINGLE).getEAnnotations().add(createEmbedsReference());
		schema.createEReference(serviceField, "genericType", serviceType, Multiplicity.SINGLE).getEAnnotations().add(createEmbedsReference());
		schema.createEAttribute(serviceField, "doc", EcorePackage.eINSTANCE.getEString(), Multiplicity.SINGLE);
		
		schema.createEAttribute(serviceType, "name", EcorePackage.eINSTANCE.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(serviceType, "simpleName", EcorePackage.eINSTANCE.getEString(), Multiplicity.SINGLE);
		schema.createEReference(serviceType, "fields", serviceField, Multiplicity.MANY).getEAnnotations().add(createEmbedsReference());

		EClass serviceParameter = schema.createEClass("store", "ServiceParameter");
		schema.createEAttribute(serviceParameter, "name", EcorePackage.eINSTANCE.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(serviceParameter, "doc", EcorePackage.eINSTANCE.getEString(), Multiplicity.SINGLE);
		schema.createEReference(serviceParameter, "type", serviceType, Multiplicity.SINGLE).getEAnnotations().add(createEmbedsReference());
		schema.createEReference(serviceParameter, "genericType", serviceType, Multiplicity.SINGLE).getEAnnotations().add(createEmbedsReference());
	}

	@Override
	public String getDescription() {
		return "Provides meta data";
	}
}