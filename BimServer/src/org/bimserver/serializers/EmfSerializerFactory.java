package org.bimserver.serializers;

/******************************************************************************
 * Copyright (C) 2011  BIMserver.org
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

import java.util.ArrayList;
import java.util.List;

import org.bimserver.database.BimDatabase;
import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.database.query.conditions.AttributeCondition;
import org.bimserver.database.query.conditions.Condition;
import org.bimserver.database.query.literals.StringLiteral;
import org.bimserver.interfaces.objects.SIfcEnginePluginDescriptor;
import org.bimserver.interfaces.objects.SSerializerPluginDescriptor;
import org.bimserver.longaction.DownloadParameters;
import org.bimserver.models.store.Project;
import org.bimserver.models.store.Serializer;
import org.bimserver.models.store.StorePackage;
import org.bimserver.models.store.User;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.ifcengine.IfcEngine;
import org.bimserver.plugins.ifcengine.IfcEnginePlugin;
import org.bimserver.plugins.serializers.EmfSerializer;
import org.bimserver.plugins.serializers.IfcModelInterface;
import org.bimserver.plugins.serializers.ProjectInfo;
import org.bimserver.plugins.serializers.SerializerException;
import org.bimserver.plugins.serializers.SerializerPlugin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EmfSerializerFactory {
	private static final Logger LOGGER = LoggerFactory.getLogger(EmfSerializerFactory.class);
	private PluginManager pluginManager;
	private BimDatabase bimDatabase;

	public EmfSerializerFactory() {
	}

	public void init(PluginManager pluginManager, BimDatabase bimDatabase) {
		this.pluginManager = pluginManager;
		this.bimDatabase = bimDatabase;
	}

	public List<SSerializerPluginDescriptor> getAllSerializerPluginDescriptors() {
		List<SSerializerPluginDescriptor> descriptors = new ArrayList<SSerializerPluginDescriptor>();
		for (SerializerPlugin serializerPlugin : pluginManager.getAllSerializerPlugins(true)) {
			SSerializerPluginDescriptor descriptor = new SSerializerPluginDescriptor();
			descriptor.setDefaultContentType(serializerPlugin.getDefaultContentType());
			descriptor.setDefaultExtension(serializerPlugin.getDefaultExtension());
			descriptor.setDefaultName(serializerPlugin.getDefaultSerializerName());
			descriptor.setPluginClassName(serializerPlugin.getClass().getName());
			descriptors.add(descriptor);
		}
		return descriptors;
	}

	public EmfSerializer get(String name) {
		BimDatabaseSession session = bimDatabase.createReadOnlySession();
		try {
			Condition condition = new AttributeCondition(StorePackage.eINSTANCE.getSerializer_Name(), new StringLiteral(name));
			Serializer found = session.querySingle(condition, Serializer.class, false, null);
			if (found != null) {
				SerializerPlugin serializerPlugin = (SerializerPlugin) pluginManager.getPlugin(found.getClassName(), true);
				if (serializerPlugin != null) {
					return serializerPlugin.createSerializer();
				}
			}
		} catch (BimDatabaseException e) {
			LOGGER.error("", e);
		} catch (BimDeadlockException e) {
			LOGGER.error("", e);
		} finally {
			session.close();
		}
		return null;
	}
	
	public EmfSerializer create(Project project, User user, IfcModelInterface model, IfcEngine ifcEngine, DownloadParameters downloadParameters) throws SerializerException {
		EmfSerializer serializer = get(downloadParameters.getSerializerName());
		if (serializer != null) {
			ProjectInfo projectInfo = new ProjectInfo();
			projectInfo.setName(project.getName());
			projectInfo.setDescription(project.getDescription());
			projectInfo.setX(project.getGeoTag().getX());
			projectInfo.setY(project.getGeoTag().getY());
			projectInfo.setZ(project.getGeoTag().getZ());
			projectInfo.setDirectionAngle(project.getGeoTag().getDirectionAngle());
			projectInfo.setAuthorName(user.getName());
			serializer.init(model, projectInfo, pluginManager, ifcEngine);
		}
		return serializer;
	}

	public SSerializerPluginDescriptor getSerializerPluginDescriptor(String type) {
		for (SerializerPlugin serializerPlugin : pluginManager.getAllSerializerPlugins(true)) {
			if (serializerPlugin.getClass().getName().equals(type)) {
				SSerializerPluginDescriptor descriptor = new SSerializerPluginDescriptor();
				descriptor.setDefaultContentType(serializerPlugin.getDefaultContentType());
				descriptor.setDefaultExtension(serializerPlugin.getDefaultExtension());
				descriptor.setDefaultName(serializerPlugin.getDefaultSerializerName());
				descriptor.setPluginClassName(serializerPlugin.getClass().getName());
				return descriptor;
			}
		}
		return null;
	}

	public String getExtension(String serializerName) {
		BimDatabaseSession session = bimDatabase.createReadOnlySession();
		try {
			Condition condition = new AttributeCondition(StorePackage.eINSTANCE.getSerializer_Name(), new StringLiteral(serializerName));
			Serializer found = session.querySingle(condition, Serializer.class, false, null);
			if (found != null) {
				return found.getExtension();
			}
		} catch (BimDatabaseException e) {
			LOGGER.error("", e);
		} catch (BimDeadlockException e) {
			LOGGER.error("", e);
		} finally {
			session.close();
		}
		return null;
	}

	public List<SIfcEnginePluginDescriptor> getAllIfcEnginePluginDescriptors() {
		List<SIfcEnginePluginDescriptor> descriptors = new ArrayList<SIfcEnginePluginDescriptor>();
		for (IfcEnginePlugin ifcEnginePlugin : pluginManager.getAllIfcEnginePlugins(true)) {
			SIfcEnginePluginDescriptor descriptor = new SIfcEnginePluginDescriptor();
			descriptor.setDefaultName(ifcEnginePlugin.getDefaultIfcEngineName());
			descriptor.setPluginClassName(ifcEnginePlugin.getClass().getName());
			descriptors.add(descriptor);
		}
		return descriptors;
	}
}