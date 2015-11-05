package org.bimserver.ifc.step.deserializer;

import java.util.Collections;
import java.util.Set;

import org.bimserver.emf.Schema;
import org.bimserver.plugins.PluginConfiguration;
import org.bimserver.plugins.deserializers.Deserializer;

public class Ifc2x3tc1StepDeserializerPlugin extends IfcStepDeserializerPlugin {
	@Override
	public Deserializer createDeserializer(PluginConfiguration pluginConfiguration) {
		return new Ifc2x3tc1StepDeserializer(Schema.IFC2X3TC1);
	}
	
	@Override
	public Set<Schema> getSupportedSchemas() {
		return Collections.singleton(Schema.IFC2X3TC1);
	}
	
	@Override
	public String getDescription() {
		return "Ifc2x3tc1 Step Deserializer";
	}

	@Override
	public String getDefaultName() {
		return "Ifc2x3tc1 Step Deserializer";
	}
}
