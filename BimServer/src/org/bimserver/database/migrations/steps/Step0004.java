package org.bimserver.database.migrations.steps;

/******************************************************************************
 * Copyright (C) 2009-2019  BIMserver.org
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
 * along with this program.  If not, see {@literal<http://www.gnu.org/licenses/>}.
 *****************************************************************************/

import org.bimserver.database.DatabaseSession;
import org.bimserver.database.migrations.Migration;
import org.bimserver.database.migrations.Schema;
import org.bimserver.database.migrations.Schema.Multiplicity;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EcorePackage;

public class Step0004 extends Migration {

	@Override
	public void migrate(Schema schema, DatabaseSession databaseSession) {
		// Model checker results
		EClass modelCheckerResultItem = schema.createEClass("store", "ModelCheckerResultItem");
		
		EClass modelCheckerResultHeader = schema.createEClass("store", "ModelCheckerResultHeader", modelCheckerResultItem);
		schema.createEAttribute(modelCheckerResultHeader, "text", EcorePackage.eINSTANCE.getEString());
		
		EEnum modelCheckerResultType = schema.createEEnum("store", "ModelCheckerResultType");
		schema.createEEnumLiteral(modelCheckerResultType, "ERROR");
		schema.createEEnumLiteral(modelCheckerResultType, "SUCCESS");
		
		EClass modelCheckerResultLine = schema.createEClass("store", "ModelCheckerResultLine", modelCheckerResultItem);
		schema.createEAttribute(modelCheckerResultLine, "fieldOrClass", EcorePackage.eINSTANCE.getEString());
		schema.createEAttribute(modelCheckerResultLine, "value", EcorePackage.eINSTANCE.getEString());
		schema.createEAttribute(modelCheckerResultLine, "shouldBe", EcorePackage.eINSTANCE.getEString());
		schema.createEAttribute(modelCheckerResultLine, "type", modelCheckerResultType);
		schema.createEAttribute(modelCheckerResultLine, "objectId", EcorePackage.eINSTANCE.getELong());
		
		EClass modelCheckerResult = schema.createEClass("store", "ModelCheckerResult");
		schema.createEAttribute(modelCheckerResult, "valid", EcorePackage.eINSTANCE.getEBoolean());
		schema.createEReference(modelCheckerResult, "items", modelCheckerResultItem, Multiplicity.MANY);
		
		EClass modelCheckerInstance = schema.createEClass("store", "ModelCheckerInstance");
		schema.createEAttribute(modelCheckerInstance, "name", EcorePackage.eINSTANCE.getEString());
		schema.createEAttribute(modelCheckerInstance, "description", EcorePackage.eINSTANCE.getEString());
		schema.createEAttribute(modelCheckerInstance, "code", EcorePackage.eINSTANCE.getEString());
		schema.createEAttribute(modelCheckerInstance, "compiled", EcorePackage.eINSTANCE.getEByteArray());
		schema.createEAttribute(modelCheckerInstance, "valid", EcorePackage.eINSTANCE.getEBoolean());
		schema.createEAttribute(modelCheckerInstance, "modelCheckerPluginClassName", EcorePackage.eINSTANCE.getEString(), Multiplicity.SINGLE);
		
		// References to plugin
		EClass service = schema.getEClass("store", "Service");
		schema.createEReference(service, "modelCheckers", modelCheckerInstance, Multiplicity.MANY);
		
		EClass project = schema.getEClass("store", "Project");
		schema.createEReference(project, "modelCheckers", modelCheckerInstance, Multiplicity.MANY);
		
		EClass internalServicePluginConfiguration = schema.getEClass("store", "InternalServicePluginConfiguration");
		schema.createEAttribute(internalServicePluginConfiguration, "publicProfile", EcorePackage.eINSTANCE.getEBoolean());
		
//		EClass geometryInstance = schema.createEClass("ifc2x3tc1", "GeometryInstance");
//		schema.createEReference(geometryInstance, "data", schema.getEClass("ifc2x3tc1", "GeometryData"), Multiplicity.SINGLE);
//		schema.createEAttribute(geometryInstance, "transformation", EcorePackage.eINSTANCE.getEByteArray(), Multiplicity.SINGLE);
//		geometryInstance.getEAnnotations().add(createHiddenAnnotation());
		
//		schema.createEReference(schema.getEClass("ifc2x3tc1", "GeometryInfo"), "instance", geometryInstance, Multiplicity.SINGLE);
	}

	@Override
	public String getDescription() {
		return "ModelChecker objects";
	}
}