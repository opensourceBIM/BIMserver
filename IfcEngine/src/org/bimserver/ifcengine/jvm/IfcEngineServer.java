package org.bimserver.ifcengine.jvm;

/******************************************************************************
 * Copyright (C) 2009-2015  BIMserver.org
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

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.bimserver.ifcengine.Command;
import org.bimserver.ifcengine.jvm.IfcEngine.InstanceTransformationMatrix;
import org.bimserver.ifcengine.jvm.IfcEngine.SurfaceProperties;
import org.bimserver.plugins.renderengine.RenderEngineClash;
import org.bimserver.plugins.renderengine.RenderEngineException;

import com.sun.jna.Pointer;

public class IfcEngineServer extends Thread {
	private volatile boolean running = true;
	private final String schemaFileName;
	private IfcEngine ifcEngine;
	private final Map<Integer, Pointer> pointers = new HashMap<Integer, Pointer>();
	private int pointerCounter = 0;
	private final InputStream in;
	private final OutputStream out;
	private final PrintStream err;

	public static void main(String[] args) {
		try {
			IfcEngineServer ifcEngineServer = new IfcEngineServer(args[0], System.in, System.out, System.err);
			ifcEngineServer.run();
		} catch (Throwable e) {
			e.printStackTrace(System.err);
		}
	}

	public IfcEngineServer(String schemaFileName, InputStream in, OutputStream out, PrintStream err) {
		this.schemaFileName = schemaFileName;
		this.in = in;
		this.out = out;
		this.err = err;
		this.ifcEngine = new IfcEngine();
	}

	public void run() {
		try {
			DataInputStream in = new DataInputStream(new BufferedInputStream(this.in));
			DataOutputStream out = new DataOutputStream(new BufferedOutputStream(this.out));
			while (running) {
				byte commandId = in.readByte();
				Command command = Command.getCommand(commandId);
				// LOGGER.info("Command " + command + " received");
				switch (command) {
				case CHECK_CONNECTION: {
					in.readBoolean();
					out.writeBoolean(true);
				}
					break;
				case OPEN_MODEL: {
					String name = in.readUTF();
					Pointer modelId = ifcEngine.sdaiOpenModelBN(0, name, schemaFileName);
					int newPointerKey = savePointer(modelId);
					out.writeInt(newPointerKey);
				}
					break;
				case OPEN_MODEL_STREAMING: {
					int size = in.readInt();
					Pointer modelId = ifcEngine.loadFromInputStream(in, size, schemaFileName);
					int newPointerKey = savePointer(modelId);
					out.writeInt(newPointerKey);
				}
					break;
				case OPEN_MODEL_STREAMING_PARTS: {
					ConvertingInputStream convertingInputStream = new ConvertingInputStream(in);
					Pointer modelId = ifcEngine.loadFromInputStream(convertingInputStream, schemaFileName);
					int newPointerKey = savePointer(modelId);
					out.writeInt(newPointerKey);
				}
				break;
				case FINALIZE_MODELLING: {
					int modelId = in.readInt();
					int indicesCount = in.readInt();
					int verticesCount = in.readInt();
					if (indicesCount != 0 && verticesCount != 0) {
						boolean is64 = is64();
						int[] indices = new int[indicesCount * (is64 ? 2 : 1)];
						float[] vertices = new float[verticesCount * 3];
						float[] normals = new float[verticesCount * 3];
						ifcEngine.finalizeModelling(pointers.get(modelId), vertices, normals, indices);
						boolean even = true;
						for (int index : indices) {
							if (!is64 || even) {
								out.writeInt(index);
							}
							even = !even;
						}
						for (float vertex : vertices) {
							out.writeFloat(vertex);
						}
						for (float normal : normals) {
							out.writeFloat(normal);
						}
					}
				}
					break;
				case INITIALIZE_MODELLING: {
					int modelId = in.readInt();
					SurfaceProperties surfaceProperties = ifcEngine.initializeModelling(pointers.get(modelId), 0.0);
					out.writeInt(surfaceProperties.getIndicesCount());
					out.writeInt(surfaceProperties.getVerticesCount());
				}
					break;
				case INITIALIZE_MODELLING_INSTANCE: {
					int modelId = in.readInt();
					int instanceId = in.readInt();
					SurfaceProperties surfaceProperties = ifcEngine.initializeModellingInstance(pointers.get(modelId), 0.0, pointers.get(instanceId));
					out.writeInt(surfaceProperties.getIndicesCount());
					out.writeInt(surfaceProperties.getVerticesCount());
				}
					break;
				case SET_POSTPROCESSING: {
					int modelId = in.readInt();
					ifcEngine.setPostProcessing(pointers.get(modelId), in.readBoolean() ? 1 : 0);
				}
					break;
				case GET_INSTANCES: {
					int modelId = in.readInt();
					String name = in.readUTF();
					Pointer aggrId = ifcEngine.sdaiGetEntityExtentBN(pointers.get(modelId), name);
					int nrObjects = ifcEngine.sdaiGetMemberCount(aggrId);
					out.writeInt(nrObjects);
					for (int k = 0; k < nrObjects; k++) {
						Object instanceId = (Pointer) ifcEngine.engiGetAggrElement(aggrId, k, SdaiTypes.INSTANCE);
						if (instanceId instanceof Pointer) {
							out.writeInt(savePointer((Pointer) instanceId));
						} else {
							throw new RenderEngineException("Unimplemented");
						}
					}
				}
					break;
				case FIND_CLASHES_BY_GUID: {
					int modelId = in.readInt();
					double dist = in.readDouble();
					int nrClashes = ifcEngine.initializeClashes(pointers.get(modelId), dist);
					if (nrClashes > 0) {
						Set<RenderEngineClash> clashes = ifcEngine.finalizeClashesByGuid(pointers.get(modelId), nrClashes);
						out.writeInt(nrClashes);
						for (RenderEngineClash clash : clashes) {
							out.writeUTF(clash.getGuid1());
							out.writeUTF(clash.getGuid2());
						}
					} else {
						out.writeInt(0);
					}
				}
					break;
				case FIND_CLASHES_BY_EID: {
					int modelId = in.readInt();
					double dist = in.readDouble();
					int nrClashes = ifcEngine.initializeClashes(pointers.get(modelId), dist);
					if (nrClashes > 0) {
						Set<RenderEngineClash> clashes = ifcEngine.finalizeClashesByEI(pointers.get(modelId), nrClashes);
						out.writeInt(nrClashes);
						for (RenderEngineClash clash : clashes) {
							out.writeLong(clash.getEid1());
							out.writeLong(clash.getEid2());
						}
					} else {
						out.writeInt(0);
					}
				}
					break;
				case GET_VISUALISATION_PROPERTIES: {
					int modelId = in.readInt();
					int instanceId = in.readInt();
					RenderEngineInstanceVisualisationPropertiesInternal instanceInModelling = ifcEngine.getInstanceInModelling(pointers.get(modelId), pointers.get(instanceId), 1);
					out.writeInt(instanceInModelling.getStartVertex());
					out.writeInt(instanceInModelling.getStartIndex());
					out.writeInt(instanceInModelling.getPrimitiveCount());
				}
					break;
				case CLOSE_MODEL: {
					int modelId = in.readInt();
					ifcEngine.sdaiCloseModel(pointers.get(modelId));
					pointers.remove(modelId);
					break;
				}
				case GET_AREA: {
					int modelId = in.readInt();
					int instanceId = in.readInt();
					out.writeDouble(ifcEngine.getArea(pointers.get(modelId), pointers.get(instanceId)));
					break;
				}
				case GET_VOLUME: {
					int modelId = in.readInt();
					int instanceId = in.readInt();
					out.writeDouble(ifcEngine.getVolume(pointers.get(modelId), pointers.get(instanceId)));
					break;
				}
				case SET_FORMAT: {
					int modelId = in.readInt();
					ifcEngine.setFormat(pointers.get(modelId), in.readInt(), in.readInt());
				}
					break;
				case SET_FILTER: {
					int modelId = in.readInt();
					ifcEngine.setFilter(pointers.get(modelId), in.readInt(), in.readInt());
				}
				break;
				case GET_INSTANCE_FROM_EXPRESSID: {
					int modelId = in.readInt();
					int expressId = in.readInt();
					Pointer internalGetInstanceFromP21Line = ifcEngine.internalGetInstanceFromP21Line(pointers.get(modelId), expressId);
					if (internalGetInstanceFromP21Line == Pointer.NULL) {
						out.writeInt(-1);
					} else {
						out.writeInt(savePointer(internalGetInstanceFromP21Line));
					}
					break;
				}
				case GET_TRANSFORMATION_MATRIX: {
					int modelId = in.readInt();
					int instanceId = in.readInt();
					InstanceTransformationMatrix instanceTransformationMatrix = ifcEngine.getInstanceTransformationMatrix(pointers.get(modelId), pointers.get(instanceId));
					out.writeFloat((float) instanceTransformationMatrix._11);
					out.writeFloat((float) instanceTransformationMatrix._12);
					out.writeFloat((float) instanceTransformationMatrix._13);
					out.writeFloat((float) instanceTransformationMatrix._14);
					out.writeFloat((float) instanceTransformationMatrix._21);
					out.writeFloat((float) instanceTransformationMatrix._22);
					out.writeFloat((float) instanceTransformationMatrix._23);
					out.writeFloat((float) instanceTransformationMatrix._24);
					out.writeFloat((float) instanceTransformationMatrix._31);
					out.writeFloat((float) instanceTransformationMatrix._32);
					out.writeFloat((float) instanceTransformationMatrix._33);
					out.writeFloat((float) instanceTransformationMatrix._34);
					out.writeFloat((float) instanceTransformationMatrix._41);
					out.writeFloat((float) instanceTransformationMatrix._42);
					out.writeFloat((float) instanceTransformationMatrix._43);
					out.writeFloat((float) instanceTransformationMatrix._44);
					break;					
				}
				case CLOSE: {
					close();
					System.exit(0);
				}
					break;
				}
				out.flush();
			}
		} catch (IOException e) {
			if (running) {
				e.printStackTrace(err);
			}
		} catch (Throwable e) {
			e.printStackTrace(err);
		}
	}

	private boolean is64() {
		return System.getProperty("sun.arch.data.model").equals("64");
	}

	private int savePointer(Pointer modelId) {
		int newPointerKey = pointerCounter++;
		pointers.put(newPointerKey, modelId);
		return newPointerKey;
	}

	private void close() {
		running = false;
	}
}