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
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;

public class Step0057 extends Migration {

	@Override
	public void migrate(Schema schema, DatabaseSession databaseSession) {
		schema.loadEcore("ifc4x3.ecore", getClass().getResourceAsStream("IFC4X3_ADD2.ecore"));
		
		for (EClassifier eClassifier : schema.getEPackage("ifc4x3").getEClassifiers()) {
			if (eClassifier instanceof EClass) {
				EClass eClass = (EClass)eClassifier;
				for (EStructuralFeature eStructuralFeature : eClass.getEStructuralFeatures()) {
					// A hack because unfortunately not every "Name" field inherits from IfcRoot.Name, same could be true for GlobalId
					if (eStructuralFeature.getEType() == EcorePackage.eINSTANCE.getEString()) {
						if (eStructuralFeature.getName().equals("Name") || eStructuralFeature.getName().equals("GlobalId")) {
							schema.addIndex(eStructuralFeature);
						}
					}
				}
			}
		}
	}

	@Override
	public String getDescription() {
		return "Initial IFC4x3 model";
	}
}