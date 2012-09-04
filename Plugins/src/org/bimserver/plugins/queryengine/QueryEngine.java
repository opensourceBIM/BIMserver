package org.bimserver.plugins.queryengine;

import org.bimserver.models.store.RunResult;
import org.bimserver.plugins.serializers.IfcModelInterface;

public interface QueryEngine {
	RunResult query(IfcModelInterface model, String code);
}
