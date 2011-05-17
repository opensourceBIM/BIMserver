package org.bimserver.plugins.ifcengine;

import java.util.List;
import java.util.Set;

public interface IfcEngineModel {
	IfcEngineSurfaceProperties initializeModelling() throws IfcEngineException;
	void setPostProcessing(boolean postProcessing) throws IfcEngineException;
	IfcEngineGeometry finalizeModelling(IfcEngineSurfaceProperties surfaceProperties) throws IfcEngineException;
	List<? extends IfcEngineInstance> getInstances(String name) throws IfcEngineException;
	void close() throws IfcEngineException;
	Set<IfcEngineClash> findClashesWithEids(double d) throws IfcEngineException;
	Set<IfcEngineClash> findClashesWithGuids(double d) throws IfcEngineException;
}