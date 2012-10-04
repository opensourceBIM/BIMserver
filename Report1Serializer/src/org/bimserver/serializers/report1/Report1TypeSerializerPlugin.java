package org.bimserver.serializers.report1;

/******************************************************************************
 * Copyright (C) 2009-2012  BIMserver.org
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

import java.net.URL;

import org.bimserver.ifc.xsltserializer.XsltParameter;
import org.bimserver.ifc.xsltserializer.XsltSerializer;
import org.bimserver.models.store.ObjectDefinition;
import org.bimserver.plugins.PluginException;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.serializers.EmfSerializer;
import org.bimserver.plugins.serializers.SerializerPlugin;

public class Report1TypeSerializerPlugin implements SerializerPlugin {

	private boolean initialized;
	private URL url;

	@Override
	public void init(PluginManager pluginManager) throws PluginException {
		url = pluginManager.getPluginContext(this).getResourceAsUrl("_Report1.xhtml.xsl");
		initialized = true;
	}

	@Override
	public String getDescription() {
		return "Report1Type";
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
	public EmfSerializer createSerializer() {
		XsltSerializer xsltSerializer = new XsltSerializer();
		xsltSerializer.setXsltUrl(url);
		xsltSerializer.addParameter(new XsltParameter("topic", "type"));
		return xsltSerializer;
	}

	@Override
	public String getDefaultName() {
		return "Report1Type";
	}

	@Override
	public String getDefaultExtension() {
		return "xhtml";
	}

	@Override
	public String getDefaultContentType() {
		return "text/html";
	}

	@Override
	public ObjectDefinition getSettingsDefinition() {
		return null;
	}
}
