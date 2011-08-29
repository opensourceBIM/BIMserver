package org.bimserver.ifc.xsltserializer;
import org.bimserver.plugins.PluginException;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.serializers.EmfSerializer;
import org.bimserver.plugins.serializers.SerializerPlugin;

public class XsltSerializerPlugin implements SerializerPlugin {

	private boolean initialized = false;

	@Override
	public EmfSerializer createSerializer() {
		return new XsltSerializer();
	}

	@Override
	public String getDescription() {
		return "XsltSerializer";
	}

	@Override
	public String getVersion() {
		return "1.0";
	}

	@Override
	public void init(PluginManager pluginManager) throws PluginException {
		pluginManager.requireSchemaDefinition();
		initialized  = true;
	}

	@Override
	public String getDefaultSerializerName() {
		return "XSLT";
	}

	@Override
	public String getDefaultContentType() {
		return "application/xhtml+xml";
	}

	@Override
	public String getDefaultExtension() {
		return "xml";
	}

	@Override
	public boolean isInitialized() {
		return initialized;
	}
}