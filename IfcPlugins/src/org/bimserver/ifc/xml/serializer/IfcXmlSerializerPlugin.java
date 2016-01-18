package org.bimserver.ifc.xml.serializer;

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

import org.bimserver.models.store.ObjectDefinition;
import org.bimserver.models.store.ParameterDefinition;
import org.bimserver.models.store.PrimitiveDefinition;
import org.bimserver.models.store.PrimitiveEnum;
import org.bimserver.models.store.StoreFactory;
import org.bimserver.models.store.StringType;
import org.bimserver.plugins.PluginManagerInterface;
import org.bimserver.plugins.serializers.AbstractSerializerPlugin;
import org.bimserver.shared.exceptions.PluginException;

public abstract class IfcXmlSerializerPlugin extends AbstractSerializerPlugin {

	private boolean initialized = false;

	@Override
	public String getDescription() {
		return "IfcXmlSerializer";
	}

	@Override
	public String getVersion() {
		return "1.0";
	}
	
	@Override
	public boolean needsGeometry() {
		return false;
	}

	@Override
	public void init(PluginManagerInterface pluginManager) throws PluginException {
		initialized = true;
	}

	@Override
	public String getDefaultContentType() {
		return "application/ifcxml";
	}

	@Override
	public String getDefaultExtension() {
		return "ifcxml";
	}

	@Override
	public boolean isInitialized() {
		return initialized;
	}

	@Override
	public ObjectDefinition getSettingsDefinition() {
		ObjectDefinition settingsDefinition = super.getSettingsDefinition();

		PrimitiveDefinition stringDefinition = StoreFactory.eINSTANCE.createPrimitiveDefinition();
		stringDefinition.setType(PrimitiveEnum.STRING);

		ParameterDefinition zipExtension = StoreFactory.eINSTANCE.createParameterDefinition();
		zipExtension.setName(ZIP_EXTENSION);
		zipExtension.setDescription("Extension of the downloaded file when using zip compression");
		zipExtension.setType(stringDefinition);
		StringType defaultZipExtensionValue = StoreFactory.eINSTANCE.createStringType();
		defaultZipExtensionValue.setValue("ifczip");
		zipExtension.setDefaultValue(defaultZipExtensionValue);
		settingsDefinition.getParameters().add(zipExtension);

		return settingsDefinition;
	}
}