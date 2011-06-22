package org.bimserver.plugins.ifcengine;

import org.bimserver.plugins.PluginException;

public class IfcEngineException extends PluginException {
	private static final long serialVersionUID = 4485210826117178542L;

	public IfcEngineException(String message) {
		super(message);
	}
	
	public IfcEngineException(Exception e) {
		super(e);
	}
}