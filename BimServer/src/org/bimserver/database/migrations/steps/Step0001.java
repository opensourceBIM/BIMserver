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
import org.eclipse.emf.ecore.EClass;

/*
 * This step creates the Ifc2x3tc1 model
 */
public class Step0001 extends Migration {

	@Override
	public void migrate(Schema schema) {
		schema.loadEcore(getClass().getResourceAsStream("IFC2X3_TC1.ecore"));
		EClass ifcRoot = schema.getEClass("ifc2x3tc1", "IfcRoot");
		ifcRoot.getEStructuralFeature("GlobalId").getEAnnotations().add(createIndexAnnotation());
		ifcRoot.getEStructuralFeature("Name").getEAnnotations().add(createIndexAnnotation());
	}

	@Override
	public String getDescription() {
		return "Initial IFC2X3 TC1 model";
	}
}