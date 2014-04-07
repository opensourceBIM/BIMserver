package org.bimserver.ifc.step.serializer;

import java.util.Set;

import org.bimserver.emf.Schema;
import org.bimserver.plugins.PluginConfiguration;
import org.bimserver.plugins.serializers.Serializer;

public class Ifc4StepSerializerPlugin extends IfcStepSerializerPlugin {
	@Override
	public String getDefaultName() {
		return "Ifc4";
	}
	
	@Override
	public Serializer createSerializer(PluginConfiguration pluginConfiguration) {
		return new Ifc4StepSerializer(pluginConfiguration);
	}

	@Override
	public Set<Schema> getSupportedSchemas() {
		return Schema.IFC4.toSet();
	}
}
