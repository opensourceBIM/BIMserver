package org.bimserver.ifc.step.deserializer;

import java.util.HashSet;
import java.util.Set;

import org.bimserver.emf.Schema;
import org.bimserver.plugins.PluginConfiguration;
import org.bimserver.plugins.deserializers.Deserializer;

public class Ifc4StepDeserializerPlugin extends IfcStepDeserializerPlugin {
	@Override
	public Deserializer createDeserializer(PluginConfiguration pluginConfiguration) {
		return new Ifc4StepDeserializer(Schema.IFC4);
	}
	
	@Override
	public Set<Schema> getSupportedSchemas() {
		Set<Schema> set = new HashSet<>();
		set.add(Schema.IFC4);
		return set;
	}
	
	@Override
	public String getDescription() {
		return "Ifc4 Step Deserializer";
	}

	@Override
	public String getDefaultName() {
		return "Ifc4 Step Deserializer";
	}
}
