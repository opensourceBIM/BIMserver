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

public class EmfSerializerFactory {
	private PluginManager pluginManager;
	private BimDatabase bimDatabase;

	public EmfSerializerFactory() {
	}

	public void init(PluginManager osgiManager, BimDatabase bimDatabase) {
		this.pluginManager = osgiManager;
		this.bimDatabase = bimDatabase;
	}

	public Set<String> getAllSerializerClassNames() {
		Set<String> classNames = new HashSet<String>();
		for (SerializerPlugin serializerPlugin : pluginManager.getAllSerializerPlugins(true)) {
			classNames.add(serializerPlugin.getName());
		}
		return classNames;
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
}