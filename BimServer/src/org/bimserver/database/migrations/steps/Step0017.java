package org.bimserver.database.migrations.steps;

/******************************************************************************
 * Copyright (C) 2009-2013  BIMserver.org
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************/

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

		EClass logActionClass = schema.getEClass("log", "LogAction");

		EClass newExtendedDataAddedToRevisionClass = schema.createEClass("log", "NewExtendedDataAddedToRevision", logActionClass);
		schema.createEReference(newExtendedDataAddedToRevisionClass, "revision", revisionClass, Multiplicity.SINGLE);
		schema.createEReference(newExtendedDataAddedToRevisionClass, "extendedData", extendedDataClass, Multiplicity.SINGLE);

		EClass newExtendedDataAddedToProjectClass = schema.createEClass("log", "NewExtendedDataAddedToProject", logActionClass);
		schema.createEReference(newExtendedDataAddedToProjectClass, "project", projectClass, Multiplicity.SINGLE);
		schema.createEReference(newExtendedDataAddedToProjectClass, "extendedData", extendedDataClass, Multiplicity.SINGLE);
	}

	@Override
	public String getDescription() {
		return "Adding classes for extended data";
	}
}