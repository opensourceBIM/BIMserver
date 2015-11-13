package org.bimserver.ifc.step.serializer;

import java.util.Set;

import org.bimserver.emf.Schema;
import org.bimserver.plugins.PluginConfiguration;
import org.bimserver.plugins.serializers.StreamingSerializer;

public class Ifc2x3tc1StepStreamingSerializerPlugin extends IfcStepStreamingSerializerPlugin {
	@Override
	public String getDefaultName() {
		return "Ifc2x3 (Streaming)";
	}
	
	@Override
	public StreamingSerializer createSerializer(PluginConfiguration pluginConfiguration) {
		return new Ifc2x3tc1StepStreamingSerializer(pluginConfiguration);
	}

	@Override
	public Set<Schema> getSupportedSchemas() {
		return Schema.IFC2X3TC1.toSet();
	}
}
