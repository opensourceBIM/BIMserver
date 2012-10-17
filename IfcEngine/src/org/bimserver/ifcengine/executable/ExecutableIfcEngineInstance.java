package org.bimserver.ifcengine.executable;

import org.bimserver.ifcengine.Command;
import org.bimserver.plugins.ifcengine.IfcEngineException;
import org.bimserver.plugins.ifcengine.IfcEngineInstance;
import org.bimserver.plugins.ifcengine.IfcEngineInstanceVisualisationProperties;

public class ExecutableIfcEngineInstance implements IfcEngineInstance {

	private ExecutableIfcEngine executableIfcEngine;
	private int modelId;
	private int instanceId;

	public ExecutableIfcEngineInstance(ExecutableIfcEngine failSafeIfcEngine, int modelId, int instanceId) {
		this.executableIfcEngine = failSafeIfcEngine;
		this.modelId = modelId;
		this.instanceId = instanceId;
	}

	@Override
	public IfcEngineInstanceVisualisationProperties getVisualisationProperties() throws IfcEngineException {
		synchronized (executableIfcEngine) {
			executableIfcEngine.writeCommand(Command.GET_VISUALISATION_PROPERTIES);
			executableIfcEngine.writeInt(modelId);
			executableIfcEngine.writeInt(instanceId);
			executableIfcEngine.flush();
			return new IfcEngineInstanceVisualisationProperties(executableIfcEngine.readInt(), executableIfcEngine.readInt(), executableIfcEngine.readInt());
		}
	}
}
