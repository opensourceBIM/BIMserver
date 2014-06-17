package org.bimserver.ifc.xml.serializer;

import java.util.Set;

import org.bimserver.emf.Schema;
import org.bimserver.plugins.PluginConfiguration;
import org.bimserver.plugins.serializers.Serializer;

public class IfcXml4SerializerPlugin extends IfcXmlSerializerPlugin {

	@Override
	public Set<Schema> getSupportedSchemas() {
		return Schema.IFC4.toSet();
	}

	@Override
	public Serializer createSerializer(PluginConfiguration plugin) {
		return new IfcXml4Serializer();
	}
}
