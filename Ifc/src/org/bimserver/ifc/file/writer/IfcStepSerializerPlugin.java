package org.bimserver.ifc.file.writer;

import net.xeoh.plugins.base.annotations.PluginImplementation;

import org.bimserver.plugins.serializers.EmfSerializer;
import org.bimserver.plugins.serializers.SerializerPlugin;

@PluginImplementation
public class IfcStepSerializerPlugin implements SerializerPlugin {

	@Override
	public EmfSerializer createSerializer() {
		return new IfcStepSerializer();
	}

	@Override
	public String getDescription() {
		return "IfcStepSerializerPlugin";
	}

	@Override
	public String getName() {
		return "IfcStepSerializerPlugin";
	}

	@Override
	public String getVersion() {
		return "1.0";
	}

	@Override
	public void init() {
	}

	@Override
	public String getDefaultSerializerName() {
		return "Ifc2x3";
	}
}