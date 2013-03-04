package org.bimserver;

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
 *****************************************************************************/

import java.io.ByteArrayInputStream;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

import org.apache.tomcat.util.http.fileupload.ByteArrayOutputStream;
import org.bimserver.database.BimserverDatabaseException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.Query;
import org.bimserver.emf.IfcModelInterface;
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
import org.bimserver.plugins.serializers.Serializer;
import org.bimserver.plugins.serializers.SerializerException;
import org.bimserver.plugins.serializers.SerializerPlugin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GeometryGenerator {
	private static final Logger LOGGER = LoggerFactory.getLogger(GeometryGenerator.class);

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
			boolean store, GeometryCache geometryCache) throws BimserverDatabaseException {
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
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			serializer.writeToOutputStream(outputStream);

			User user = (User) databaseSession.get(uoid, Query.getDefault());
			UserSettings userSettings = user.getUserSettings();
			RenderEnginePluginConfiguration defaultRenderEngine = userSettings.getDefaultRenderEngine();
			if (defaultRenderEngine != null) {
				RenderEnginePlugin renderEnginePlugin = pluginManager.getRenderEngine(defaultRenderEngine.getClassName(), true);
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
							RenderEngineGeometry renderEngineGeometry = renderEngineModel.finalizeModelling(renderEngineModel.initializeModelling());
							for (IfcProduct ifcProduct : model.getAllWithSubTypes(IfcProduct.class)) {
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
									ifcProduct.setGeometry(geometryInfo);
									if (store) {
										databaseSession.store(ifcProduct, pid, rid);
									}
									if (geometryCache != null) {
										geometryCache.put(ifcProduct.getExpressId(), new GeometryCacheEntry(verticesBuffer, normalsBuffer, geometryInfo));
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
		} catch (SerializerException e) {
			LOGGER.error("", e);
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