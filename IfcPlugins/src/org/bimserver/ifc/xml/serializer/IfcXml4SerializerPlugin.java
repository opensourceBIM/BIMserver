package org.bimserver.ifc.xml.serializer;

import org.bimserver.emf.Schema;
import org.bimserver.plugins.PluginConfiguration;
import org.bimserver.plugins.serializers.Serializer;

public class IfcXml4SerializerPlugin extends IfcXmlSerializerPlugin {

	@Override
	public Schema[] getSupportedSchemas() {
		return new Schema[]{Schema.IFC4};
	}

	@Override
	public Serializer createSerializer(PluginConfiguration plugin) {
		return new IfcXml4Serializer();
	}
}
