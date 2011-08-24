package org.bimserver.serializers;

import java.util.HashSet;
import java.util.Set;

import org.bimserver.database.BimDatabase;
import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.database.query.conditions.AttributeCondition;
import org.bimserver.database.query.conditions.Condition;
import org.bimserver.database.query.literals.StringLiteral;
import org.bimserver.longaction.DownloadParameters;
import org.bimserver.models.store.Project;
import org.bimserver.models.store.Serializer;
import org.bimserver.models.store.StorePackage;
import org.bimserver.models.store.User;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.serializers.EmfSerializer;
import org.bimserver.plugins.serializers.IfcModelInterface;
import org.bimserver.plugins.serializers.ProjectInfo;
import org.bimserver.plugins.serializers.SerializerException;
import org.bimserver.plugins.serializers.SerializerPlugin;
import org.bimserver.shared.SSerializerPluginDescriptor;

public class EmfSerializerFactory {
	private PluginManager pluginManager;
	private BimDatabase bimDatabase;

	public EmfSerializerFactory() {
	}

	public void init(PluginManager pluginManager, BimDatabase bimDatabase) {
		this.pluginManager = pluginManager;
		this.bimDatabase = bimDatabase;
	}

	public Set<SSerializerPluginDescriptor> getAllSerializerPluginDescriptors() {
		Set<SSerializerPluginDescriptor> descriptors = new HashSet<SSerializerPluginDescriptor>();
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

	public EmfSerializer create(Project project, User user, IfcModelInterface model, DownloadParameters downloadParameters) throws SerializerException {
		BimDatabaseSession session = bimDatabase.createReadOnlySession();
		try {
			Condition condition = new AttributeCondition(StorePackage.eINSTANCE.getSerializer_Name(), new StringLiteral(downloadParameters.getSerializerName()));
			Serializer found = session.querySingle(condition, Serializer.class, false);
			if (found != null) {
				SerializerPlugin serializerPlugin = (SerializerPlugin) pluginManager.getPlugin(found.getClassName(), true);
				if (serializerPlugin != null) {
					EmfSerializer serializer = serializerPlugin.createSerializer();
					ProjectInfo projectInfo = new ProjectInfo();
					projectInfo.setName(project.getName());
					projectInfo.setDescription(project.getDescription());
					projectInfo.setX(project.getGeoTag().getX());
					projectInfo.setY(project.getGeoTag().getY());
					projectInfo.setZ(project.getGeoTag().getZ());
					projectInfo.setDirectionAngle(project.getGeoTag().getDirectionAngle());
					projectInfo.setAuthorName(user.getName());
					serializer.init(model, projectInfo, pluginManager);
					return serializer;
				}
			}
		} catch (BimDatabaseException e) {
			e.printStackTrace();
		} catch (BimDeadlockException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
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
			Serializer found = session.querySingle(condition, Serializer.class, false);
			if (found != null) {
				return found.getExtension();
			}
		} catch (BimDatabaseException e) {
			e.printStackTrace();
		} catch (BimDeadlockException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}
}