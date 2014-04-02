package org.bimserver.ifc.step.serializer;

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
	public Schema[] getSupportedSchemas() {
		return new Schema[]{Schema.IFC2X3TC1};
	}
}
