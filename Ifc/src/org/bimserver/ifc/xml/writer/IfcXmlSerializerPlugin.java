package org.bimserver.ifc.xml.writer;

import net.xeoh.plugins.base.annotations.PluginImplementation;

import org.bimserver.plugins.serializers.EmfSerializer;
import org.bimserver.plugins.serializers.SerializerPlugin;

@PluginImplementation
public class IfcXmlSerializerPlugin implements SerializerPlugin {

	@Override
	public EmfSerializer createSerializer() {
		return new IfcXmlSerializer();
	}

	@Override
	public String getDescription() {
		return "IfcXmlSerializer";
	}

	@Override
	public String getName() {
		return "IfcXmlSerializer";
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
		return "IfcXML";
	}

	@Override
	public String getDefaultContentType() {
		return "application/ifcxml";
	}

	@Override
	public String getDefaultExtension() {
		return "ifcxml";
	}
}