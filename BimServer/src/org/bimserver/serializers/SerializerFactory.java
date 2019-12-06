package org.bimserver.serializers;

/******************************************************************************
 * Copyright (C) 2009-2019  BIMserver.org
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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bimserver.BimServer;
import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.BimDatabase;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.OldQuery;
import org.bimserver.database.OperationType;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.emf.IfcModelInterfaceException;
import org.bimserver.emf.Schema;
import org.bimserver.ifc.BasicIfcModel;
import org.bimserver.ifc.IfcModel;
import org.bimserver.interfaces.objects.SPluginDescriptor;
import org.bimserver.longaction.DownloadParameters;
import org.bimserver.models.store.GeoTag;
import org.bimserver.models.store.MessagingSerializerPluginConfiguration;
import org.bimserver.models.store.Project;
import org.bimserver.models.store.SerializerPluginConfiguration;
import org.bimserver.models.store.StorePackage;
import org.bimserver.plugins.PluginConfiguration;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.renderengine.RenderEnginePlugin;
import org.bimserver.plugins.serializers.MessagingSerializer;
import org.bimserver.plugins.serializers.MessagingSerializerPlugin;
import org.bimserver.plugins.serializers.ProjectInfo;
import org.bimserver.plugins.serializers.Serializer;
import org.bimserver.plugins.serializers.SerializerException;
import org.bimserver.plugins.serializers.SerializerPlugin;
import org.bimserver.plugins.services.ServicePlugin;
import org.bimserver.schemaconverter.SchemaConverter;
import org.bimserver.schemaconverter.SchemaConverterException;
import org.bimserver.schemaconverter.SchemaConverterFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SerializerFactory {
	private static final Logger LOGGER = LoggerFactory.getLogger(SerializerFactory.class);
	private PluginManager pluginManager;
	private BimDatabase bimDatabase;
	private BimServer bimServer;

	public SerializerFactory() {
	}

	public void init(PluginManager pluginManager, BimDatabase bimDatabase, BimServer bimServer) {
		this.pluginManager = pluginManager;
		this.bimDatabase = bimDatabase;
		this.bimServer = bimServer;
	}

	public List<SPluginDescriptor> getAllServicePluginDescriptors() {
		List<SPluginDescriptor> descriptors = new ArrayList<SPluginDescriptor>();
		for (ServicePlugin servicePlugin : pluginManager.getAllServicePlugins(true).values()) {
			SPluginDescriptor descriptor = new SPluginDescriptor();
			descriptor.setPluginClassName(servicePlugin.getClass().getName());
			descriptors.add(descriptor);
		}
		return descriptors;
	}
	
	public Serializer create(Project project, String username, IfcModelInterface model, RenderEnginePlugin renderEnginePlugin, DownloadParameters downloadParameters) throws SerializerException {
		DatabaseSession session = bimDatabase.createSession(OperationType.READ_ONLY);
		try {
			SerializerPluginConfiguration serializerPluginConfiguration = session.get(StorePackage.eINSTANCE.getSerializerPluginConfiguration(), downloadParameters.getSerializerOid(), OldQuery.getDefault());
			if (serializerPluginConfiguration != null) {
				SerializerPlugin serializerPlugin = (SerializerPlugin) pluginManager.getPlugin(serializerPluginConfiguration.getPluginDescriptor().getPluginClassName(), true);
				if (serializerPlugin != null) {
					Serializer serializer = serializerPlugin.createSerializer(bimServer.getPluginSettingsCache().getPluginSettings(serializerPluginConfiguration.getOid()));
					if (!serializerPlugin.getSupportedSchemas().contains(model.getPackageMetaData().getSchema())) {
						SchemaConverterFactory converterFactory = null;
						for (Schema schema : serializerPlugin.getSupportedSchemas()) {
							converterFactory = bimServer.getSchemaConverterManager().getSchemaConverterFactory(model.getPackageMetaData().getSchema(), schema);
							if (converterFactory != null) {
								break;
							}
						}
						if (converterFactory == null) {
							throw new SerializerException("No usable converter found for schema " + model.getPackageMetaData().getSchema() + " for serializer " + serializerPlugin.getClass().getName());
						}
						try {
							IfcModel targetModel = new BasicIfcModel(bimServer.getMetaDataManager().getPackageMetaData(converterFactory.getTargetSchema().getEPackageName()), new HashMap<Integer, Long>(), (int) model.size());
							SchemaConverter converter = converterFactory.create(model, targetModel);
							converter.convert();
							model = targetModel;
						} catch (SchemaConverterException e) {
							throw new SerializerException(e);
						} catch (IfcModelInterfaceException e) {
							throw new SerializerException(e);
						}
					}
					if (serializer != null) {
						try {
							ProjectInfo projectInfo = new ProjectInfo();
							projectInfo.setName(project.getName());
							projectInfo.setDescription(project.getDescription());
							GeoTag geoTag = project.getGeoTag();
							if (geoTag != null && geoTag.getEnabled()) {
								projectInfo.setX(geoTag.getX());
								projectInfo.setY(geoTag.getY());
								projectInfo.setZ(geoTag.getZ());
								projectInfo.setDirectionAngle(geoTag.getDirectionAngle());
							} else {
								projectInfo.setX(4.8900);
								projectInfo.setY(52.3700);
							}
							projectInfo.setAuthorName(username);
							serializer.init(model, projectInfo, true);
							return serializer;
						} catch (NullPointerException e) {
							LOGGER.error("", e);
						}
					}
				}
			}
		} catch (BimserverDatabaseException e) {
			LOGGER.error("", e);
		} finally {
			session.close();
		}
		return null;
	}
	
	public MessagingSerializer createMessagingSerializer(String username, IfcModelInterface model, DownloadParameters downloadParameters) throws SerializerException {
		DatabaseSession session = bimDatabase.createSession(OperationType.READ_ONLY);
		try {
			MessagingSerializerPluginConfiguration serializerPluginConfiguration = session.get(StorePackage.eINSTANCE.getMessagingSerializerPluginConfiguration(), downloadParameters.getSerializerOid(), OldQuery.getDefault());
			if (serializerPluginConfiguration != null) {
				MessagingSerializerPlugin serializerPlugin = (MessagingSerializerPlugin) pluginManager.getPlugin(serializerPluginConfiguration.getPluginDescriptor().getPluginClassName(), true);
				if (serializerPlugin != null) {
					PluginConfiguration pluginSettings = bimServer.getPluginSettingsCache().getPluginSettings(serializerPluginConfiguration.getOid());
					MessagingSerializer serializer = serializerPlugin.createSerializer(pluginSettings);
					if (serializer != null) {
						try {
							serializer.init(model, null, pluginManager, model.getPackageMetaData(), true);
							return serializer;
						} catch (NullPointerException e) {
							LOGGER.error("", e);
						}
					}
				}
			}
		} catch (BimserverDatabaseException e) {
			LOGGER.error("", e);
		} finally {
			session.close();
		}
		return null;
	}

	public String getExtension(Long serializerOid) {
		DatabaseSession session = bimDatabase.createSession(OperationType.READ_ONLY);
		try {
			SerializerPluginConfiguration found = session.get(StorePackage.eINSTANCE.getSerializerPluginConfiguration(), serializerOid, OldQuery.getDefault());
			if (found != null) {
				return bimServer.getPluginSettingsCache().getPluginSettings(found.getOid()).getString(SerializerPlugin.EXTENSION);
			}
		} catch (BimserverDatabaseException e) {
			LOGGER.error("", e);
		} finally {
			session.close();
		}
		return null;
	}
}