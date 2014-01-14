package org.bimserver.ifcengine;

/******************************************************************************
 * Copyright (C) 2009-2013  BIMserver.org
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

import org.bimserver.plugins.renderengine.RenderEngineClash;
import org.bimserver.plugins.renderengine.RenderEngineException;
import org.bimserver.plugins.renderengine.RenderEngineGeometry;
import org.bimserver.plugins.renderengine.RenderEngineInstance;
import org.bimserver.plugins.renderengine.RenderEngineModel;
import org.bimserver.plugins.renderengine.RenderEngineSettings;
import org.bimserver.plugins.renderengine.RenderEngineSurfaceProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JvmIfcEngineModel implements RenderEngineModel {
	private static final Logger LOGGER = LoggerFactory.getLogger(JvmIfcEngineModel.class);
	private final int modelId;
	private final JvmIfcEngine failSafeIfcEngine;

	public JvmIfcEngineModel(JvmIfcEngine failSafeIfcEngine, int modelId) {
		this.failSafeIfcEngine = failSafeIfcEngine;
		this.modelId = modelId;
	}

	public RenderEngineSurfaceProperties initializeModelling() throws RenderEngineException {
		synchronized (failSafeIfcEngine) {
			failSafeIfcEngine.writeCommand(Command.INITIALIZE_MODELLING);
			failSafeIfcEngine.writeInt(modelId);
			failSafeIfcEngine.flush();
			int noIndices = failSafeIfcEngine.readInt();
			int noVertices = failSafeIfcEngine.readInt();
			return new RenderEngineSurfaceProperties(modelId, noVertices, noIndices, 0.0);
		}
	}

	public void setPostProcessing(boolean postProcessing) throws RenderEngineException {
		synchronized (failSafeIfcEngine) {
			failSafeIfcEngine.writeCommand(Command.SET_POSTPROCESSING);
			failSafeIfcEngine.writeInt(modelId);
			failSafeIfcEngine.writeBoolean(postProcessing);
			failSafeIfcEngine.flush();
		}
	}

	public void setFormat(int format, int mask) throws RenderEngineException {
		synchronized (failSafeIfcEngine) {
			failSafeIfcEngine.writeCommand(Command.SET_FORMAT);
			failSafeIfcEngine.writeInt(modelId);
			failSafeIfcEngine.writeInt(format);
			failSafeIfcEngine.writeInt(mask);
			failSafeIfcEngine.flush();
		}
	}

	public RenderEngineGeometry finalizeModelling(RenderEngineSurfaceProperties surfaceProperties) throws RenderEngineException {
		synchronized (failSafeIfcEngine) {
			if (surfaceProperties.getIndicesCount() == 0 || surfaceProperties.getVerticesCount() == 0) {
				return null;
			}
			LOGGER.info(surfaceProperties.getIndicesCount() + " indices, " + surfaceProperties.getVerticesCount() + " vertices");
			if (surfaceProperties.getIndicesCount() < 0) {
				throw new RenderEngineException("Number of indices negative " + surfaceProperties.getIndicesCount());
			}
			if (surfaceProperties.getVerticesCount() < 0) {
				throw new RenderEngineException("Number of vertices negative " + surfaceProperties.getVerticesCount());
			}
			failSafeIfcEngine.writeCommand(Command.FINALIZE_MODELLING);
			failSafeIfcEngine.writeInt(modelId);
			failSafeIfcEngine.writeInt(surfaceProperties.getIndicesCount());
			failSafeIfcEngine.writeInt(surfaceProperties.getVerticesCount());
			failSafeIfcEngine.flush();
			int[] indices = new int[surfaceProperties.getIndicesCount()];
			float[] vertices = new float[surfaceProperties.getVerticesCount() * 3];
			float[] normals = new float[surfaceProperties.getVerticesCount() * 3];
			for (int i = 0; i < indices.length; i++) {
				indices[i] = failSafeIfcEngine.readInt();
			}
			for (int i = 0; i < vertices.length; i++) {
				vertices[i] = failSafeIfcEngine.readFloat();
			}
			for (int i = 0; i < normals.length; i++) {
				normals[i] = failSafeIfcEngine.readFloat();
			}
			return new RenderEngineGeometry(indices, vertices, normals);
		}
	}

	public List<? extends RenderEngineInstance> getInstances(String name) throws RenderEngineException {
		synchronized (failSafeIfcEngine) {
			failSafeIfcEngine.writeCommand(Command.GET_INSTANCES);
			failSafeIfcEngine.writeInt(modelId);
			failSafeIfcEngine.writeUTF(name);
			failSafeIfcEngine.flush();
			int nrInstances = failSafeIfcEngine.readInt();
			List<JvmIfcEngineInstance> instances = new ArrayList<JvmIfcEngineInstance>();
			for (int i = 0; i < nrInstances; i++) {
				instances.add(new JvmIfcEngineInstance(failSafeIfcEngine, modelId, failSafeIfcEngine.readInt()));
			}
			return instances;
		}
	}

	public void close() throws RenderEngineException {
		synchronized (failSafeIfcEngine) {
			failSafeIfcEngine.writeCommand(Command.CLOSE_MODEL);
			failSafeIfcEngine.writeInt(modelId);
			failSafeIfcEngine.flush();
		}
	}

	public Set<RenderEngineClash> findClashesWithEids(double d) throws RenderEngineException {
		synchronized (failSafeIfcEngine) {
			failSafeIfcEngine.writeCommand(Command.FIND_CLASHES_BY_EID);
			failSafeIfcEngine.writeInt(modelId);
			failSafeIfcEngine.writeDouble(d);
			failSafeIfcEngine.flush();
			int nrClashes = failSafeIfcEngine.readInt();
			Set<RenderEngineClash> clashes = new HashSet<RenderEngineClash>();
			for (int i = 0; i < nrClashes; i++) {
				RenderEngineClash clash = new RenderEngineClash();
				clashes.add(clash);
				clash.setEid1(failSafeIfcEngine.readLong());
				clash.setEid2(failSafeIfcEngine.readLong());
			}
			return clashes;
		}
	}
	
	public Set<RenderEngineClash> findClashesWithGuids(double d) throws RenderEngineException {
		synchronized (failSafeIfcEngine) {
			failSafeIfcEngine.writeCommand(Command.FIND_CLASHES_BY_GUID);
			failSafeIfcEngine.writeInt(modelId);
			failSafeIfcEngine.writeDouble(d);
			failSafeIfcEngine.flush();
			int nrClashes = failSafeIfcEngine.readInt();
			Set<RenderEngineClash> clashes = new HashSet<RenderEngineClash>();
			for (int i = 0; i < nrClashes; i++) {
				RenderEngineClash clash = new RenderEngineClash();
				clashes.add(clash);
				clash.setGuid1(failSafeIfcEngine.readString());
				clash.setGuid2(failSafeIfcEngine.readString());
			}
			return clashes;
		}
	}

	@Override
	public RenderEngineInstance getInstanceFromExpressId(int oid) throws RenderEngineException {
		synchronized (failSafeIfcEngine) {
			failSafeIfcEngine.writeCommand(Command.GET_INSTANCE_FROM_EXPRESSID);
			failSafeIfcEngine.writeInt(modelId);
			failSafeIfcEngine.writeInt(oid);
			failSafeIfcEngine.flush();
			int instanceId = failSafeIfcEngine.readInt();
			if (instanceId == -1) {
				throw new RenderEngineException("Instance with express id " + oid + " not found");
			}
			return new JvmIfcEngineInstance(failSafeIfcEngine, modelId, instanceId);
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