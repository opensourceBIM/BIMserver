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

public class Step0020 extends Migration {

	@Override
	public void migrate(Schema schema) {
		schema.createEClass(schema.getEPackage("store"), "ModelComparePluginDescriptor", schema.getEClass("store", "PluginDescriptor"));

		EClass modelComparePluginClass = schema.createEClass(schema.getEPackage("store"), "ModelComparePluginConfiguration", schema.getEClass("store", "PluginConfiguration"));
		EClass userSettingsClass = schema.getEClass("store", "UserSettings");

		EReference modelCompareSettingsReference = schema.createEReference(modelComparePluginClass, "userSettings", userSettingsClass, Multiplicity.SINGLE);
		EReference settingsModelComparesReference = schema.createEReference(userSettingsClass, "modelcompares", modelComparePluginClass, Multiplicity.MANY);

		modelCompareSettingsReference.setEOpposite(settingsModelComparesReference);
		settingsModelComparesReference.setEOpposite(modelCompareSettingsReference);
		
		schema.createEReference(userSettingsClass, "defaultModelMerger", schema.getEClass("store", "ModelMergerPluginConfiguration"), Multiplicity.SINGLE);
		schema.createEReference(userSettingsClass, "defaultModelCompare", schema.getEClass("store", "ModelComparePluginConfiguration"), Multiplicity.SINGLE);
		schema.createEReference(userSettingsClass, "defaultQueryEngine", schema.getEClass("store", "QueryEnginePluginConfiguration"), Multiplicity.SINGLE);
		schema.createEReference(userSettingsClass, "defaultIfcEngine", schema.getEClass("store", "IfcEnginePluginConfiguration"), Multiplicity.SINGLE);
		schema.createEReference(userSettingsClass, "defaultSerializer", schema.getEClass("store", "SerializerPluginConfiguration"), Multiplicity.SINGLE);
		schema.createEReference(userSettingsClass, "defaultObjectIDM", schema.getEClass("store", "ObjectIDMPluginConfiguration"), Multiplicity.SINGLE);
	}

	@Override
	public String getDescription() {
		return "Add ModelComparePluginDescriptor + ModelCompare";
	}
}