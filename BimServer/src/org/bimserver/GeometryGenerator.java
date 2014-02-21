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
import java.util.Random;
import java.util.Set;

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
	private static final boolean REUSE_GEOMETRY = true;

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
									
									verticesBuffer.order(ByteOrder.LITTLE_ENDIAN);
									normalsBuffer.order(ByteOrder.LITTLE_ENDIAN);

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
									float[] identityMatrix = new float[16];
									Matrix.setIdentityM(identityMatrix, 0);
									setTransformationMatrix(geometryInfo, identityMatrix);
									if (REUSE_GEOMETRY) {
										geometrySimplifier.add(ifcProduct, geometryData);
									}
									ifcProduct.setGeometry(geometryInfo);
									if (store) {
										databaseSession.store(ifcProduct, pid, rid);
									}
								}
							}
							if (REUSE_GEOMETRY) {
								for (IfcProduct ifcProduct : products) {
									if (ifcProduct.getGeometry() != null && ifcProduct.getGeometry().getData() != null) {
										Set<GeometryData> matchingGeometryDatas = geometrySimplifier.getMatchingGeometry(ifcProduct, ifcProduct.getGeometry().getData());
										for (GeometryData matchingGeometryData : matchingGeometryDatas) {
											if (reuseGeometry(ifcProduct, ifcProduct.getGeometry(), ifcProduct.getGeometry().getData(), matchingGeometryData)) {
												break;
											}
										}
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
	
	private void setTransformationMatrix(GeometryInfo geometryInfo, float[] transformationMatrix) {
		ByteBuffer byteBuffer = ByteBuffer.allocate(16 * 4);
		byteBuffer.order(ByteOrder.nativeOrder());
		FloatBuffer asFloatBuffer = byteBuffer.asFloatBuffer();
		for (float f : transformationMatrix) {
			asFloatBuffer.put(f);
		}
		geometryInfo.setTransformation(byteBuffer.array());
	}

	private static boolean almostTheSame(float f1, float f2, float maxDiff) {
		return Math.abs(f1 - f2) < maxDiff;
	}
	
	private boolean reuseGeometry(IfcProduct ifcProduct, GeometryInfo geometryInfo, GeometryData geometryData, GeometryData matchingGeometryData) {
		double distanceFromCorners = Math.sqrt(Math.pow(geometryInfo.getMaxBounds().getX() - geometryInfo.getMinBounds().getX(), 2) + Math.pow(geometryInfo.getMaxBounds().getY() - geometryInfo.getMinBounds().getY(), 2) + Math.pow(geometryInfo.getMaxBounds().getZ() - geometryInfo.getMinBounds().getZ(), 2));
		float maxDiff = (float) (distanceFromCorners / 100.0);
		
		ByteBuffer bb1 = ByteBuffer.wrap(matchingGeometryData.getVertices());
		ByteBuffer bb2 = ByteBuffer.wrap(geometryData.getVertices());
		bb1.order(ByteOrder.LITTLE_ENDIAN);
		bb2.order(ByteOrder.LITTLE_ENDIAN);
		FloatBuffer vertices1 = bb1.asFloatBuffer();
		FloatBuffer vertices2 = bb2.asFloatBuffer();

		float[] v1 = new float[]{vertices1.get(0), vertices1.get(1), vertices1.get(2)};
		float[] u1 = new float[]{vertices2.get(0), vertices2.get(1), vertices2.get(2)};
		float[] v2 = new float[]{vertices1.get(3), vertices1.get(4), vertices1.get(5)};
		float[] u2 = new float[]{vertices2.get(3), vertices2.get(4), vertices2.get(5)};
		float[] v3 = new float[]{vertices1.get(6), vertices1.get(7), vertices1.get(8)};
		float[] u3 = new float[]{vertices2.get(6), vertices2.get(7), vertices2.get(8)};

		float[] totalResult = getTransformationMatrix(v1, v2, v3, u1, u2, u3, maxDiff);
		if (totalResult == null) {
			return false;
		}

		float[] r = new float[4];
		Matrix.multiplyMV(r, 0, totalResult, 0, new float[]{v1[0], v1[1], v1[2], 1}, 0);
		
		if (almostTheSame(r[0] - v1[0], u1[0], maxDiff) && almostTheSame(r[1] - v1[1], u1[1], maxDiff) && almostTheSame(r[2] - v1[2], u1[2], maxDiff)) {
			// Interesting
			Matrix.translateM(totalResult, 0, -v1[0], -v1[1], -v1[2]);
		}
		
		if (test(v1, u1, totalResult, maxDiff)) {
			geometryInfo.setData(matchingGeometryData);
			setTransformationMatrix(geometryInfo, totalResult);
			return true;
		}
		return false;
	}

	/**
	 * This function should return a transformation matrix (with translation and rotation, no scaling) overlaying triangle V on U
	 * Assumed is that the triangles are indeed the same and the order of the vertices is also the same (shifts are not allowed)
	 * This function can probably be optimized for speed and also the LOC can probably be reduced
	 * 
	 * @param originalV1
	 * @param originalV2
	 * @param originalV3
	 * @param u1
	 * @param u2
	 * @param u3
	 * @return
	 */
	private static float[] getTransformationMatrix(float[] originalV1, float[] originalV2, float[] originalV3, float[] u1, float[] u2, float[] u3, float maxDiff) {
		float[] v1 = copy(originalV1);
		float[] v2 = copy(originalV2);
		float[] v3 = copy(originalV3);
		u1 = copy(u1);
		u2 = copy(u2);
		u3 = copy(u3);

		float transX = u1[0] - v1[0];
		float transY = u1[1] - v1[1];
		float transZ = u1[2] - v1[2];
		
		float translation[] = new float[16];
		Matrix.setIdentityM(translation, 0);
		Matrix.translateM(translation, 0, u1[0], u1[1], u1[2]);

		float[] toZeroTranslation = new float[16];
		Matrix.setIdentityM(toZeroTranslation, 0);
		Matrix.translateM(toZeroTranslation, 0, -v1[0], -v1[1], -v1[2]);
		
		if (almostTheSame(v2[0] + transX, u2[0], maxDiff) && almostTheSame(v2[1] + transY, u2[1], maxDiff) && almostTheSame(v2[2] + transZ, u2[2], maxDiff) && almostTheSame(v3[0] + transX, u3[0], maxDiff) && almostTheSame(v3[1] + transY, u3[1], maxDiff) && almostTheSame(v3[2] + transZ, u3[2], maxDiff)) {
			// The other two points are already the same, to there was no rotation
			return translation;
		}
		
		// Normalize both triangles to their first vertex
		subtract(u2, u1);
		subtract(u3, u1);
		subtract(u1, u1);
		
		subtract(v2, v1);
		subtract(v3, v1);
		subtract(v1, v1);
		
		float[] u2CrossV2 = Vector.crossProduct(u2, v2);
		float[] r2 = new float[16];
		Matrix.setIdentityM(r2, 0);
		float[] r2v2 = new float[4];
		if (!equalsAlmost(u2, v2, maxDiff)) {
			float u2InV2 = Vector.dot(u2, v2);
			float[] axis = u2CrossV2; 
			if (axis[0] == 0 && axis[1] == 0 && axis[2] == 0) {
				axis = new float[]{u2[1], -u2[0], 0, 0};
			}
			Matrix.rotateM(r2, 0, (float) Math.toDegrees(Math.atan2(Vector.length(u2CrossV2), u2InV2)), axis[0], axis[1], axis[2]);

			Matrix.multiplyMV(r2v2, 0, r2, 0, new float[]{v2[0], v2[1], v2[2], 1}, 0);
			
			if (!equalsAlmost(r2v2, u2, maxDiff)) {
				Matrix.setIdentityM(r2, 0);
				Matrix.rotateM(r2, 0, -(float) Math.toDegrees(Math.atan2(Vector.length(u2CrossV2), u2InV2)), axis[0], axis[1], axis[2]);
				Matrix.multiplyMV(r2v2, 0, r2, 0, new float[]{v2[0], v2[1], v2[2], 1}, 0);
				if (!equalsAlmost(r2v2, u2, maxDiff)) {
					return null;
				}
			}
		} else {
			r2v2 = copy(v2);
		}
		
		float[] r2v3 = new float[4];
		Matrix.multiplyMV(r2v3, 0, r2, 0, new float[]{v3[0], v3[1], v3[2], 1}, 0);

		float[] r3 = new float[16];
		Matrix.setIdentityM(r3, 0);
		
		float angleDegrees = (float) Math.toDegrees(getPlaneAngle(v1, r2v2, r2v3, u1, u2, u3));
		
		Matrix.rotateM(r3, 0, angleDegrees, r2v2[0], r2v2[1], r2v2[2]);
		
		float[] r3v3 = new float[4];
		Matrix.multiplyMV(r3v3, 0, r3, 0, new float[]{r2v3[0], r2v3[1], r2v3[2], 1}, 0);

		float[] r2v1 = new float[4];
		Matrix.multiplyMV(r2v1, 0, r2, 0, new float[]{v1[0], v1[1], v1[2], 1}, 0);

		float[] r3v1 = new float[4];
		Matrix.multiplyMV(r3v1, 0, r3, 0, new float[]{r2v1[0], r2v1[1], r2v1[2], 1}, 0);
		
		if (!equalsAlmost(r3v3, u3, maxDiff)) {
			Matrix.setIdentityM(r3, 0);
			Matrix.rotateM(r3, 0, -angleDegrees, r2v2[0], r2v2[1], r2v2[2]);
			Matrix.multiplyMV(r3v3, 0, r3, 0, new float[]{r2v3[0], r2v3[1], r2v3[2], 1}, 0);
			float[] r3v2 = new float[4];
			Matrix.multiplyMV(r3v2, 0, r3, 0, new float[]{r2v2[0], r2v2[1], r2v2[2], 1}, 0);
			if (!equalsAlmost(r3v3, u3, maxDiff) || !equalsAlmost(r3v2, u2, maxDiff)) {
				return null;
			}
		}
		float[] subResult = new float[16];
		float[] subResult2 = new float[16];
		float[] subResult3 = new float[16];
		float[] totalResult = new float[16];
		float[] startMatrix = new float[16];
		Matrix.setIdentityM(startMatrix, 0);
		
		Matrix.multiplyMM(subResult, 0, toZeroTranslation, 0, startMatrix, 0);
		Matrix.multiplyMM(subResult2, 0, r2, 0, subResult, 0);
		Matrix.multiplyMM(subResult3, 0, r3, 0, subResult2, 0);
		Matrix.multiplyMM(totalResult, 0, translation, 0, subResult3, 0);		
		
		return totalResult;
	}

	/**
	 * Get the angle in radians between two planes
	 * 
	 * @param v1
	 * @param v2
	 * @param v3
	 * @param u1
	 * @param u2
	 * @param u3
	 * @return
	 */
	private static double getPlaneAngle(float[] v1, float[] v2, float[] v3, float[] u1, float[] u2, float[] u3) {
		float[] cross1 = Vector.crossProduct(new float[]{v2[0] - v1[0], v2[1] - v1[1], v2[2] - v1[2]}, new float[]{v3[0] - v1[0], v3[1] - v1[1], v3[2] - v1[2]});
		float[] cross2 = Vector.crossProduct(new float[]{u2[0] - u1[0], u2[1] - u1[1], u2[2] - u1[2]}, new float[]{u3[0] - u1[0], u3[1] - u1[1], u3[2] - u1[2]});
		
		float num = Vector.dot(cross1, cross2);
		float den = Vector.length(cross1) * Vector.length(cross2);
		
		float a = num / den;
		if (a > 1) {
			a = 1;
		}
		if (a < -1) {
			a = -1;
		}
		double result = Math.acos(a);
		
		if (Double.isNaN(result)) {
			System.out.println();
		}
		return result;
	}

	private static boolean equalsAlmost(float[] r2v2, float[] u2, float maxDiff) {
		for (int i=0; i<3; i++) {
			if (!almostTheSame(r2v2[i], u2[i], maxDiff)) {
				return false;
			}
		}
		return true;
	}

	private static float[] copy(float[] v1) {
		float[] result = new float[v1.length];
		System.arraycopy(v1, 0, result, 0, v1.length);
		return result;
	}

	private static boolean test(float[] v1, float[] v2, float[] transformationMatrix, float maxDiff) {
		float[] resultVector = new float[4];
		Matrix.multiplyMV(resultVector, 0, transformationMatrix, 0, new float[]{v1[0], v1[1], v1[2], 1}, 0);
		normalize(resultVector);
		boolean theSame = true;
		for (int i=0; i<3; i++) {
			if (!almostTheSame(resultVector[i], v2[i], maxDiff)) {
				theSame = false;
			}
		}
		if (!theSame) {
			System.out.println("Difference");
			Vector.dump("Was", v1);
			Vector.dump("Became", resultVector);
			Vector.dump("Should be", v2);
			System.out.println();
			return false;
		}
		return true;
	}

	private static void normalize(float[] resultVector) {
		resultVector[0] = resultVector[0] * resultVector[3];
		resultVector[1] = resultVector[1] * resultVector[3];
		resultVector[2] = resultVector[2] * resultVector[3];
		resultVector[3] = 1;
	}

	private static void subtract(float[] u2, float[] v1) {
		u2[0] = u2[0] - v1[0];
		u2[1] = u2[1] - v1[1];
		u2[2] = u2[2] - v1[2];
	}

	public static void main(String[] args) {
		float maxDiff = 0.1f;
		
		test1(maxDiff);
		test2(maxDiff);
		
		Random random = new Random();
		for (int i=0; i<10; i++) {
			float[] matrix = new float[16];
			Matrix.setIdentityM(matrix, 0);
			for (int j=0; j<10; j++) {
				Matrix.rotateM(matrix, 0, random.nextFloat() * 360, random.nextFloat(), random.nextFloat(), random.nextFloat());
			}

			float[] v1 = new float[]{random.nextFloat(), random.nextFloat(), random.nextFloat(), 1};
			float[] v2 = new float[]{random.nextFloat(), random.nextFloat(), random.nextFloat(), 1};
			float[] v3 = new float[]{random.nextFloat(), random.nextFloat(), random.nextFloat(), 1};
			float[] r1 = new float[4];
			float[] r2 = new float[4];
			float[] r3 = new float[4];
			Matrix.multiplyMV(r1, 0, matrix, 0, v1, 0);
			Matrix.multiplyMV(r2, 0, matrix, 0, v2, 0);
			Matrix.multiplyMV(r3, 0, matrix, 0, v3, 0);
			
			float[] calculatedMatrix = getTransformationMatrix(v1, v2, v3, r1, r2, r3, maxDiff);
			
			test(v1, r1, calculatedMatrix, maxDiff);
			test(v2, r2, calculatedMatrix, maxDiff);
			test(v3, r3, calculatedMatrix, maxDiff);
			
			for (int j=0; j<10; j++) {
				float[] q1 = new float[]{random.nextFloat(), random.nextFloat(), random.nextFloat(), 1};
				float[] q2 = new float[]{random.nextFloat(), random.nextFloat(), random.nextFloat(), 1};
				float[] q3 = new float[]{random.nextFloat(), random.nextFloat(), random.nextFloat(), 1};
				float[] b1 = new float[4];
				float[] b2 = new float[4];
				float[] b3 = new float[4];
				Matrix.multiplyMV(b1, 0, matrix, 0, q1, 0);
				Matrix.multiplyMV(b2, 0, matrix, 0, q2, 0);
				Matrix.multiplyMV(b3, 0, matrix, 0, q3, 0);
				
				test(q1, b1, calculatedMatrix, maxDiff);
				test(q2, b2, calculatedMatrix, maxDiff);
				test(q3, b3, calculatedMatrix, maxDiff);
			}
		}
	}

	private static void test1(float maxDiff) {
		float[] v1 = new float[]{1, 2, 0};
		float[] v2 = new float[]{1, 1, 0};
		float[] v3 = new float[]{3, 2, 0};
		float[] u1 = new float[]{0, 2, 0};
		float[] u2 = new float[]{-1, 2, 0};
		float[] u3 = new float[]{0, 2, 2};
		
		float[] transformationMatrix = getTransformationMatrix(v1, v2, v3, u1, u2, u3, maxDiff);
		
		test(v1, u1, transformationMatrix, maxDiff);
		test(v2, u2, transformationMatrix, maxDiff);
		test(v3, u3, transformationMatrix, maxDiff);
	}
	
	private static void test2(float maxDiff) {
		float[] v1 = new float[]{3, 0, 0};
		float[] v2 = new float[]{4, 0, 0};
		float[] v3 = new float[]{4, 1, 0};
		float[] u1 = new float[]{1, 3, 0};
		float[] u2 = new float[]{0, 3, 0};
		float[] u3 = new float[]{0, 2, 0};
		
		float[] transformationMatrix = getTransformationMatrix(v1, v2, v3, u1, u2, u3, maxDiff);
		
		test(v1, u1, transformationMatrix, maxDiff);
		test(v2, u2, transformationMatrix, maxDiff);
		test(v3, u3, transformationMatrix, maxDiff);
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