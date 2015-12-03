package org.bimserver.ifc.step.deserializer;

import java.util.Collections;
import java.util.Set;

import org.bimserver.emf.Schema;
import org.bimserver.plugins.PluginConfiguration;
import org.bimserver.plugins.deserializers.StreamingDeserializer;

public class Ifc4StepStreamingDeserializerPlugin extends IfcStepStreamingDeserializerPlugin {

	@Override
	public StreamingDeserializer createDeserializer(PluginConfiguration pluginConfiguration) {
		return new Ifc4StepStreamingDeserializer();
	}

	@Override
	public Set<Schema> getSupportedSchemas() {
		return Collections.singleton(Schema.IFC4);
	}

	@Override
	public String getDescription() {
		return "Ifc4 Step Streaming Deserializer";
	}

	@Override
	public String getDefaultName() {
		return "Ifc4 Step Streaming Deserializer (BETA)";
	}
}