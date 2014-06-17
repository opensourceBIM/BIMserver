package org.bimserver.ifc.xml.deserializer;

import java.util.Collections;
import java.util.Set;

import org.bimserver.emf.Schema;
import org.bimserver.plugins.PluginConfiguration;
import org.bimserver.plugins.deserializers.EmfDeserializer;

public class Ifc4XmlDeserializerPlugin extends IfcXmlDeserializerPlugin {
	@Override
	public String getDescription() {
		return "Ifc4 Xml Deserializer";
	}

	@Override
	public String getDefaultName() {
		return "Ifc4 Xml Deserializer";
	}
	
	@Override
	public EmfDeserializer createDeserializer(PluginConfiguration pluginConfiguration) {
		return new Ifc4XmlDeserializer();
	}
	
	@Override
	public Set<Schema> getSupportedSchemas() {
		return Collections.singleton(Schema.IFC4);
	}
}
