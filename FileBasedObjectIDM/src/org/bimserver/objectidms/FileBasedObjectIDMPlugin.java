package org.bimserver.objectidms;

/******************************************************************************
 * Copyright (C) 2009-2014  BIMserver.org
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************/

import org.bimserver.models.store.ObjectDefinition;
import org.bimserver.models.store.ParameterDefinition;
import org.bimserver.models.store.PrimitiveDefinition;
import org.bimserver.models.store.PrimitiveEnum;
import org.bimserver.models.store.StoreFactory;
import org.bimserver.plugins.PluginConfiguration;
import org.bimserver.plugins.PluginException;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.objectidms.ObjectIDM;
import org.bimserver.plugins.objectidms.ObjectIDMException;
import org.bimserver.plugins.objectidms.ObjectIDMPlugin;

public class FileBasedObjectIDMPlugin implements ObjectIDMPlugin {

	private boolean initialized;
	private FileBasedObjectIDM fileBasedObjectIDM;

	@Override
	public void init(PluginManager pluginManager) throws PluginException {
		try {
			fileBasedObjectIDM = new FileBasedObjectIDM(pluginManager.requireSchemaDefinition(), pluginManager.getPluginContext(this));
		} catch (ObjectIDMException e) {
			throw new PluginException(e);
		}
		initialized = true;
	}

	@Override
	public String getDescription() {
		return "FileBasedObjectIDMPlugin";
	}

	@Override
	public String getVersion() {
		return "1.0";
	}

	@Override
	public boolean isInitialized() {
		return initialized;
	}

	@Override
	public ObjectIDM getObjectIDM(PluginConfiguration pluginConfiguration) {
		return fileBasedObjectIDM;
	}

	@Override
	public String getDefaultName() {
		return "FileBasedObjectIDMPlugin";
	}

	@Override
	public ObjectDefinition getSettingsDefinition() {
		ObjectDefinition objectDefinition = StoreFactory.eINSTANCE.createObjectDefinition();
		ParameterDefinition dataParameterDefinition = StoreFactory.eINSTANCE.createParameterDefinition();
		dataParameterDefinition.setName("data");
		PrimitiveDefinition dataType = StoreFactory.eINSTANCE.createPrimitiveDefinition();
		dataType.setType(PrimitiveEnum.BYTE_ARRAY);
		dataParameterDefinition.setType(dataType);
		objectDefinition.getParameters().add(dataParameterDefinition);
		return objectDefinition;
	}
}