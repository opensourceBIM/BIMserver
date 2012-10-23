package org.bimserver.database.migrations.steps;

import org.bimserver.database.migrations.Migration;
import org.bimserver.database.migrations.Schema;
import org.bimserver.database.migrations.Schema.Multiplicity;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EcorePackage;

public class Step0024 extends Migration {

	@Override
	public void migrate(Schema schema) {
		EEnum primitiveEnum = schema.createEEnum("store", "PrimitiveEnum");
		schema.createEEnumLiteral(primitiveEnum, "LONG");
		schema.createEEnumLiteral(primitiveEnum, "DOUBLE");
		schema.createEEnumLiteral(primitiveEnum, "BOOLEAN");
		schema.createEEnumLiteral(primitiveEnum, "STRING");

		EClass typeDefinition = schema.createEClass("store", "TypeDefinition");
		typeDefinition.getEAnnotations().add(createNoDatabaseAnnotation());
		EClass objectDefinition = schema.createEClass("store", "ObjectDefinition", typeDefinition);
		objectDefinition.getEAnnotations().add(createNoDatabaseAnnotation());
		EClass primitiveDefinition = schema.createEClass("store", "PrimitiveDefinition", typeDefinition);
		primitiveDefinition.getEAnnotations().add(createNoDatabaseAnnotation());
		EClass arrayDefinition = schema.createEClass("store", "ArrayDefinition", typeDefinition);
		arrayDefinition.getEAnnotations().add(createNoDatabaseAnnotation());
		EClass parameterDefinition = schema.createEClass("store", "ParameterDefinition");
		parameterDefinition.getEAnnotations().add(createNoDatabaseAnnotation());
		
		schema.createEAttribute(parameterDefinition, "name", EcorePackage.eINSTANCE.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(parameterDefinition, "required", EcorePackage.eINSTANCE.getEBoolean(), Multiplicity.SINGLE);
		schema.createEReference(parameterDefinition, "type", typeDefinition, Multiplicity.SINGLE).getEAnnotations().add(createEmbedsReferenceAnnotation());
		
		schema.createEReference(objectDefinition, "parameters", parameterDefinition, Multiplicity.MANY).getEAnnotations().add(createEmbedsReferenceAnnotation());
		
		schema.createEAttribute(primitiveDefinition, "type", primitiveEnum, Multiplicity.SINGLE);
		
		schema.createEReference(arrayDefinition, "type", typeDefinition, Multiplicity.SINGLE).getEAnnotations().add(createEmbedsReferenceAnnotation());
		
		EClass type = schema.createEClass("store", "Type");
		EClass objectType = schema.createEClass("store", "ObjectType", type);
		EClass primitiveType = schema.createEClass("store", "PrimitiveType", type);
		EClass longType = schema.createEClass("store", "LongType", primitiveType);
		EClass doubleType = schema.createEClass("store", "DoubleType", primitiveType);
		EClass stringType = schema.createEClass("store", "StringType", primitiveType);
		EClass booleanType = schema.createEClass("store", "BooleanType", primitiveType);
		EClass arrayType = schema.createEClass("store", "ArrayType", type);
		EClass parameter = schema.createEClass("store", "Parameter");
		
		schema.createEAttribute(objectType, "name", EcorePackage.eINSTANCE.getEString(), Multiplicity.SINGLE);
		schema.createEReference(objectType, "parameters", parameter, Multiplicity.MANY).getEAnnotations().add(createEmbedsReferenceAnnotation());
		schema.createEAttribute(parameter, "name", EcorePackage.eINSTANCE.getEString(), Multiplicity.SINGLE);
		schema.createEReference(parameter, "value", type, Multiplicity.SINGLE).getEAnnotations().add(createEmbedsReferenceAnnotation());

		schema.createEReference(parameterDefinition, "defaultValue", type, Multiplicity.SINGLE);
		
		schema.createEReference(arrayType, "values", type, Multiplicity.MANY).getEAnnotations().add(createEmbedsReferenceAnnotation());
		
		schema.createEAttribute(longType, "value", EcorePackage.eINSTANCE.getELong(), Multiplicity.SINGLE);
		schema.createEAttribute(doubleType, "value", EcorePackage.eINSTANCE.getEDouble(), Multiplicity.SINGLE);
		schema.createEAttribute(stringType, "value", EcorePackage.eINSTANCE.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(booleanType, "value", EcorePackage.eINSTANCE.getEBoolean(), Multiplicity.SINGLE);
		
		schema.createEReference(schema.getEClass("store", "PluginConfiguration"), "settings", objectType, Multiplicity.SINGLE);
	}

	@Override
	public String getDescription() {
		return "blabla";
	}
}
