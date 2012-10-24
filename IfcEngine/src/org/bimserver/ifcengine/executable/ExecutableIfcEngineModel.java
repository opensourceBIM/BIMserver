package org.bimserver.ifcengine.executable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.bimserver.ifcengine.Command;
import org.bimserver.plugins.ifcengine.IfcEngineClash;
import org.bimserver.plugins.ifcengine.IfcEngineException;
import org.bimserver.plugins.ifcengine.IfcEngineGeometry;
import org.bimserver.plugins.ifcengine.IfcEngineInstance;
import org.bimserver.plugins.ifcengine.IfcEngineModel;
import org.bimserver.plugins.ifcengine.IfcEngineSurfaceProperties;

/******************************************************************************
 * Copyright (C) 2009-2012 BIMserver.org
 * 
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU Affero General Public License as published by the Free
 * Software Foundation, either version 3 of the License, or (at your option) any
 * later version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Affero General Public License for more
 * details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 * 
 * BIMserver software uses the IFC Engine DLL library build. This binary Engine
 * DLL is NOT open source. The IFC Engine DLL is a closed source product owned
 * by the Netherlands Organisation for Applied Scientifc Research TNO. The
 * latest versions are available for download from http://ifcengine.com. In case
 * of none commercial use there is no license fee and redistribution of the
 * binary is allowed as long as clearly mentioned that the IFC Engine DLL is
 * used. The BIMserver.org software is non-commercial so users of the BIMserver
 * software can use it free of charge. Within the Open Source BIMserver software
 * there is one exception to the normal conditions: A special version of the IFC
 * Engine DLL is used that includes Clashdetection functionality, this version
 * is not commercially available. For more information, please contact the owner
 * at info@ifcengine.com
 *****************************************************************************/
public class ExecutableIfcEngineModel implements IfcEngineModel {
	private final int modelId;
	private final ExecutableIfcEngine ifcEngine;

	public ExecutableIfcEngineModel(ExecutableIfcEngine ifcEngine, int modelId) {
		this.ifcEngine = ifcEngine;
		this.modelId = modelId;
	}

	public IfcEngineSurfaceProperties initializeModelling() throws IfcEngineException {
		synchronized (ifcEngine) {
			ifcEngine.writeCommand(Command.INITIALIZE_MODELLING);
			ifcEngine.writeInt(modelId);
			ifcEngine.flush();
			int noIndices = ifcEngine.readInt();
			int noVertices = ifcEngine.readInt();
			return new IfcEngineSurfaceProperties(modelId, noVertices, noIndices, 0.0);
		}
	}

	public void setPostProcessing(boolean postProcessing) throws IfcEngineException {
		synchronized (ifcEngine) {
			ifcEngine.writeCommand(Command.SET_POSTPROCESSING);
			ifcEngine.writeInt(modelId);
			ifcEngine.writeBoolean(postProcessing);
			ifcEngine.flush();
		}
	}

	public IfcEngineGeometry finalizeModelling(IfcEngineSurfaceProperties surfaceProperties) throws IfcEngineException {
		synchronized (ifcEngine) {
			if (surfaceProperties.getIndicesCount() == 0 || surfaceProperties.getVerticesCount() == 0) {
				return null;
			}
			ifcEngine.writeCommand(Command.FINALIZE_MODELLING);
			ifcEngine.writeInt(modelId);
			ifcEngine.writeInt(surfaceProperties.getIndicesCount());
			ifcEngine.writeInt(surfaceProperties.getVerticesCount());
			ifcEngine.flush();
			int[] indices = new int[surfaceProperties.getIndicesCount()];
			float[] vertices = new float[surfaceProperties.getVerticesCount() * 3];
			float[] normals = new float[surfaceProperties.getVerticesCount() * 3];
			for (int i = 0; i < indices.length; i++) {
				indices[i] = ifcEngine.readInt();
			}
			for (int i = 0; i < vertices.length; i++) {
				vertices[i] = ifcEngine.readFloat();
			}
			for (int i = 0; i < normals.length; i++) {
				normals[i] = ifcEngine.readFloat();
			}
			return new IfcEngineGeometry(indices, vertices, normals);
		}
	}

	public List<? extends IfcEngineInstance> getInstances(String name) throws IfcEngineException {
		synchronized (ifcEngine) {
			ifcEngine.writeCommand(Command.GET_INSTANCES);
			ifcEngine.writeInt(modelId);
			ifcEngine.writeUTF(name);
			ifcEngine.flush();
			int nrInstances = ifcEngine.readInt();
			List<ExecutableIfcEngineInstance> instances = new ArrayList<ExecutableIfcEngineInstance>();
			for (int i = 0; i < nrInstances; i++) {
				instances.add(new ExecutableIfcEngineInstance(ifcEngine, modelId, ifcEngine.readInt()));
			}
			return instances;
		}
	}

	public void close() throws IfcEngineException {
		synchronized (ifcEngine) {
			ifcEngine.writeCommand(Command.CLOSE_MODEL);
			ifcEngine.writeInt(modelId);
			ifcEngine.flush();
		}
	}

	public Set<IfcEngineClash> findClashesWithEids(double d) throws IfcEngineException {
		synchronized (ifcEngine) {
			ifcEngine.writeCommand(Command.FIND_CLASHES_BY_EID);
			ifcEngine.writeInt(modelId);
			ifcEngine.writeDouble(d);
			ifcEngine.flush();
			int nrClashes = ifcEngine.readInt();
			Set<IfcEngineClash> clashes = new HashSet<IfcEngineClash>();
			for (int i = 0; i < nrClashes; i++) {
				IfcEngineClash clash = new IfcEngineClash();
				clashes.add(clash);
				clash.setEid1(ifcEngine.readLong());
				clash.setEid2(ifcEngine.readLong());
			}
			return clashes;
		}
	}

	public Set<IfcEngineClash> findClashesWithGuids(double d) throws IfcEngineException {
		synchronized (ifcEngine) {
			ifcEngine.writeCommand(Command.FIND_CLASHES_BY_GUID);
			ifcEngine.writeInt(modelId);
			ifcEngine.writeDouble(d);
			ifcEngine.flush();
			int nrClashes = ifcEngine.readInt();
			Set<IfcEngineClash> clashes = new HashSet<IfcEngineClash>();
			for (int i = 0; i < nrClashes; i++) {
				IfcEngineClash clash = new IfcEngineClash();
				clashes.add(clash);
				clash.setGuid1(ifcEngine.readString());
				clash.setGuid2(ifcEngine.readString());
			}
			return clashes;
		}
	}

	@Override
	public IfcEngineInstance getInstanceFromExpressId(int oid) throws IfcEngineException {
		synchronized (ifcEngine) {
			ifcEngine.writeCommand(Command.GET_INSTANCE_FROM_EXPRESSID);
			ifcEngine.writeInt(modelId);
			ifcEngine.writeInt(oid);
			ifcEngine.flush();
			return new ExecutableIfcEngineInstance(ifcEngine, modelId, ifcEngine.readInt());
		}
	}
}