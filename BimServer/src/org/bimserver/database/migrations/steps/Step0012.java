package org.bimserver.database.migrations.steps;

/******************************************************************************
 * Copyright (C) 2011  BIMserver.org
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

public class Step0012 extends Migration {

	@Override
	public void migrate(Schema schema) {
		EClass compileResultClass = schema.createEClass(schema.getEPackage("store"), "CompileResult");
		schema.createEAttribute(compileResultClass, "compileOke", ecorePackage.getEBoolean(), Multiplicity.SINGLE);
		schema.createEAttribute(compileResultClass, "warnings", ecorePackage.getEString(), Multiplicity.MANY);
		schema.createEAttribute(compileResultClass, "errors", ecorePackage.getEString(), Multiplicity.MANY);

		EClass runResultClass = schema.createEClass(schema.getEPackage("store"), "RunResult");
		schema.createEAttribute(runResultClass, "runOke", ecorePackage.getEBoolean(), Multiplicity.SINGLE);
		schema.createEAttribute(runResultClass, "warnings", ecorePackage.getEString(), Multiplicity.MANY);
		schema.createEAttribute(runResultClass, "errors", ecorePackage.getEString(), Multiplicity.MANY);
		schema.createEAttribute(runResultClass, "output", ecorePackage.getEString(), Multiplicity.SINGLE);
	}

	@Override
	public String getDescription() {
		return "Advanced queries in Service Interface";
	}
}