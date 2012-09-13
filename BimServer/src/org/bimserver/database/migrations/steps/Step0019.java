package org.bimserver.database.migrations.steps;

/******************************************************************************
 * Copyright (C) 2009-2012  BIMserver.org
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
import org.eclipse.emf.ecore.EReference;

public class Step0019 extends Migration {

	@Override
	public void migrate(Schema schema) {
		schema.createEClass(schema.getEPackage("store"), "ModelMergerPluginDescriptor", schema.getEClass("store", "PluginDescriptor"));
		
		EClass modelMergerClass = schema.createEClass(schema.getEPackage("store"), "ModelMerger", schema.getEClass("store", "Plugin"));
		EClass userSettingsClass = schema.getEClass("store", "UserSettings");

		EReference modelMergerSettingsReference = schema.createEReference(modelMergerClass, "settings", userSettingsClass, Multiplicity.SINGLE);
		EReference settingsModelMergersReference = schema.createEReference(userSettingsClass, "modelmergers", modelMergerClass, Multiplicity.MANY);
		
		modelMergerSettingsReference.setEOpposite(settingsModelMergersReference);
		settingsModelMergersReference.setEOpposite(modelMergerSettingsReference);
	}

	@Override
	public String getDescription() {
		return "Add ModelMergerPluginDescriptor + ModelMerger";
	}
}