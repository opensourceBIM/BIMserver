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
import org.eclipse.emf.ecore.EPackage;

public class Step0023 extends Migration {

	@Override
	public void migrate(Schema schema) {
		EClass revisionClass = schema.getEClass("store", "Revision");
		EClass projectClass = schema.getEClass("store", "Project");
		EClass extendedDataClass = schema.getEClass("store", "ExtendedData");
		EClass logActionClass = schema.getEClass("log", "LogAction");
		EPackage logPackage = schema.getEPackage("log");
		
		EClass extendedDataAddedToRevision = schema.createEClass(logPackage, "ExtendedDataAddedToRevision", logActionClass);
		schema.createEReference(extendedDataAddedToRevision, "revision", revisionClass, Multiplicity.SINGLE);
		schema.createEReference(extendedDataAddedToRevision, "extendedData", extendedDataClass, Multiplicity.SINGLE);
		
		EClass extendedDataAddedToProject = schema.createEClass(logPackage, "ExtendedDataAddedToProject", logActionClass);
		schema.createEReference(extendedDataAddedToProject, "project", projectClass, Multiplicity.SINGLE);
		schema.createEReference(extendedDataAddedToProject, "extendedData", extendedDataClass, Multiplicity.SINGLE);
	}

	@Override
	public String getDescription() {
		return "Extended data";
	}
}
