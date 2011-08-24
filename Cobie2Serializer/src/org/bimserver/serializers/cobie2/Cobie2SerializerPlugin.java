package org.bimserver.serializers.cobie2;

import java.net.URL;
import java.util.Set;

import org.bimserver.ifc.xsltserializer.XsltSerializer;
import org.bimserver.plugins.Plugin;
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