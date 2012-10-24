package org.bimserver.ifcengine.executable;

import org.bimserver.ifcengine.Command;
import org.bimserver.plugins.ifcengine.IfcEngineException;
import org.bimserver.plugins.ifcengine.IfcEngineInstance;
import org.bimserver.plugins.ifcengine.IfcEngineInstanceVisualisationProperties;

public class ExecutableIfcEngineInstance implements IfcEngineInstance {

	private ExecutableIfcEngine ifcEngine;
	private int modelId;
	private int instanceId;

	public ExecutableIfcEngineInstance(ExecutableIfcEngine ifcEngine, int modelId, int instanceId) {
		this.ifcEngine = ifcEngine;
		this.modelId = modelId;
		this.instanceId = instanceId;
	}

	@Override
	public IfcEngineInstanceVisualisationProperties getVisualisationProperties() throws IfcEngineException {
		synchronized (ifcEngine) {
			ifcEngine.writeCommand(Command.GET_VISUALISATION_PROPERTIES);
			ifcEngine.writeInt(modelId);
			ifcEngine.writeInt(instanceId);
			ifcEngine.flush();
			return new IfcEngineInstanceVisualisationProperties(ifcEngine.readInt(), ifcEngine.readInt(), ifcEngine.readInt());
		}
	}
}
