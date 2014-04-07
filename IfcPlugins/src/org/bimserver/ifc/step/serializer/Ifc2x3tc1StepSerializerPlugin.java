package org.bimserver.ifc.step.serializer;

import java.util.Set;

import org.bimserver.emf.Schema;
import org.bimserver.plugins.PluginConfiguration;
import org.bimserver.plugins.serializers.Serializer;

public class Ifc2x3tc1StepSerializerPlugin extends IfcStepSerializerPlugin {
	@Override
	public String getDefaultName() {
		return "Ifc2x3";
	}
	
	@Override
	public Serializer createSerializer(PluginConfiguration pluginConfiguration) {
		return new Ifc2x3tc1StepSerializer(pluginConfiguration);
	}

	@Override
	public Set<Schema> getSupportedSchemas() {
		return Schema.IFC2X3TC1.toSet();
	}
}
