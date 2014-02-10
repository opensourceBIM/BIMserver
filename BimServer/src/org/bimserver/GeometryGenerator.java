package org.bimserver;

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
 *****************************************************************************/

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bimserver.database.BimserverDatabaseException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.Query;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.geometry.Matrix;
import org.bimserver.geometry.Vector;
import org.bimserver.models.ifc2x3tc1.GeometryData;
import org.bimserver.models.ifc2x3tc1.GeometryInfo;
import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Factory;
import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package;
import org.bimserver.models.ifc2x3tc1.IfcProduct;
import org.bimserver.models.ifc2x3tc1.IfcWindow;
import org.bimserver.models.ifc2x3tc1.Vector3f;
import org.bimserver.models.store.RenderEnginePluginConfiguration;
import org.bimserver.models.store.Revision;
import org.bimserver.models.store.User;
import org.bimserver.models.store.UserSettings;
import org.bimserver.plugins.PluginConfiguration;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.renderengine.IndexFormat;
import org.bimserver.plugins.renderengine.Precision;
import org.bimserver.plugins.renderengine.RenderEngine;
import org.bimserver.plugins.renderengine.RenderEngineException;
import org.bimserver.plugins.renderengine.RenderEngineGeometry;
import org.bimserver.plugins.renderengine.RenderEngineInstance;
import org.bimserver.plugins.renderengine.RenderEngineInstanceVisualisationProperties;
import org.bimserver.plugins.renderengine.RenderEngineModel;
import org.bimserver.plugins.renderengine.RenderEnginePlugin;
import org.bimserver.plugins.renderengine.RenderEngineSettings;
import org.bimserver.plugins.renderengine.RenderEngineSurfaceProperties;
import org.bimserver.plugins.serializers.Serializer;
import org.bimserver.plugins.serializers.SerializerPlugin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GeometryGenerator {
	private static final Logger LOGGER = LoggerFactory.getLogger(GeometryGenerator.class);
	private static final boolean REUSE_GEOMETRY = false;

	public static class GeometryCacheEntry {
		public GeometryCacheEntry(ByteBuffer verticesBuffer, ByteBuffer normalsBuffer, GeometryInfo geometryInfo) {
			this.vertices = verticesBuffer;
			this.normals = normalsBuffer;
			this.geometryInfo = geometryInfo;
		}

		private ByteBuffer vertices;
		private ByteBuffer normals;
		private GeometryInfo geometryInfo;

		public ByteBuffer getVertices() {
			return vertices;
		}

		public ByteBuffer getNormals() {
			return normals;
		}

		public GeometryInfo getGeometryInfo() {
			return geometryInfo;
		}
	}

	public static class GeometryCache {
		private final Map<Integer, GeometryCacheEntry> cache = new HashMap<Integer, GeometryCacheEntry>();

		public void put(int expressId, GeometryCacheEntry geometryCacheEntry) {
			cache.put(expressId, geometryCacheEntry);
		}

		public boolean isEmpty() {
			return cache.isEmpty();
		}

		public GeometryCacheEntry get(int expressId) {
			return cache.get(expressId);
		}
	}

	public void generateGeometry(long uoid, PluginManager pluginManager, DatabaseSession databaseSession, IfcModelInterface model, int pid, int rid, Revision revision,
			boolean store, GeometryCache geometryCache) throws BimserverDatabaseException, GeometryGeneratingException {
		if (geometryCache != null && !geometryCache.isEmpty()) {
			returnCachedData(model, geometryCache, databaseSession, pid, rid);
			return;
		}
		SerializerPlugin serializerPlugin = (SerializerPlugin) pluginManager.getPlugin("org.bimserver.ifc.step.serializer.IfcStepSerializerPlugin", true);
		Serializer serializer = serializerPlugin.createSerializer(new PluginConfiguration());
		try {
			// Make sure we have minimal express ids
			model.generateMinimalExpressIds();

			serializer.init(model, null, pluginManager, null, false);
			
			// TODO This is not streaming. SerializerInputstream has to be fixed first, then the IfcEngine wrapper should be able to handle streams without knowing the size in advance
			
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			serializer.writeToOutputStream(outputStream);

			User user = (User) databaseSession.get(uoid, Query.getDefault());
			UserSettings userSettings = user.getUserSettings();
			RenderEnginePluginConfiguration defaultRenderEngine = userSettings.getDefaultRenderEngine();
			if (defaultRenderEngine != null) {
				RenderEnginePlugin renderEnginePlugin = pluginManager.getRenderEngine(defaultRenderEngine.getPluginDescriptor().getPluginClassName(), true);
				try {
					RenderEngine renderEngine = renderEnginePlugin.createRenderEngine(new PluginConfiguration());
					renderEngine.init();
					try {
						RenderEngineModel renderEngineModel = renderEngine.openModel(new ByteArrayInputStream(outputStream.toByteArray()), outputStream.size());

						RenderEngineSettings settings = new RenderEngineSettings();
						settings.setPrecision(Precision.SINGLE);
						settings.setIndexFormat(IndexFormat.AUTO_DETECT);
						settings.setGenerateNormals(true);
						settings.setGenerateTriangles(true);
						settings.setGenerateWireFrame(false);
						renderEngineModel.setSettings(settings);
						try {
							RenderEngineSurfaceProperties initializeModelling = renderEngineModel.initializeModelling();
							RenderEngineGeometry renderEngineGeometry = renderEngineModel.finalizeModelling(initializeModelling);
							List<IfcProduct> products = model.getAllWithSubTypes(IfcProduct.class);

							GeometrySimplifier geometrySimplifier = new GeometrySimplifier();
							
							for (IfcProduct ifcProduct : products) {
								RenderEngineInstance renderEngineInstance = renderEngineModel.getInstanceFromExpressId(ifcProduct.getExpressId());
								RenderEngineInstanceVisualisationProperties visualisationProperties = renderEngineInstance.getVisualisationProperties();
								if (visualisationProperties.getPrimitiveCount() > 0) {
									GeometryInfo geometryInfo = null;
									if (store) {
										geometryInfo = databaseSession.create(Ifc2x3tc1Package.eINSTANCE.getGeometryInfo(), pid, rid);
									} else {
										geometryInfo = Ifc2x3tc1Factory.eINSTANCE.createGeometryInfo();
									}
									geometryInfo.setPrimitiveCount(visualisationProperties.getPrimitiveCount());
									geometryInfo.setStartIndex(visualisationProperties.getStartIndex());
									geometryInfo.setStartVertex(visualisationProperties.getStartVertex());
									ByteBuffer verticesBuffer = ByteBuffer.allocate(visualisationProperties.getPrimitiveCount() * 3 * 3 * 4);
									ByteBuffer normalsBuffer = ByteBuffer.allocate(visualisationProperties.getPrimitiveCount() * 3 * 3 * 4);

									convertOrder(verticesBuffer);
									convertOrder(normalsBuffer);
									
									geometryInfo.setMinBounds(createVector3f(Float.POSITIVE_INFINITY, databaseSession, store, pid, rid));
									geometryInfo.setMaxBounds(createVector3f(Float.NEGATIVE_INFINITY, databaseSession, store, pid, rid));
									
									GeometryData geometryData = null;
									if (store) {
										geometryData = databaseSession.create(Ifc2x3tc1Package.eINSTANCE.getGeometryData(), pid, rid);
									} else {
										geometryData = Ifc2x3tc1Factory.eINSTANCE.createGeometryData();
									}
									
									for (int i = geometryInfo.getStartIndex(); i < geometryInfo.getPrimitiveCount() * 3 + geometryInfo.getStartIndex(); i++) {
										processExtends(geometryInfo, renderEngineGeometry, verticesBuffer, normalsBuffer, renderEngineGeometry.getIndex(i) * 3);
									}
									
									geometryInfo.setData(geometryData);
									
									geometryData.setVertices(verticesBuffer.array());
									geometryData.setNormals(normalsBuffer.array());
									if (geometryCache != null) {
										geometryCache.put(ifcProduct.getExpressId(), new GeometryCacheEntry(verticesBuffer, normalsBuffer, geometryInfo));
									}
									if (REUSE_GEOMETRY) {
										GeometryData matchingGeometryData = geometrySimplifier.getMatchingGeometry(ifcProduct, geometryData);
										if (matchingGeometryData != null) {
											reuseGeometry(ifcProduct, geometryInfo, geometryData, matchingGeometryData);
										} else {
											geometrySimplifier.add(ifcProduct, geometryData);
										}
									}
									ifcProduct.setGeometry(geometryInfo);
									if (store) {
										databaseSession.store(ifcProduct, pid, rid);
									}
								}
							}
						} finally {
							renderEngineModel.close();
						}
					} finally {
						renderEngine.close();
					}
				} catch (RenderEngineException e) {
					LOGGER.error("", e);
				}
			}
		} catch (Exception e) {
			LOGGER.error("", e);
			throw new GeometryGeneratingException(e);
		}
	}
	
	private void convertOrder(ByteBuffer input) {
		if (input.order() != ByteOrder.nativeOrder()) {
			input.position(0);
			for (int i = 0; i < input.capacity(); i += 4) {
				input.order(ByteOrder.BIG_ENDIAN);
				float x = input.getFloat();
				input.order(ByteOrder.nativeOrder());
				input.position(input.position() - 4);
				input.putFloat(x);
			}
			input.position(0);
		}
	}

	private boolean almostTheSame(float f1, float f2) {
		return Math.abs(f1 - f2) < 0.01;
	}
	
	private void reuseGeometry(IfcProduct ifcProduct, GeometryInfo geometryInfo, GeometryData geometryData, GeometryData matchingGeometryData) {
		geometryInfo.setData(matchingGeometryData);
		ByteBuffer bb1 = ByteBuffer.wrap(matchingGeometryData.getVertices());
		ByteBuffer bb2 = ByteBuffer.wrap(geometryData.getVertices());
		bb1.order(ByteOrder.nativeOrder());
		bb2.order(ByteOrder.nativeOrder());
		FloatBuffer vertices1 = bb1.asFloatBuffer();
		FloatBuffer vertices2 = bb2.asFloatBuffer();

		float[] v1 = new float[]{vertices1.get(0), vertices1.get(1), vertices1.get(2)};
		float[] u1 = new float[]{vertices2.get(0), vertices2.get(1), vertices2.get(2)};
		float[] v2 = new float[]{vertices1.get(3), vertices1.get(4), vertices1.get(5)};
		float[] u2 = new float[]{vertices2.get(3), vertices2.get(4), vertices2.get(5)};
		float[] v3 = new float[]{vertices1.get(6), vertices1.get(7), vertices1.get(8)};
		float[] u3 = new float[]{vertices2.get(6), vertices2.get(7), vertices2.get(8)};

		float transX = u1[0] - v1[0];
		float transY = u1[1] - v1[1];
		float transZ = u1[2] - v1[2];
		
		float translation[] = new float[16];
		Matrix.setIdentityM(translation, 0);
		Matrix.translateM(translation, 0, u1[0], u1[1], u1[2]);

		float[] toZeroTranslation = new float[16];
		Matrix.setIdentityM(toZeroTranslation, 0);
		Matrix.translateM(toZeroTranslation, 0, -v1[0], -v1[1], -v1[2]);
		
		if (almostTheSame(v2[0] + transX, u2[0]) && almostTheSame(v2[1] + transY, u2[1]) && almostTheSame(v2[2] + transZ, u2[2]) && almostTheSame(v3[0] + transX, u3[0]) && almostTheSame(v3[1] + transY, u3[1]) && almostTheSame(v3[2] + transZ, u3[2])) {
			// The other two points are already the same, to there was no rotation
			addAll(translation, geometryInfo.getTransformation());
			System.out.println("No rotation");
			return;
		}
		
		subtract(u2, u1);
		subtract(u3, u1);
		
		subtract(v2, v1);
		subtract(v3, v1);
		
//		Vector.normalize(v1);
//		Vector.normalize(v2);
//		Vector.normalize(v3);
//		Vector.normalize(u1);
//		Vector.normalize(u2);
//		Vector.normalize(u3);
		
		float[] u2CrossV2 = Vector.crossProduct(u2, v2);
		float[] r2 = new float[16];
		Matrix.setIdentityM(r2, 0);
		float u2InV2 = Vector.dot(u2, v2);
		if (u2CrossV2[0] == 0 && u2CrossV2[1] == 0 && u2CrossV2[2] == 0) {
			float[] h = new float[]{u2[1], -u2[0], 0, 0};
			Matrix.rotateM(r2, 0, -(float) Math.toDegrees(Math.atan2(Vector.length(u2CrossV2), u2InV2)), h[0], h[1], h[2]);
		} else {
			Matrix.rotateM(r2, 0, -(float) Math.toDegrees(Math.atan2(Vector.length(u2CrossV2), u2InV2)), u2CrossV2[0], u2CrossV2[1], u2CrossV2[2]);
		}

		float[] r2v3 = new float[4];
		Matrix.multiplyMV(r2v3, 0, r2, 0, new float[]{v3[0], v3[1], v3[2], 1}, 0);
		
		float[] r3 = new float[16];
		Matrix.setIdentityM(r3, 0);
		float[] r2c3Crossu3 = Vector.crossProduct(r2v3, u3);
		if (u2CrossV2[0] == 0 && u2CrossV2[1] == 0 && u2CrossV2[2] == 0) {
			System.out.println();
		} else {
			Matrix.rotateM(r3, 0, -(float) Math.toDegrees(Math.atan2(Vector.length(r2c3Crossu3), Vector.dot(r2v3, u3))), u2[0], u2[1], u2[2]);
		}

		float[] subResult = new float[16];
		float[] subResult2 = new float[16];
		float[] totalResult = new float[16];
		float[] startMatrix = new float[16];
		Matrix.setIdentityM(startMatrix, 0);
		
		Matrix.multiplyMM(subResult, 0, toZeroTranslation, 0, startMatrix, 0);
		Matrix.multiplyMM(subResult2, 0, r2, 0, subResult, 0);
//		Matrix.multiplyMM(totalResult, 0, r3, 0, subResult, 0);
//		Matrix.translateM(totalResult, 0, v1[0], v1[1], v1[2]);
		Matrix.multiplyMM(totalResult, 0, translation, 0, subResult2, 0);

//		Matrix.dump(totalResult);
		
		addAll(totalResult, geometryInfo.getTransformation());
	}

	private void subtract(float[] u2, float[] v1) {
		u2[0] = u2[0] - v1[0];
		u2[1] = u2[1] - v1[1];
		u2[2] = u2[2] - v1[2];
	}

	private void reuseGeometryOld(GeometryInfo geometryInfo, GeometryData geometryData, GeometryData matchingGeometryData) {
		geometryInfo.setData(matchingGeometryData);
		ByteBuffer bb1 = ByteBuffer.wrap(matchingGeometryData.getVertices());
		ByteBuffer bb2 = ByteBuffer.wrap(geometryData.getVertices());
		bb1.order(ByteOrder.nativeOrder());
		bb2.order(ByteOrder.nativeOrder());
		FloatBuffer vertices1 = bb1.asFloatBuffer();
		FloatBuffer vertices2 = bb2.asFloatBuffer();
		float translation[] = new float[16];
		translation[0] = 1;
		translation[5] = 1;
		translation[10] = 1;
		translation[15] = 1;
		translation[3] = vertices2.get(0) - vertices1.get(0);
		translation[7] = vertices2.get(1) - vertices1.get(1);
		translation[11] = vertices2.get(2) - vertices1.get(2);

//		addAll(translation, geometryInfo.getTransformation());
		
		float[] v1 = new float[]{vertices1.get(0) - vertices1.get(3), vertices1.get(1) - vertices1.get(4), vertices1.get(2) - vertices1.get(5)};
		float[] v2 = new float[]{vertices2.get(0) - vertices2.get(3), vertices2.get(1) - vertices2.get(4), vertices2.get(2) - vertices2.get(5)};
		Vector.normalize(v1);
		Vector.normalize(v2);

		float[] v3 = new float[]{vertices1.get(6) - vertices1.get(3), vertices1.get(7) - vertices1.get(4), vertices1.get(8) - vertices1.get(5)};
		float[] v4 = new float[]{vertices2.get(6) - vertices2.get(3), vertices2.get(7) - vertices2.get(4), vertices2.get(8) - vertices2.get(5)};
		Vector.normalize(v3);
		Vector.normalize(v4);
		
		float[] rotationMatrix1 = alignVectors(v2, v1);
		
		float[] v3rotated = new float[4];
		float[] v4rotated = new float[4];
		Matrix.multiplyMV(v3rotated, 0, rotationMatrix1, 0, new float[]{v3[0], v3[1], v3[2], 1}, 0);
		Matrix.multiplyMV(v4rotated, 0, rotationMatrix1, 0, new float[]{v4[0], v4[1], v4[2], 1}, 0);
		
		Vector.normalize(v3rotated);
		Vector.normalize(v4rotated);
		
		float[] rotationMatrix2 = alignVectors(v4rotated, v3rotated);

		float[] subResult = new float[16];
		float[] totalResult = new float[16];
		Matrix.multiplyMM(subResult, 0, rotationMatrix1, 0, translation, 0);
		Matrix.multiplyMM(totalResult, 0, rotationMatrix2, 0, subResult, 0);

		addAll(totalResult, geometryInfo.getTransformation());
	}
	
	public static void main(String[] args) {
		float[] v1 = new float[]{1, 1, 0};
		float[] v2 = new float[]{0, 1, 0};
		Vector.normalize(v1);
		Vector.normalize(v2);
		
		float[] matrix = alignVectors(v1, v2);
		
		float[] test = new float[4];
		Matrix.multiplyMV(test, 0, matrix, 0, new float[]{v2[0], v2[1], v2[2], 1}, 0);
		
		Vector.dump(v1);
		Vector.dump(test);
		Vector.dump(v2);
	}
	
	private static float[] alignVectors(float[] v1, float[] v2) {
		float[] v3 = Vector.crossProduct(v1, v2);
		Vector.normalize(v3);
		if (Float.isNaN(v3[0]) || Float.isNaN(v3[1]) || Float.isNaN(v3[2])) {
			// Probably already aligned...
			float[] result = new float[16];
			Matrix.setIdentityM(result, 0);
			return result;
		}

		float[] v4 = Vector.crossProduct(v3, v1);
		
		float[] m1 = new float[]{v1[0], v1[1], v1[2], 0,
								v4[0], v4[1], v4[2], 0, 
								v3[0], v3[1], v3[2], 0, 
								0, 0, 0, 1};
		
		float cos = Vector.dot(v2, v1);
		float sin = Vector.dot(v2, v4);
		
		float[] m2 = new float[]{cos, sin, 0, 0,
								 -sin, cos, 0, 0,
								 0, 0, 1, 0,
								 0, 0, 0, 1};
		
		float[] result = new float[16];
		Matrix.multiplyMM(result, 0, m2, 0, m1, 0);
		
		float[] invertedM1 = new float[16];
		Matrix.invertM(invertedM1, 0, m1, 0);
		
		float[] rotation = new float[16];
		Matrix.multiplyMM(rotation, 0, invertedM1, 0, result, 0);
		
		return rotation;
	}

	private void addAll(float[] floats, List<Float> list) {
		for (int i=0; i<floats.length; i++) {
			if (Float.isNaN(floats[i])) {
				System.out.println();
			}
			list.add(floats[i]);
		}
	}

	private void returnCachedData(IfcModelInterface model, GeometryCache geometryCache, DatabaseSession databaseSession, int pid, int rid) throws BimserverDatabaseException {
		for (IfcProduct ifcProduct : model.getAllWithSubTypes(IfcProduct.class)) {
			GeometryCacheEntry geometryCacheEntry = geometryCache.get(ifcProduct.getExpressId());
			if (geometryCacheEntry != null) {
				GeometryData geometryData = databaseSession.create(Ifc2x3tc1Package.eINSTANCE.getGeometryData(), pid, rid);
				geometryData.setVertices(geometryCacheEntry.getVertices().array());
				geometryData.setNormals(geometryCacheEntry.getNormals().array());
				GeometryInfo geometryInfo = databaseSession.create(Ifc2x3tc1Package.eINSTANCE.getGeometryInfo(), pid, rid);
				Vector3f min = databaseSession.create(Ifc2x3tc1Package.eINSTANCE.getVector3f(), pid, rid);
				min.setX(geometryCacheEntry.getGeometryInfo().getMinBounds().getX());
				min.setY(geometryCacheEntry.getGeometryInfo().getMinBounds().getY());
				min.setZ(geometryCacheEntry.getGeometryInfo().getMinBounds().getZ());
				Vector3f max = databaseSession.create(Ifc2x3tc1Package.eINSTANCE.getVector3f(), pid, rid);
				max.setX(geometryCacheEntry.getGeometryInfo().getMaxBounds().getX());
				max.setY(geometryCacheEntry.getGeometryInfo().getMaxBounds().getY());
				max.setZ(geometryCacheEntry.getGeometryInfo().getMaxBounds().getZ());
				geometryInfo.setMinBounds(min);
				geometryInfo.setMaxBounds(max);
				geometryInfo.setData(geometryData);
				ifcProduct.setGeometry(geometryInfo);
			}
		}
	}

	private Vector3f createVector3f(float defaultValue, DatabaseSession session, boolean store, int pid, int rid) throws BimserverDatabaseException {
		Vector3f vector3f = null;
		if (store) {
			vector3f = (Vector3f) session.create(Ifc2x3tc1Package.eINSTANCE.getVector3f(), pid, rid);
		} else {
			vector3f = Ifc2x3tc1Factory.eINSTANCE.createVector3f();
		}
		vector3f.setX(defaultValue);
		vector3f.setY(defaultValue);
		vector3f.setZ(defaultValue);
		return vector3f;
	}

	private void processExtends(GeometryInfo geometryInfo, RenderEngineGeometry geometry, ByteBuffer verticesBuffer, ByteBuffer normalsBuffer, int index) {
		float x = geometry.getVertex(index);
		float y = geometry.getVertex(index + 1);
		float z = geometry.getVertex(index + 2);
		verticesBuffer.putFloat(x);
		verticesBuffer.putFloat(y);
		verticesBuffer.putFloat(z);
		normalsBuffer.putFloat(geometry.getNormal(index));
		normalsBuffer.putFloat(geometry.getNormal(index + 1));
		normalsBuffer.putFloat(geometry.getNormal(index + 2));
		geometryInfo.getMinBounds().setX(Math.min(x, geometryInfo.getMinBounds().getX()));
		geometryInfo.getMinBounds().setY(Math.min(y, geometryInfo.getMinBounds().getY()));
		geometryInfo.getMinBounds().setZ(Math.min(z, geometryInfo.getMinBounds().getZ()));
		geometryInfo.getMaxBounds().setX(Math.max(x, geometryInfo.getMaxBounds().getX()));
		geometryInfo.getMaxBounds().setY(Math.max(y, geometryInfo.getMaxBounds().getY()));
		geometryInfo.getMaxBounds().setZ(Math.max(z, geometryInfo.getMaxBounds().getZ()));
	}
}