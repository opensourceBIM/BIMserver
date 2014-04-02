package org.bimserver.ifc.xml.serializer;

import org.bimserver.emf.Schema;
import org.bimserver.plugins.PluginConfiguration;
import org.bimserver.plugins.serializers.Serializer;

public class IfcXml2x3tc1SerializerPlugin extends IfcXmlSerializerPlugin {

	@Override
	public Schema[] getSupportedSchemas() {
		return new Schema[]{Schema.IFC2X3TC1};
	}

	@Override
	public Serializer createSerializer(PluginConfiguration plugin) {
		return new IfcXml2x3tc1Serializer();
	}
}
