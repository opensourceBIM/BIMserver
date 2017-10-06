package org.bimserver.emf;

/******************************************************************************
 * Copyright (C) 2009-2017  BIMserver.org
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
 * along with this program.  If not, see {@literal<http://www.gnu.org/licenses/>}.
 *****************************************************************************/

import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.bimserver.BimserverDatabaseException;
import org.bimserver.geometry.Matrix;
import org.bimserver.models.geometry.GeometryData;
import org.bimserver.models.geometry.GeometryFactory;
import org.bimserver.models.geometry.GeometryInfo;
import org.bimserver.models.geometry.Vector3f;
import org.bimserver.models.ifc2x3tc1.IfcProduct;
import org.bimserver.plugins.renderengine.EntityNotFoundException;
import org.bimserver.plugins.renderengine.IndexFormat;
import org.bimserver.plugins.renderengine.Precision;
import org.bimserver.plugins.renderengine.RenderEngine;
import org.bimserver.plugins.renderengine.RenderEngineException;
import org.bimserver.plugins.renderengine.RenderEngineFilter;
import org.bimserver.plugins.renderengine.RenderEngineGeometry;
import org.bimserver.plugins.renderengine.RenderEngineInstance;
import org.bimserver.plugins.renderengine.RenderEngineModel;
import org.bimserver.plugins.renderengine.RenderEngineSettings;
import org.bimserver.plugins.serializers.Serializer;
import org.bimserver.plugins.serializers.SerializerException;
import org.bimserver.plugins.serializers.SerializerInputstream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OfflineGeometryGenerator {
	private static final Logger LOGGER = LoggerFactory.getLogger(OfflineGeometryGenerator.class);
	private IfcModelInterface model;
	private Serializer serializer;
	private RenderEngine renderEngine;
	private RenderEngineModel renderEngineModel;
	private final Map<Integer, GeometryData> hashes = new ConcurrentHashMap<Integer, GeometryData>();

	public OfflineGeometryGenerator(IfcModelInterface model, Serializer serializer, RenderEngine renderEngine) {
		this.model = model;
		this.serializer = serializer;
		this.renderEngine = renderEngine;
	}

	public void generateForAllElements() {
		try {
			serializer.init(model, null, true);
			InputStream in = new SerializerInputstream(serializer);
			renderEngineModel = renderEngine.openModel(in);
			final RenderEngineSettings settings = new RenderEngineSettings();
			settings.setPrecision(Precision.SINGLE);
			settings.setIndexFormat(IndexFormat.AUTO_DETECT);
			settings.setGenerateNormals(true);
			settings.setGenerateTriangles(true);
			settings.setGenerateWireFrame(false);
			
			final RenderEngineFilter renderEngineFilter = new RenderEngineFilter();
			
			renderEngineModel.setSettings(settings);
			renderEngineModel.setFilter(renderEngineFilter);
			
			renderEngineModel.generateGeneralGeometry();
			
			for (IfcProduct ifcProduct : model.getAllWithSubTypes(IfcProduct.class)) {
				generateGeometry(ifcProduct);
			}
		} catch (SerializerException e) {
			e.printStackTrace();
		} catch (RenderEngineException e) {
			e.printStackTrace();
		}
	}

	private GenerateGeometryResult generateGeometry(IfcProduct ifcProduct) {
		GenerateGeometryResult generateGeometryResult = new GenerateGeometryResult();
		if (ifcProduct.getRepresentation() != null && ifcProduct.getRepresentation().getRepresentations().size() != 0) {
			try {
				RenderEngineInstance renderEngineInstance = renderEngineModel.getInstanceFromExpressId(ifcProduct.getExpressId());
				RenderEngineGeometry geometry = renderEngineInstance.generateGeometry();
				boolean translate = true;
				if (geometry != null && geometry.getNrIndices() > 0) {
					GeometryInfo geometryInfo = null;
					geometryInfo = GeometryFactory.eINSTANCE.createGeometryInfo();

					geometryInfo.setMinBounds(createVector3f(model.getPackageMetaData(), model, Double.POSITIVE_INFINITY));
					geometryInfo.setMaxBounds(createVector3f(model.getPackageMetaData(), model, -Double.POSITIVE_INFINITY));

					try {
						double area = renderEngineInstance.getArea();
						geometryInfo.setArea(area);
						double volume = renderEngineInstance.getVolume();
						if (volume < 0d) {
							volume = -volume;
						}
						geometryInfo.setVolume(volume);
						
//						EStructuralFeature guidFeature = ifcProduct.eClass().getEStructuralFeature("GlobalId");
//						String guid = (String) ifcProduct.eGet(guidFeature);
//						System.out.println(guid + ": " + "Area: " + area + ", Volume: " + volume);
					} catch (UnsupportedOperationException e) {
					}
					
					GeometryData geometryData = null;
					geometryData = GeometryFactory.eINSTANCE.createGeometryData();

					geometryData.setIndices(intArrayToByteArray(geometry.getIndices()));
					geometryData.setVertices(floatArrayToByteArray(geometry.getVertices()));
					geometryData.setMaterialIndices(intArrayToByteArray(geometry.getMaterialIndices()));
					geometryData.setNormals(floatArrayToByteArray(geometry.getNormals()));
					
					geometryInfo.setPrimitiveCount(geometry.getIndices().length / 3);

					if (geometry.getMaterialIndices() != null && geometry.getMaterialIndices().length > 0) {
						boolean hasMaterial = false;
						float[] vertex_colors = new float[geometry.getVertices().length / 3 * 4];
						for (int i = 0; i < geometry.getMaterialIndices().length; ++i) {
							int c = geometry.getMaterialIndices()[i];
							for (int j = 0; j < 3; ++j) {
								int k = geometry.getIndices()[i * 3 + j];
								if (c > -1) {
									hasMaterial = true;
									for (int l = 0; l < 4; ++l) {
										vertex_colors[4 * k + l] = geometry.getMaterials()[4 * c + l];
									}
								}
							}
						}
						if (hasMaterial) {
							geometryData.setMaterials(floatArrayToByteArray(vertex_colors));
						}
					}

					double[] tranformationMatrix = new double[16];
					Matrix.setIdentityM(tranformationMatrix, 0);
					if (translate && renderEngineInstance.getTransformationMatrix() != null) {
						tranformationMatrix = renderEngineInstance.getTransformationMatrix();
					}

					for (int i = 0; i < geometry.getIndices().length; i++) {
						processExtends(geometryInfo, tranformationMatrix, geometry.getVertices(), geometry.getIndices()[i] * 3, generateGeometryResult);
					}

					geometryInfo.setData(geometryData);

//					long length = (geometryData.getIndices() != null ? geometryData.getIndices().length : 0) + 
//								  (geometryData.getVertices() != null ? geometryData.getVertices().length : 0) + 
//								  (geometryData.getNormals() != null ? geometryData.getNormals().length : 0) + 
//								  (geometryData.getMaterials() != null ? geometryData.getMaterials().length : 0) +
//								  (geometryData.getMaterialIndices() != null ? geometryData.getMaterialIndices().length : 0);

					setTransformationMatrix(geometryInfo, tranformationMatrix);
					int hash = hash(geometryData);
					if (hashes.containsKey(hash)) {
						geometryInfo.setData(hashes.get(hash));
					} else {
						hashes.put(hash, geometryData);
					}

					ifcProduct.setGeometry(geometryInfo);
				}
			} catch (EntityNotFoundException e) {
				// As soon as we find a representation that is not Curve2D, then we should show a "INFO" message in the log to indicate there could be something wrong
				boolean ignoreNotFound = true;
//				for (Object rep : representations) {
//					if (rep instanceof IfcShapeRepresentation) {
//						IfcShapeRepresentation ifcShapeRepresentation = (IfcShapeRepresentation)rep;
//						if (!"Curve2D".equals(ifcShapeRepresentation.getRepresentationType())) {
//							ignoreNotFound = false;
//						}
//					}
//				}
				if (!ignoreNotFound) {
					LOGGER.info("Entity not found " + ifcProduct.eClass().getName() + " " + ifcProduct.getExpressId() + "/" + ifcProduct.getOid());
				}
			} catch (BimserverDatabaseException | RenderEngineException e) {
				LOGGER.error("", e);
			} catch (IfcModelInterfaceException e) {
				LOGGER.error("", e);
			}
		}
		return generateGeometryResult;
	}
	
	private byte[] floatArrayToByteArray(float[] vertices) {
		if (vertices == null) {
			return null;
		}
		ByteBuffer buffer = ByteBuffer.wrap(new byte[vertices.length * 4]);
		buffer.order(ByteOrder.LITTLE_ENDIAN);
		FloatBuffer asFloatBuffer = buffer.asFloatBuffer();
		for (float f : vertices) {
			asFloatBuffer.put(f);
		}
		return buffer.array();
	}

	private byte[] intArrayToByteArray(int[] indices) {
		if (indices == null) {
			return null;
		}
		ByteBuffer buffer = ByteBuffer.wrap(new byte[indices.length * 4]);
		buffer.order(ByteOrder.LITTLE_ENDIAN);
		IntBuffer asIntBuffer = buffer.asIntBuffer();
		for (int i : indices) {
			asIntBuffer.put(i);
		}
		return buffer.array();
	}
	
	private void setTransformationMatrix(GeometryInfo geometryInfo, double[] transformationMatrix) {
		ByteBuffer byteBuffer = ByteBuffer.allocate(16 * 8);
		byteBuffer.order(ByteOrder.nativeOrder());
		DoubleBuffer asDoubleBuffer = byteBuffer.asDoubleBuffer();
		for (double f : transformationMatrix) {
			asDoubleBuffer.put(f);
		}
		geometryInfo.setTransformation(byteBuffer.array());
	}
	
	private Vector3f createVector3f(PackageMetaData packageMetaData, IfcModelInterface model, double defaultValue) throws BimserverDatabaseException, IfcModelInterfaceException {
		Vector3f vector3f = null;
		vector3f = GeometryFactory.eINSTANCE.createVector3f();
		vector3f.setX(defaultValue);
		vector3f.setY(defaultValue);
		vector3f.setZ(defaultValue);
		return vector3f;
	}
	
	private int hash(GeometryData geometryData) {
		int hashCode = 0;
		if (geometryData.getIndices() != null) {
			hashCode += Arrays.hashCode(geometryData.getIndices());
		}
		if (geometryData.getVertices() != null) {
			hashCode += Arrays.hashCode(geometryData.getVertices());
		}
		if (geometryData.getNormals() != null) {
			hashCode += Arrays.hashCode(geometryData.getNormals());
		}
		if (geometryData.getMaterialIndices() != null) {
			hashCode += Arrays.hashCode(geometryData.getMaterialIndices());
		}
		if (geometryData.getMaterials() != null) {
			hashCode += Arrays.hashCode(geometryData.getMaterials());
		}
		return hashCode;
	}
	
	private void processExtends(GeometryInfo geometryInfo, double[] transformationMatrix, float[] vertices, int index, GenerateGeometryResult generateGeometryResult) {
		double x = vertices[index];
		double y = vertices[index + 1];
		double z = vertices[index + 2];
		double[] result = new double[4];
		Matrix.multiplyMV(result, 0, transformationMatrix, 0, new double[] { x, y, z, 1 }, 0);
		x = result[0];
		y = result[1];
		z = result[2];
		geometryInfo.getMinBounds().setX(Math.min(x, geometryInfo.getMinBounds().getX()));
		geometryInfo.getMinBounds().setY(Math.min(y, geometryInfo.getMinBounds().getY()));
		geometryInfo.getMinBounds().setZ(Math.min(z, geometryInfo.getMinBounds().getZ()));
		geometryInfo.getMaxBounds().setX(Math.max(x, geometryInfo.getMaxBounds().getX()));
		geometryInfo.getMaxBounds().setY(Math.max(y, geometryInfo.getMaxBounds().getY()));
		geometryInfo.getMaxBounds().setZ(Math.max(z, geometryInfo.getMaxBounds().getZ()));

		generateGeometryResult.getMinBounds().setX(Math.min(x, generateGeometryResult.getMinBounds().getX()));
		generateGeometryResult.getMinBounds().setY(Math.min(y, generateGeometryResult.getMinBounds().getY()));
		generateGeometryResult.getMinBounds().setZ(Math.min(z, generateGeometryResult.getMinBounds().getZ()));
		generateGeometryResult.getMaxBounds().setX(Math.max(x, generateGeometryResult.getMaxBounds().getX()));
		generateGeometryResult.getMaxBounds().setY(Math.max(y, generateGeometryResult.getMaxBounds().getY()));
		generateGeometryResult.getMaxBounds().setZ(Math.max(z, generateGeometryResult.getMaxBounds().getZ()));
	}
}