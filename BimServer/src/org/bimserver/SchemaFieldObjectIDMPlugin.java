package org.bimserver;

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

import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package;
import org.bimserver.models.store.ObjectDefinition;
import org.bimserver.plugins.PluginException;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.objectidms.ObjectIDM;
import org.bimserver.plugins.objectidms.ObjectIDMPlugin;
import org.bimserver.plugins.schema.SchemaDefinition;
import org.bimserver.utils.CollectionUtils;

public class SchemaFieldObjectIDMPlugin implements ObjectIDMPlugin {

	private SchemaFieldIgnoreMap objectIDM;
	private boolean initialized = false;

	@Override
	public void init(PluginManager pluginManager) throws PluginException {
		SchemaDefinition schema = pluginManager.requireSchemaDefinition();
		objectIDM = new SchemaFieldIgnoreMap(CollectionUtils.singleSet(Ifc2x3tc1Package.eINSTANCE), schema);
		initialized = true;
	}

	@Override
	public String getDescription() {
		return "SchemaFieldObjectIDMPlugin";
	}

	@Override
	public String getVersion() {
		return "1.0";
	}

	@Override
	public ObjectIDM getObjectIDM() {
		return objectIDM;
	}

	@Override
	public boolean isInitialized() {
		return initialized;
	}

	@Override
	public String getDefaultName() {
		return "default";
	}

	@Override
	public ObjectDefinition getSettingsDefinition() {
		return null;
	}
}