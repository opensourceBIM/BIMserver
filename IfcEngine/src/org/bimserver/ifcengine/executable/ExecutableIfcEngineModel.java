package org.bimserver.ifcengine.executable;

/******************************************************************************
 * Copyright (C) 2009-2014  BIMserver.org
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 * 
 * BIMserver software uses the IFC Engine DLL library build.
 * This binary Engine DLL is NOT open source. The IFC Engine DLL is a closed source product owned by the Netherlands Organisation for Applied Scientifc Research TNO.
 * The latest versions are available for download from http://ifcengine.com.
 * In case of none commercial use there is no license fee and redistribution of the binary is allowed as long as clearly mentioned that the IFC Engine DLL is used. The BIMserver.org software is non-commercial so users of the BIMserver software can use it free of charge.
 * Within the Open Source BIMserver software there is one exception to the normal conditions: A special version of the IFC Engine DLL is used that includes Clashdetection functionality, this version is not commercially available. For more information, please contact the owner at info@ifcengine.com
 *****************************************************************************/

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.bimserver.ifcengine.Command;
import org.bimserver.plugins.renderengine.RenderEngineClash;
import org.bimserver.plugins.renderengine.RenderEngineException;
import org.bimserver.plugins.renderengine.RenderEngineGeometry;
import org.bimserver.plugins.renderengine.RenderEngineInstance;
import org.bimserver.plugins.renderengine.RenderEngineModel;
import org.bimserver.plugins.renderengine.RenderEngineSettings;
import org.bimserver.plugins.renderengine.RenderEngineSurfaceProperties;

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
public class ExecutableIfcEngineModel implements RenderEngineModel {
	private final int modelId;
	private final ExecutableIfcEngine ifcEngine;

	public ExecutableIfcEngineModel(ExecutableIfcEngine ifcEngine, int modelId) {
		this.ifcEngine = ifcEngine;
		this.modelId = modelId;
	}

	public RenderEngineSurfaceProperties initializeModelling() throws RenderEngineException {
		synchronized (ifcEngine) {
			ifcEngine.writeCommand(Command.INITIALIZE_MODELLING);
			ifcEngine.writeInt(modelId);
			ifcEngine.flush();
			int noIndices = ifcEngine.readInt();
			int noVertices = ifcEngine.readInt();
			return new RenderEngineSurfaceProperties(modelId, noVertices, noIndices, 0.0);
		}
	}

	public void setPostProcessing(boolean postProcessing) throws RenderEngineException {
		synchronized (ifcEngine) {
			ifcEngine.writeCommand(Command.SET_POSTPROCESSING);
			ifcEngine.writeInt(modelId);
			ifcEngine.writeBoolean(postProcessing);
			ifcEngine.flush();
		}
	}

	public RenderEngineGeometry finalizeModelling(RenderEngineSurfaceProperties surfaceProperties) throws RenderEngineException {
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
			return new RenderEngineGeometry(indices, vertices, normals);
		}
	}

	public List<? extends RenderEngineInstance> getInstances(String name) throws RenderEngineException {
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

	public void close() throws RenderEngineException {
		synchronized (ifcEngine) {
			ifcEngine.writeCommand(Command.CLOSE_MODEL);
			ifcEngine.writeInt(modelId);
			ifcEngine.flush();
		}
	}

	public Set<RenderEngineClash> findClashesWithEids(double d) throws RenderEngineException {
		synchronized (ifcEngine) {
			ifcEngine.writeCommand(Command.FIND_CLASHES_BY_EID);
			ifcEngine.writeInt(modelId);
			ifcEngine.writeDouble(d);
			ifcEngine.flush();
			int nrClashes = ifcEngine.readInt();
			Set<RenderEngineClash> clashes = new HashSet<RenderEngineClash>();
			for (int i = 0; i < nrClashes; i++) {
				RenderEngineClash clash = new RenderEngineClash();
				clashes.add(clash);
				clash.setEid1(ifcEngine.readLong());
				clash.setEid2(ifcEngine.readLong());
			}
			return clashes;
		}
	}

	public Set<RenderEngineClash> findClashesWithGuids(double d) throws RenderEngineException {
		synchronized (ifcEngine) {
			ifcEngine.writeCommand(Command.FIND_CLASHES_BY_GUID);
			ifcEngine.writeInt(modelId);
			ifcEngine.writeDouble(d);
			ifcEngine.flush();
			int nrClashes = ifcEngine.readInt();
			Set<RenderEngineClash> clashes = new HashSet<RenderEngineClash>();
			for (int i = 0; i < nrClashes; i++) {
				RenderEngineClash clash = new RenderEngineClash();
				clashes.add(clash);
				clash.setGuid1(ifcEngine.readString());
				clash.setGuid2(ifcEngine.readString());
			}
			return clashes;
		}
	}

	@Override
	public RenderEngineInstance getInstanceFromExpressId(int oid) throws RenderEngineException {
		synchronized (ifcEngine) {
			ifcEngine.writeCommand(Command.GET_INSTANCE_FROM_EXPRESSID);
			ifcEngine.writeInt(modelId);
			ifcEngine.writeInt(oid);
			ifcEngine.flush();
			return new ExecutableIfcEngineInstance(ifcEngine, modelId, ifcEngine.readInt());
		}
	}

	@Override
	public void setFormat(int format, int mask) throws RenderEngineException {
		synchronized (ifcEngine) {
			ifcEngine.writeCommand(Command.SET_FORMAT);
			ifcEngine.writeInt(modelId);
			ifcEngine.writeInt(format);
			ifcEngine.writeInt(mask);
			ifcEngine.flush();
		}
	}

	@Override
	public void setSettings(RenderEngineSettings settings) throws RenderEngineException {
        int setting = 0;
        int mask = 0;
        mask += PRECISION;
        setting += settings.getPrecision().getValue();
        mask += INDEX_BITS;
        setting += settings.getIndexFormat().getValue();
        mask += NORMALS;
        setting += settings.isGenerateNormals() ? NORMALS : 0;
        mask += TRIANGLES;
        setting += settings.isGenerateTriangles() ? TRIANGLES : 0;
        mask += WIREFRAME;
        setting += settings.isGenerateWireFrame() ? WIREFRAME : 0;
        setFormat(setting, mask);
	}
}