package org.bimserver.database.migrations.steps;

/******************************************************************************
 * Copyright (C) 2009-2016  BIMserver.org
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

public class Step0023 extends Migration {

	@Override
	public void migrate(Schema schema, DatabaseSession databaseSession) {
		EClass pluginBundleVersionClass = schema.createEClass("store", "PluginBundleVersion");

		EEnum pluginBundleType = schema.createEEnum("store", "PluginBundleType");
		schema.createEEnumLiteral(pluginBundleType, "MAVEN");
		schema.createEEnumLiteral(pluginBundleType, "GITHUB");

		EEnum pluginType = schema.createEEnum("store", "PluginType");
		schema.createEEnumLiteral(pluginType, "SERIALIZER");
		schema.createEEnumLiteral(pluginType, "DESERIALIZER");
		schema.createEEnumLiteral(pluginType, "RENDER_ENGINE");
		schema.createEEnumLiteral(pluginType, "QUERY_ENGINE");
		schema.createEEnumLiteral(pluginType, "OBJECT_IDM");
		schema.createEEnumLiteral(pluginType, "WEB_MODULE");
		schema.createEEnumLiteral(pluginType, "MODEL_MERGER");
		schema.createEEnumLiteral(pluginType, "MODEL_COMPARE");
		schema.createEEnumLiteral(pluginType, "MODEL_CHECKER");
		schema.createEEnumLiteral(pluginType, "STILL_IMAGE_RENDER");

		schema.createEAttribute(pluginBundleVersionClass, "version", EcorePackage.eINSTANCE.getEString());
		schema.createEAttribute(pluginBundleVersionClass, "type", pluginBundleType);
		schema.createEAttribute(pluginBundleVersionClass, "description", EcorePackage.eINSTANCE.getEString());
		schema.createEAttribute(pluginBundleVersionClass, "mismatch", EcorePackage.eINSTANCE.getEBoolean());
		schema.createEAttribute(pluginBundleVersionClass, "repository", EcorePackage.eINSTANCE.getEString());
		schema.createEAttribute(pluginBundleVersionClass, "groupId", EcorePackage.eINSTANCE.getEString());
		schema.createEAttribute(pluginBundleVersionClass, "artifactId", EcorePackage.eINSTANCE.getEString());

		EClass pluginBundleUpdateInformation = schema.createEClass("store", "PluginBundleUpdateInformation");
		schema.createEAttribute(pluginBundleUpdateInformation, "organization", EcorePackage.eINSTANCE.getEString());
		schema.createEAttribute(pluginBundleUpdateInformation, "name", EcorePackage.eINSTANCE.getEString());
		schema.createEReference(pluginBundleUpdateInformation, "latestVersion", pluginBundleVersionClass, Multiplicity.SINGLE).getEAnnotations().add(createEmbedsReferenceAnnotation());
		schema.createEReference(pluginBundleUpdateInformation, "availableVersions", pluginBundleVersionClass, Multiplicity.MANY).getEAnnotations().add(createEmbedsReferenceAnnotation());

		EClass pluginInformation = schema.createEClass("store", "PluginInformation");
		schema.createEAttribute(pluginInformation, "name", EcorePackage.eINSTANCE.getEString());
		schema.createEAttribute(pluginInformation, "type", pluginType);
		schema.createEAttribute(pluginInformation, "description", EcorePackage.eINSTANCE.getEString());
		schema.createEAttribute(pluginInformation, "installForAllUsers", EcorePackage.eINSTANCE.getEBoolean());
		schema.createEAttribute(pluginInformation, "installForNewUsers", EcorePackage.eINSTANCE.getEBoolean());
	}

	@Override
	public String getDescription() {
		return "Classes needed for remote plugin system";
	}
}