package org.bimserver.ifc.step.serializer;

import java.util.Set;

import org.bimserver.emf.Schema;
import org.bimserver.plugins.PluginConfiguration;
import org.bimserver.plugins.serializers.StreamingSerializer;

public class Ifc4StepStreamingSerializerPlugin extends IfcStepStreamingSerializerPlugin {
	@Override
	public String getDefaultName() {
		return "Ifc4 (Streaming, BETA)";
	}
	
	@Override
	public StreamingSerializer createSerializer(PluginConfiguration pluginConfiguration) {
		return new Ifc4StepStreamingSerializer(pluginConfiguration);
	}

	@Override
	public Set<Schema> getSupportedSchemas() {
		return Schema.IFC4.toSet();
	}
}