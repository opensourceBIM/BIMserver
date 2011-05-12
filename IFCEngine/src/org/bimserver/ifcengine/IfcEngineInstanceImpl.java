package org.bimserver.ifcengine;

import org.bimserver.plugins.ifcengine.IfcEngineException;
import org.bimserver.plugins.ifcengine.IfcEngineInstance;
import org.bimserver.plugins.ifcengine.IfcEngineInstanceVisualisationProperties;

public class IfcEngineInstanceImpl implements IfcEngineInstance {
	private final FailSafeIfcEngine failSafeIfcEngine;
	private final int instanceId;
	private final int modelId;

	public IfcEngineInstanceImpl(FailSafeIfcEngine failSafeIfcEngine, int modelId, int instanceId) {
		this.failSafeIfcEngine = failSafeIfcEngine;
		this.modelId = modelId;
		this.instanceId = instanceId;
	}

	public IfcEngineInstanceVisualisationProperties getVisualisationProperties() throws IfcEngineException {
		synchronized (failSafeIfcEngine) {
			failSafeIfcEngine.writeCommand(Command.GET_VISUALISATION_PROPERTIES);
			failSafeIfcEngine.writeInt(modelId);
			failSafeIfcEngine.writeInt(instanceId);
			failSafeIfcEngine.flush();
			return new IfcEngineInstanceVisualisationProperties(failSafeIfcEngine.readInt(), failSafeIfcEngine.readInt(), failSafeIfcEngine.readInt());
		}
	}
}