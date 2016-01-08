package org.bimserver.charting;

/******************************************************************************
 * Copyright (C) 2009-2015  BIMserver.org
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

import java.util.Set;

import org.bimserver.emf.Schema;
import org.bimserver.models.store.ObjectDefinition;
import org.bimserver.plugins.PluginConfiguration;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.PluginManagerInterface;
import org.bimserver.plugins.serializers.AbstractSerializerPlugin;
import org.bimserver.plugins.serializers.Serializer;
import org.bimserver.shared.exceptions.PluginException;

public class IfcLevelOfDetailMetricsChartSerializerPlugin extends AbstractSerializerPlugin {

	private boolean initialized = false;

	@Override
	public Serializer createSerializer(PluginConfiguration plugin) {
		LevelOfDetailMetricsChartSerializer serializer = new LevelOfDetailMetricsChartSerializer();
		serializer.title = getDefaultName();
		serializer.addOption("Width", 1000);
		serializer.addOption("Height", 750);
		serializer.addOption("Sort", "none");
		serializer.addOption("Detail Mode", LevelOfDetailMetricsChartSerializer.DetailMode.Everything);
		return serializer;
	}

	@Override
	public boolean needsGeometry() {
		return true;
	}

	@Override
	public Set<Schema> getSupportedSchemas() {
		return Schema.IFC2X3TC1.toSet();
	}

	@Override
	public void init(PluginManagerInterface pluginManager) throws PluginException {
		initialized = true;
	}

	@Override
	public String getDescription() {
		return "IFC Level of Detail Metrics Chart (SVG)";
	}

	@Override
	public String getDefaultName() {
		return "IFC Level of Detail Metrics Chart";
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
	public String getDefaultExtension() {
		return "svg";
	}

	@Override
	public String getDefaultContentType() {
		return "application/svg";
	}

	@Override
	public ObjectDefinition getSettingsDefinition() {
		return super.getSettingsDefinition();
	}
}
