package org.bimserver.ifc.xml.serializer;

import java.util.Set;

import org.bimserver.emf.Schema;
import org.bimserver.plugins.PluginConfiguration;
import org.bimserver.plugins.serializers.Serializer;

public class IfcXml2x3tc1SerializerPlugin extends IfcXmlSerializerPlugin {

	@Override
	public Set<Schema> getSupportedSchemas() {
		return Schema.IFC2X3TC1.toSet();
	}

	@Override
	public Serializer createSerializer(PluginConfiguration plugin) {
		return new IfcXml2x3tc1Serializer();
	}
}
