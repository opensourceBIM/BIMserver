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

/*
 * This step creates the Ifc2x3tc1 model
 */
public class Step0001 extends Migration {

	@Override
	public void migrate(Schema schema, DatabaseSession databaseSession) {
		schema.loadEcore("ifc2x3_tc1.ecore", getClass().getResourceAsStream("IFC2X3_TC1.ecore"));
		for (EClassifier eClassifier : schema.getEPackage("ifc2x3tc1").getEClassifiers()) {
			if (eClassifier instanceof EClass) {
				EClass eClass = (EClass)eClassifier;
				for (EStructuralFeature eStructuralFeature : eClass.getEStructuralFeatures()) {
					if (eStructuralFeature.getEType() == EcorePackage.eINSTANCE.getEString()) {
						// A hack because unfortunately not every "Name" field inherits from IfcRoot.Name, same could be true for GlobalId
						if (eStructuralFeature.getName().equals("Name") || eStructuralFeature.getName().equals("GlobalId")) {
//							System.out.println(eClass.getName() + "." + eStructuralFeature.getName());
							schema.addIndex(eStructuralFeature);
						}
					}
				}
			}
		}
	}

	@Override
	public String getDescription() {
		return "Initial IFC2X3 TC1 model";
	}
}