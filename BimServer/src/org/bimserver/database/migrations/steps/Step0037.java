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
import org.eclipse.emf.ecore.EClass;

public class Step0037 extends Migration {

	@Override
	public void migrate(Schema schema, DatabaseSession databaseSession) {
//		EClass ifcRootClass = schema.getEClass("ifc4", "IfcRoot");
//		schema.addIndex(ifcRootClass.getEStructuralFeature("GlobalId"));
//		schema.addIndex(ifcRootClass.getEStructuralFeature("Name"));
		
		EClass ifcClassificationReference = schema.getEClass("ifc4", "IfcClassificationReference");
		EClass ifcRelAssociatesClassification = schema.getEClass("ifc4", "IfcRelAssociatesClassification");
//		
//		// This opposite/inverse is obviously missing from ifc2x3tc1
//		// We can however not call this an opposite because of a mismatch
//		EReference associatesClassification = schema.createEReference(ifcClassificationReference, "associatesClassification", ifcRelAssociatesClassification);
//		associatesClassification.getEAnnotations().add(createHiddenAnnotation());

		schema.addIndex(ifcClassificationReference.getEStructuralFeature("Identification"));
		schema.addIndex(ifcRelAssociatesClassification.getEStructuralFeature("RelatingClassification"));

	}

	@Override
	public String getDescription() {
		return "Indices for IFC4";
	}
}