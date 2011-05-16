package org.bimserver.ifc.file.writer;

import org.bimserver.plugins.serializers.EmfSerializer;
import org.bimserver.plugins.serializers.SerializerPlugin;

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
}