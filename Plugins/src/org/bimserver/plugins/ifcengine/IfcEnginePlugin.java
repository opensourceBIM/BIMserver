package org.bimserver.plugins.ifcengine;

import org.bimserver.plugins.Plugin;

public interface IfcEnginePlugin extends Plugin {
	IfcEngine createIfcEngine() throws IfcEngineException;
}