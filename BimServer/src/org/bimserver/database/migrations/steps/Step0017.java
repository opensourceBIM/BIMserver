package org.bimserver.database.migrations.steps;

import org.bimserver.database.migrations.Migration;
import org.bimserver.database.migrations.Schema;
import org.bimserver.database.migrations.Schema.Multiplicity;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

public class Step0017 extends Migration {

	@Override
	public void migrate(Schema schema) {
		EEnum extendedDataSchemaType = schema.createEEnum(schema.getEPackage("store"), "ExtendedDataSchemaType");
		schema.createEEnumLiteral(extendedDataSchemaType, "XSD");
		schema.createEEnumLiteral(extendedDataSchemaType, "PDF");
		schema.createEEnumLiteral(extendedDataSchemaType, "TXT");
		
		EClass file = schema.createEClass("store", "File");
		schema.createEAttribute(file, "data", EcorePackage.eINSTANCE.getEByteArray(), Multiplicity.SINGLE);
		schema.createEAttribute(file, "filename", EcorePackage.eINSTANCE.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(file, "mime", EcorePackage.eINSTANCE.getEString(), Multiplicity.SINGLE);
		
		EClass extendedDataSchemaClass = schema.createEClass(schema.getEPackage("store"), "ExtendedDataSchema");
		schema.createEAttribute(extendedDataSchemaClass, "name", EcorePackage.eINSTANCE.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(extendedDataSchemaClass, "url", EcorePackage.eINSTANCE.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(extendedDataSchemaClass, "namespace", EcorePackage.eINSTANCE.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(extendedDataSchemaClass, "description", EcorePackage.eINSTANCE.getEString(), Multiplicity.SINGLE);
		schema.createEReference(extendedDataSchemaClass, "file", file, Multiplicity.SINGLE);
		schema.createEAttribute(extendedDataSchemaClass, "size", EcorePackage.eINSTANCE.getELong(), Multiplicity.SINGLE);
		schema.createEAttribute(extendedDataSchemaClass, "validate", EcorePackage.eINSTANCE.getEBoolean(), Multiplicity.SINGLE);
		schema.createEAttribute(extendedDataSchemaClass, "type", extendedDataSchemaType, Multiplicity.SINGLE);
		
		EClass extendedDataClass = schema.createEClass(schema.getEPackage("store"), "ExtendedData");
		schema.createEAttribute(extendedDataClass, "url", EcorePackage.eINSTANCE.getEString(), Multiplicity.SINGLE);
		schema.createEReference(extendedDataClass, "file", file, Multiplicity.SINGLE);
		schema.createEAttribute(extendedDataClass, "size", EcorePackage.eINSTANCE.getELong(), Multiplicity.SINGLE);
		schema.createEAttribute(extendedDataClass, "title", EcorePackage.eINSTANCE.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(extendedDataClass, "added", EcorePackage.eINSTANCE.getEDate(), Multiplicity.SINGLE);
		
		EClass userClass = schema.getEClass("store", "User");
		EReference userToExtendedDataSchema = schema.createEReference(userClass, "schemas", extendedDataSchemaClass, Multiplicity.MANY);
		EReference extendedDataSchemaToUser = schema.createEReference(extendedDataSchemaClass, "users", userClass, Multiplicity.MANY);
		userToExtendedDataSchema.setEOpposite(extendedDataSchemaToUser);
		extendedDataSchemaToUser.setEOpposite(userToExtendedDataSchema);

		EReference extendedDataToUser = schema.createEReference(extendedDataClass, "user", userClass, Multiplicity.SINGLE);
		EReference userToExtendedData = schema.createEReference(userClass, "extendedData", extendedDataClass, Multiplicity.MANY);
		extendedDataToUser.setEOpposite(userToExtendedData);
		userToExtendedData.setEOpposite(extendedDataToUser);
		
		EReference extendedDataToExtendedDataSchema = schema.createEReference(extendedDataClass, "schema", extendedDataSchemaClass, Multiplicity.SINGLE);
		EReference extendedDataSchemaToExtendedData = schema.createEReference(extendedDataSchemaClass, "extendedData", extendedDataClass, Multiplicity.MANY);
		extendedDataToExtendedDataSchema.setEOpposite(extendedDataSchemaToExtendedData);
		extendedDataSchemaToExtendedData.setEOpposite(extendedDataToExtendedDataSchema);
		
		EClass revisionClass = schema.getEClass("store", "Revision");
		
		EReference revisionExtendedData = schema.createEReference(revisionClass, "extendedData", extendedDataClass, Multiplicity.MANY);
		EReference extendedDataRevision = schema.createEReference(extendedDataClass, "revision", revisionClass, Multiplicity.SINGLE);
		
		revisionExtendedData.setEOpposite(extendedDataRevision);
		extendedDataRevision.setEOpposite(revisionExtendedData);
		
		EClass projectClass = schema.getEClass("store", "Project");
		
		EReference projectExtendedData = schema.createEReference(projectClass, "extendedData", extendedDataClass, Multiplicity.MANY);
		EReference extendedDataProject = schema.createEReference(extendedDataClass, "project", projectClass, Multiplicity.SINGLE);
		
		projectExtendedData.setEOpposite(extendedDataProject);
		extendedDataProject.setEOpposite(projectExtendedData);
	}

	@Override
	public String getDescription() {
		return "Adding classes for extended data";
	}
}