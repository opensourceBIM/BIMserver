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
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.apache.tomcat.util.http.fileupload.ByteArrayOutputStream;
import org.bimserver.database.BimserverDatabaseException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.Query;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.models.ifc2x3tc1.Bounds;
import org.bimserver.models.ifc2x3tc1.GeometryInstance;
import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Factory;
import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package;
import org.bimserver.models.ifc2x3tc1.IfcProduct;
import org.bimserver.models.ifc2x3tc1.Vector3f;
import org.bimserver.models.store.IfcEnginePluginConfiguration;
import org.bimserver.models.store.Revision;
import org.bimserver.models.store.User;
import org.bimserver.models.store.UserSettings;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.ifcengine.IfcEngine;
import org.bimserver.plugins.ifcengine.IfcEngineException;
import org.bimserver.plugins.ifcengine.IfcEngineGeometry;
import org.bimserver.plugins.ifcengine.IfcEngineInstance;
import org.bimserver.plugins.ifcengine.IfcEngineInstanceVisualisationProperties;
import org.bimserver.plugins.ifcengine.IfcEngineModel;
import org.bimserver.plugins.ifcengine.IfcEnginePlugin;
import org.bimserver.plugins.ifcengine.IfcEngineSettings;
import org.bimserver.plugins.ifcengine.IndexFormat;
import org.bimserver.plugins.ifcengine.Precision;
import org.bimserver.plugins.serializers.PluginConfiguration;
import org.bimserver.plugins.serializers.Serializer;
import org.bimserver.plugins.serializers.SerializerException;
import org.bimserver.plugins.serializers.SerializerPlugin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GeometryGenerator {
	private static final Logger LOGGER = LoggerFactory.getLogger(GeometryGenerator.class);

	public static class GeometryCacheEntry {
		public GeometryCacheEntry(ByteBuffer verticesBuffer, ByteBuffer normalsBuffer, Bounds instanceBounds) {
			vertices = verticesBuffer;
			normals = normalsBuffer;
			bounds = instanceBounds;
		}

		private ByteBuffer vertices;
		private ByteBuffer normals;
		private Bounds bounds;

		public ByteBuffer getVertices() {
			return vertices;
		}

		public ByteBuffer getNormals() {
			return normals;
		}

		public Bounds getBounds() {
			return bounds;
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
		Collection<SerializerPlugin> allSerializerPlugins = pluginManager.getAllSerializerPlugins("application/ifc", true);
		if (!allSerializerPlugins.isEmpty()) {
			SerializerPlugin serializerPlugin = allSerializerPlugins.iterator().next();
			Serializer serializer = serializerPlugin.createSerializer(new PluginConfiguration());
			try {
				// Make sure we have minimal express ids
				model.generateMinimalExpressIds();

				serializer.init(model, null, pluginManager, null, false);
				ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
				serializer.writeToOutputStream(outputStream);

				User user = (User) databaseSession.get(uoid, Query.getDefault());
				UserSettings userSettings = user.getUserSettings();
				IfcEnginePluginConfiguration defaultIfcEngine = userSettings.getDefaultIfcEngine();
				if (defaultIfcEngine != null) {
					IfcEnginePlugin ifcEnginePlugin = pluginManager.getIfcEngine(defaultIfcEngine.getClassName(), true);
					try {
						IfcEngine ifcEngine = ifcEnginePlugin.createIfcEngine(new PluginConfiguration());
						ifcEngine.init();
						try {
							IfcEngineModel ifcEngineModel = ifcEngine.openModel(new ByteArrayInputStream(outputStream.toByteArray()), outputStream.size());

							IfcEngineSettings settings = new IfcEngineSettings();

							settings.setPrecision(Precision.SINGLE);
							settings.setIndexFormat(IndexFormat.AUTO_DETECT);
							settings.setGenerateNormals(true);
							settings.setGenerateTriangles(true);
							settings.setGenerateWireFrame(false);
							ifcEngineModel.setSettings(settings);
							try {
								IfcEngineGeometry ifcEngineGeometry = ifcEngineModel.finalizeModelling(ifcEngineModel.initializeModelling());
								for (IfcProduct ifcProduct : model.getAllWithSubTypes(IfcProduct.class)) {
									IfcEngineInstance ifcEngineInstance = ifcEngineModel.getInstanceFromExpressId(ifcProduct.getExpressId());
									IfcEngineInstanceVisualisationProperties visualisationProperties = ifcEngineInstance.getVisualisationProperties();
									if (visualisationProperties.getPrimitiveCount() > 0) {
										GeometryInstance geometryInstance = null;
										if (store) {
											geometryInstance = databaseSession.create(Ifc2x3tc1Package.eINSTANCE.getGeometryInstance(), pid, rid);
										} else {
											geometryInstance = Ifc2x3tc1Factory.eINSTANCE.createGeometryInstance();
										}
										geometryInstance.setPrimitiveCount(visualisationProperties.getPrimitiveCount());
										geometryInstance.setStartIndex(visualisationProperties.getStartIndex());
										geometryInstance.setStartVertex(visualisationProperties.getStartVertex());
										ByteBuffer verticesBuffer = ByteBuffer.allocate(visualisationProperties.getPrimitiveCount() * 3 * 3 * 4);
										ByteBuffer normalsBuffer = ByteBuffer.allocate(visualisationProperties.getPrimitiveCount() * 3 * 3 * 4);
										Bounds instanceBounds = null;
										if (store) {
											instanceBounds = databaseSession.create(Ifc2x3tc1Package.eINSTANCE.getBounds(), pid, rid);
										} else {
											instanceBounds = Ifc2x3tc1Factory.eINSTANCE.createBounds();
										}
										instanceBounds.setMin(createVector3f(Float.POSITIVE_INFINITY, databaseSession, store, pid, rid));
										instanceBounds.setMax(createVector3f(Float.NEGATIVE_INFINITY, databaseSession, store, pid, rid));
										ifcProduct.setBounds(instanceBounds);
										for (int i = geometryInstance.getStartIndex(); i < geometryInstance.getPrimitiveCount() * 3 + geometryInstance.getStartIndex(); i++) {
											int index = ifcEngineGeometry.getIndex(i) * 3;
											processExtends(instanceBounds, ifcEngineGeometry, verticesBuffer, normalsBuffer, index);
										}
										geometryInstance.setVertices(verticesBuffer.array());
										geometryInstance.setNormals(normalsBuffer.array());
										ifcProduct.setGeometryInstance(geometryInstance);
										if (store) {
											databaseSession.store(ifcProduct, pid, rid);
											databaseSession.store(geometryInstance, pid, rid);
										}
										if (geometryCache != null) {
											geometryCache.put(ifcProduct.getExpressId(), new GeometryCacheEntry(verticesBuffer, normalsBuffer, instanceBounds));
										}
									}
								}
							} finally {
								ifcEngineModel.close();
							}
						} finally {
							ifcEngine.close();
						}
					} catch (IfcEngineException e) {
						LOGGER.error("", e);
					}
				}
			} catch (SerializerException e) {
				LOGGER.error("", e);
			}
		}
	}

	private void returnCachedData(IfcModelInterface model, GeometryCache geometryCache, DatabaseSession databaseSession, int pid, int rid) throws BimserverDatabaseException {
		for (IfcProduct ifcProduct : model.getAllWithSubTypes(IfcProduct.class)) {
			GeometryCacheEntry geometryCacheEntry = geometryCache.get(ifcProduct.getExpressId());
			if (geometryCacheEntry != null) {
				GeometryInstance geometryInstance = databaseSession.create(Ifc2x3tc1Package.eINSTANCE.getGeometryInstance(), pid, rid);
				geometryInstance.setVertices(geometryCacheEntry.getVertices().array());
				geometryInstance.setNormals(geometryCacheEntry.getNormals().array());
				ifcProduct.setGeometryInstance(geometryInstance);
				Bounds newBounds = databaseSession.create(Ifc2x3tc1Package.eINSTANCE.getBounds(), pid, rid);
				Vector3f min = databaseSession.create(Ifc2x3tc1Package.eINSTANCE.getVector3f(), pid, rid);
				min.setX(geometryCacheEntry.getBounds().getMin().getX());
				min.setY(geometryCacheEntry.getBounds().getMin().getY());
				min.setZ(geometryCacheEntry.getBounds().getMin().getZ());
				Vector3f max = databaseSession.create(Ifc2x3tc1Package.eINSTANCE.getVector3f(), pid, rid);
				max.setX(geometryCacheEntry.getBounds().getMax().getX());
				max.setY(geometryCacheEntry.getBounds().getMax().getY());
				max.setZ(geometryCacheEntry.getBounds().getMax().getZ());
				newBounds.setMin(min);
				newBounds.setMax(max);
				ifcProduct.setBounds(newBounds);
				ifcProduct.setGeometryInstance(geometryInstance);
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

	private void processExtends(Bounds bounds, IfcEngineGeometry geometry, ByteBuffer verticesBuffer, ByteBuffer normalsBuffer, int index) {
		float x = geometry.getVertex(index);
		float y = geometry.getVertex(index + 1);
		float z = geometry.getVertex(index + 2);
		verticesBuffer.putFloat(x);
		verticesBuffer.putFloat(y);
		verticesBuffer.putFloat(z);
		normalsBuffer.putFloat(geometry.getNormal(index));
		normalsBuffer.putFloat(geometry.getNormal(index + 1));
		normalsBuffer.putFloat(geometry.getNormal(index + 2));
		bounds.getMin().setX(Math.min(x, bounds.getMin().getX()));
		bounds.getMin().setY(Math.min(y, bounds.getMin().getY()));
		bounds.getMin().setZ(Math.min(z, bounds.getMin().getZ()));
		bounds.getMax().setX(Math.max(x, bounds.getMax().getX()));
		bounds.getMax().setY(Math.max(y, bounds.getMax().getY()));
		bounds.getMax().setZ(Math.max(z, bounds.getMax().getZ()));
	}
}