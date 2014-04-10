package org.bimserver.streamingdeserializers;

import org.bimserver.plugins.PluginConfiguration;
import org.bimserver.plugins.streamingdeserializers.StreamingDeserializer;

public class Ifc2x3tc1StepStreamingDeserializerPlugin extends IfcStepStreamingDeserializerPlugin {
	@Override
	public StreamingDeserializer createDeserializer(PluginConfiguration pluginConfiguration) {
		return new Ifc2x3tc1StepStreamingDeserializer();
	}

	@Override
	public String getDescription() {
		return "Ifc2x3tc1 Step Streaming Deserializer";
	}

	@Override
	public String getDefaultName() {
		return "Ifc2x3tc1 Step Streaming Deserializer";
	}
}