package org.bimserver.ifc.xml.deserializer;

import java.util.Collections;
import java.util.Set;

import org.bimserver.emf.Schema;
import org.bimserver.plugins.PluginConfiguration;
import org.bimserver.plugins.deserializers.EmfDeserializer;

public class Ifc2x3tc1XmlDeserializerPlugin extends IfcXmlDeserializerPlugin  {
	@Override
	public String getDescription() {
		return "Ifc2x3tc1 Xml Deserializer";
	}

	@Override
	public String getDefaultName() {
		return "Ifc2x3tc1 Xml Deserializer";
	}
	
	@Override
	public EmfDeserializer createDeserializer(PluginConfiguration pluginConfiguration) {
		return new Ifc2x3tc1XmlDeserializer();
	}
	
	@Override
	public Set<Schema> getSupportedSchemas() {
		return Collections.singleton(Schema.IFC2X3TC1);
	}
}