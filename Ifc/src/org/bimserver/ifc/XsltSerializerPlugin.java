package org.bimserver.ifc;

import net.xeoh.plugins.base.annotations.PluginImplementation;

import org.bimserver.plugins.serializers.EmfSerializer;
import org.bimserver.plugins.serializers.SerializerPlugin;

@PluginImplementation
public class XsltSerializerPlugin implements SerializerPlugin {

	@Override
	public EmfSerializer createSerializer() {
		return new XsltSerializer();
	}

	@Override
	public String getDescription() {
		return "XsltSerializer";
	}

	@Override
	public String getName() {
		return "XsltSerializer";
	}

	@Override
	public String getVersion() {
		return "1.0";
	}

	@Override
	public void init() {
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
}