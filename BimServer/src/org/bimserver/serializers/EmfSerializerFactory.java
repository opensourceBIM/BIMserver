package org.bimserver.serializers;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.bimserver.SettingsManager;
import org.bimserver.database.BimDatabase;
import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.database.query.conditions.AttributeCondition;
import org.bimserver.database.query.conditions.Condition;
import org.bimserver.database.query.literals.StringLiteral;
import org.bimserver.ifc.FieldIgnoreMap;
import org.bimserver.ifc.IfcModel;
import org.bimserver.longaction.DownloadParameters;
import org.bimserver.models.store.Project;
import org.bimserver.models.store.Serializer;
import org.bimserver.models.store.StorePackage;
import org.bimserver.models.store.User;
import org.bimserver.plugins.ifcengine.IfcEngineFactory;
import org.bimserver.plugins.schema.SchemaDefinition;
import org.bimserver.plugins.serializers.EmfSerializer;
import org.bimserver.plugins.serializers.PackageDefinition;
import org.bimserver.plugins.serializers.SerializerException;
import org.bimserver.plugins.serializers.SerializerPlugin;
import org.bimserver.shared.BimPluginManager;
import org.bimserver.shared.ResourceFetcher;
import org.bimserver.version.Version;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EmfSerializerFactory {
	private static final Logger LOGGER = LoggerFactory.getLogger(EmfSerializerFactory.class);
	
	private static final EmfSerializerFactory INSTANCE = new EmfSerializerFactory();
	private FieldIgnoreMap fieldIgnoreMap;
	private PackageDefinition colladaSettings;
	private SchemaDefinition schemaDefinition;
	private Version version;

	private IfcEngineFactory ifcEngineFactory;
	private ResourceFetcher resourceFetcher;
	private SettingsManager settingsManager;

	private Map<String, SerializerPlugin> serializerPlugins = new HashMap<String, SerializerPlugin>();

	private BimPluginManager pluginManager;

	private BimDatabase bimDatabase;
	
	private EmfSerializerFactory() {
	}

	public static EmfSerializerFactory getInstance() {
		return INSTANCE;
	}

	public void init(Version version, SchemaDefinition schemaDefinition, FieldIgnoreMap fieldIgnoreMap, IfcEngineFactory ifcEngineFactory, PackageDefinition colladaSettings, ResourceFetcher resourceFetcher, SettingsManager settingsManager, BimPluginManager osgiManager, BimDatabase bimDatabase) {
		this.version = version;
		this.schemaDefinition = schemaDefinition;
		this.fieldIgnoreMap = fieldIgnoreMap;
		this.ifcEngineFactory = ifcEngineFactory;
		this.colladaSettings = colladaSettings;
		this.resourceFetcher = resourceFetcher;
		this.settingsManager = settingsManager;
		this.pluginManager = osgiManager;
		this.bimDatabase = bimDatabase;
	}

	public void initSerializers() {
		for (SerializerPlugin serializerPlugin : pluginManager.getAllSerializerPlugins()) {
			this.serializerPlugins.put(serializerPlugin.getClass().getName(), serializerPlugin);
		}
	}

	public Set<String> getAllSerializerClassNames() {
		Set<String> classNames = new HashSet<String>();
		for (SerializerPlugin serializerPlugin : serializerPlugins.values()) {
			classNames.add(serializerPlugin.getName());
		}
		return classNames;
	}

	public EmfSerializer create(Project project, User user, IfcModel model, DownloadParameters downloadParameters) throws SerializerException {
		BimDatabaseSession session = bimDatabase.createReadOnlySession();
		try {
			Condition condition = new AttributeCondition(StorePackage.eINSTANCE.getSerializer_Name(), new StringLiteral(downloadParameters.getSerializerName()));
			Serializer found = session.querySingle(condition, Serializer.class, false);
			if (found != null) {
				SerializerPlugin serializerPlugin = serializerPlugins.get(found.getClassName());
				if (serializerPlugin != null) {
					EmfSerializer serializer = serializerPlugin.createSerializer();
					serializer.init(model, schemaDefinition, fieldIgnoreMap, ifcEngineFactory);
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