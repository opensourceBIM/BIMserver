package org.bimserver.serializers.cobie2;

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

import java.net.URL;

import org.bimserver.ifc.xsltserializer.XsltSerializer;
import org.bimserver.plugins.PluginException;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.serializers.EmfSerializer;
import org.bimserver.plugins.serializers.SerializerPlugin;

public class Cobie2SerializerPlugin implements SerializerPlugin {

	private boolean initialized;
	private URL url;

	@Override
	public void init(PluginManager pluginManager) throws PluginException {
		url = pluginManager.getPluginContext(this).getResourceAsUrl("_asCOBie2.xml.xsl");
		initialized = true;
	}

	@Override
	public String getDescription() {
		return "Cobie2";
	}

	@Override
	public String getVersion() {
		return "2.0";
	}

	@Override
	public boolean isInitialized() {
		return initialized;
	}

	@Override
	public EmfSerializer createSerializer() {
		XsltSerializer xsltSerializer = new XsltSerializer();
		xsltSerializer.setXsltUrl(url);
		return xsltSerializer;
	}

	@Override
	public String getDefaultSerializerName() {
		return "Cobie2";
	}

	@Override
	public String getDefaultExtension() {
		return "xml";
	}

	@Override
	public String getDefaultContentType() {
		return "text/xml";
	}
}