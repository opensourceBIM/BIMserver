package org.bimserver.plugins.queryengine;

import org.bimserver.emf.IfcModelInterface;
import org.bimserver.plugins.ModelHelper;
import org.bimserver.plugins.Reporter;

public interface QueryEngine {
	/**
	 * @param model The complete model
	 * @param code The query, represented as a string
	 * @return RunResult
	 */
	IfcModelInterface query(IfcModelInterface model, String code, Reporter reporter, ModelHelper modelHelper) throws QueryEngineException;
}