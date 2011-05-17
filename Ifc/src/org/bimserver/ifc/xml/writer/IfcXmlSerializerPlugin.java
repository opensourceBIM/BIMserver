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
		return "IfcXmlSerializerPlugin";
	}

	@Override
	public String getName() {
		return "IfcXmlSerializerPlugin";
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
}