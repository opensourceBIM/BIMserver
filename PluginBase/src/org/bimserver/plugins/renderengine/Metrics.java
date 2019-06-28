package org.bimserver.plugins.renderengine;

import com.fasterxml.jackson.databind.node.ObjectNode;

public interface Metrics {

	long getCpuTime();
	long getMaxMemoryBytes();
	
	ObjectNode asJson();
}
