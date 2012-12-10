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

import org.apache.tomcat.util.http.fileupload.ByteArrayOutputStream;
import org.bimserver.database.BimserverDatabaseException;
import org.bimserver.database.Database;
import org.bimserver.database.DatabaseSession;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.models.ifc2x3tc1.GeometryInstance;
import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Factory;
import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package;
import org.bimserver.models.ifc2x3tc1.IfcProduct;
import org.bimserver.models.store.Bounds;
import org.bimserver.models.store.Geometry;
import org.bimserver.models.store.Revision;
import org.bimserver.models.store.StoreFactory;
import org.bimserver.models.store.StorePackage;
import org.bimserver.models.store.Vector3f;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.ifcengine.IfcEngine;
import org.bimserver.plugins.ifcengine.IfcEngineException;
import org.bimserver.plugins.ifcengine.IfcEngineGeometry;
import org.bimserver.plugins.ifcengine.IfcEngineInstance;
import org.bimserver.plugins.ifcengine.IfcEngineInstanceVisualisationProperties;
import org.bimserver.plugins.ifcengine.IfcEngineModel;
import org.bimserver.plugins.ifcengine.IfcEnginePlugin;
import org.bimserver.plugins.serializers.Serializer;
import org.bimserver.plugins.serializers.SerializerException;
import org.bimserver.plugins.serializers.SerializerPlugin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GeometryGenerator {
	private static final Logger LOGGER = LoggerFactory.getLogger(GeometryGenerator.class);

	public Geometry generateGeometry(PluginManager pluginManager, DatabaseSession databaseSession, IfcModelInterface model, int pid, int rid, Revision revision, boolean store) throws BimserverDatabaseException {
		Collection<SerializerPlugin> allSerializerPlugins = pluginManager.getAllSerializerPlugins("application/ifc", true);
		if (!allSerializerPlugins.isEmpty()) {
			SerializerPlugin serializerPlugin = allSerializerPlugins.iterator().next();
			Serializer serializer = serializerPlugin.createSerializer();
			try {
				// Make sure we have minimal express ids
				model.generateMinimalExpressIds();

				serializer.init(model, null, pluginManager, null, false);
				ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
				serializer.writeToOutputStream(outputStream);
				Collection<IfcEnginePlugin> allIfcEnginePlugins = pluginManager.getAllIfcEnginePlugins(true);
				if (!allIfcEnginePlugins.isEmpty()) {
					IfcEnginePlugin ifcEnginePlugin = allIfcEnginePlugins.iterator().next();
					try {
						IfcEngine ifcEngine = ifcEnginePlugin.createIfcEngine();
						ifcEngine.init();
						try {
							IfcEngineModel ifcEngineModel = ifcEngine.openModel(new ByteArrayInputStream(outputStream.toByteArray()), outputStream.size());
							ifcEngineModel.setPostProcessing(true);
							// ifcEngineModel.setFormat(48, 48);
							try {
								IfcEngineGeometry ifcEngineGeometry = ifcEngineModel.finalizeModelling(ifcEngineModel.initializeModelling());
								Geometry geometry = StoreFactory.eINSTANCE.createGeometry();

								// EList<Integer> indices =
								// geometry.getIndices();
								// List<Integer> indicesList = new
								// ArrayList<Integer>(ifcEngineGeometry.getNrIndices());
								// for (int i = 0; i <
								// ifcEngineGeometry.getNrIndices(); i++) {
								// indicesList.add(ifcEngineGeometry.getIndex(i));
								// }
								// indices.addAll(indicesList);
								//
								// EList<Float> vertices =
								// geometry.getVertices();
								// List<Float> verticesList = new
								// ArrayList<Float>(ifcEngineGeometry.getNrVertices());
								// for (int i = 0; i <
								// ifcEngineGeometry.getNrVertices(); i++) {
								// verticesList.add(ifcEngineGeometry.getVertex(i));
								// }
								// vertices.addAll(verticesList);
								//
								// EList<Float> normals = geometry.getNormals();
								// List<Float> normalsList = new
								// ArrayList<Float>(ifcEngineGeometry.getNrNormals());
								// for (int i = 0; i <
								// ifcEngineGeometry.getNrNormals(); i++) {
								// normalsList.add(ifcEngineGeometry.getNormal(i));
								// }
								// normals.addAll(normalsList);

								Bounds modelBounds = null;
								if (store) {
									modelBounds = databaseSession.create(StorePackage.eINSTANCE.getBounds());
								} else {
									modelBounds = StoreFactory.eINSTANCE.createBounds();
								}
								modelBounds.setMin(createVector3f(Float.POSITIVE_INFINITY, databaseSession, store, Database.STORE_PROJECT_ID, Integer.MAX_VALUE));
								modelBounds.setMax(createVector3f(Float.NEGATIVE_INFINITY, databaseSession, store, Database.STORE_PROJECT_ID, Integer.MAX_VALUE));
								revision.setBounds(modelBounds);

								for (IfcProduct ifcProduct : model.getAllWithSubTypes(IfcProduct.class)) {
									IfcEngineInstance ifcEngineInstance = ifcEngineModel.getInstanceFromExpressId(ifcProduct.getExpressId());
									IfcEngineInstanceVisualisationProperties visualisationProperties = ifcEngineInstance.getVisualisationProperties();
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
										instanceBounds = databaseSession.create(StorePackage.eINSTANCE.getBounds(), pid, rid);
									} else {
										instanceBounds = StoreFactory.eINSTANCE.createBounds();
									}
									instanceBounds.setMin(createVector3f(Float.POSITIVE_INFINITY, databaseSession, store, pid, rid));
									instanceBounds.setMax(createVector3f(Float.NEGATIVE_INFINITY, databaseSession, store, pid, rid));
									ifcProduct.setBounds(instanceBounds);
									for (int i = geometryInstance.getStartIndex(); i < geometryInstance.getPrimitiveCount() * 3 + geometryInstance.getStartIndex(); i++) {
										int index = ifcEngineGeometry.getIndex(i) * 3;
										processExtends(instanceBounds, ifcEngineGeometry, verticesBuffer, normalsBuffer, index);
									}
									processExtends(instanceBounds, modelBounds);
									geometryInstance.setVertices(verticesBuffer.array());
									geometryInstance.setNormals(normalsBuffer.array());
									ifcProduct.setGeometryInstance(geometryInstance);
									if (store) {
										databaseSession.store(ifcProduct, pid, rid);
										databaseSession.store(geometryInstance, pid, rid);
									}
								}
								model.setGeometry(geometry);
								return geometry;
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
		return null;
	}

	private Vector3f createVector3f(float defaultValue, DatabaseSession session, boolean store, int pid, int rid) throws BimserverDatabaseException {
		Vector3f vector3f = null;
		if (store) {
			vector3f = (Vector3f) session.create(StorePackage.eINSTANCE.getVector3f(), pid, rid);
		} else {
			vector3f = StoreFactory.eINSTANCE.createVector3f();
		}
		vector3f.setX(defaultValue);
		vector3f.setY(defaultValue);
		vector3f.setZ(defaultValue);
		return vector3f;
	}

	private void processExtends(Bounds instanceBounds, Bounds modelBounds) {
		modelBounds.getMin().setX(Math.min(instanceBounds.getMin().getX(), modelBounds.getMin().getX()));
		modelBounds.getMin().setY(Math.min(instanceBounds.getMin().getY(), modelBounds.getMin().getY()));
		modelBounds.getMin().setZ(Math.min(instanceBounds.getMin().getZ(), modelBounds.getMin().getZ()));
		modelBounds.getMax().setX(Math.max(instanceBounds.getMax().getX(), modelBounds.getMax().getX()));
		modelBounds.getMax().setY(Math.max(instanceBounds.getMax().getY(), modelBounds.getMax().getY()));
		modelBounds.getMax().setZ(Math.max(instanceBounds.getMax().getZ(), modelBounds.getMax().getZ()));
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