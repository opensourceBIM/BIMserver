package org.bimserver.bimbots;

import java.io.ByteArrayInputStream;

import org.bimserver.BimServer;
import org.bimserver.BimserverDatabaseException;
import org.bimserver.GeometryGeneratingException;
import org.bimserver.GeometryGenerator;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.OldQuery;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.emf.PackageMetaData;
import org.bimserver.emf.Schema;
import org.bimserver.models.store.RenderEnginePluginConfiguration;
import org.bimserver.models.store.User;
import org.bimserver.models.store.UserSettings;
import org.bimserver.plugins.PluginConfiguration;
import org.bimserver.plugins.SchemaName;
import org.bimserver.plugins.deserializers.DeserializeException;
import org.bimserver.plugins.deserializers.Deserializer;
import org.bimserver.plugins.deserializers.DeserializerPlugin;
import org.bimserver.renderengine.RenderEnginePool;
import org.bimserver.shared.exceptions.PluginException;

public class BimServerBimBotsInput extends BimBotsInput {

	private IfcModelInterface model;

	public BimServerBimBotsInput(BimServer bimServer, long uoid, SchemaName schemaName, byte[] data) throws BimBotsException {
		super(schemaName, data);
		
		try (DatabaseSession session = bimServer.getDatabase().createSession()) {
			DeserializerPlugin deserializerPlugin = bimServer.getPluginManager().getFirstDeserializer("ifc", Schema.IFC2X3TC1, true);
			if (deserializerPlugin == null) {
				throw new BimBotsException("No deserializer plugin found");
			}
			Deserializer deserializer = deserializerPlugin.createDeserializer(new PluginConfiguration());
			PackageMetaData packageMetaData = bimServer.getMetaDataManager().getPackageMetaData("ifc2x3tc1");
			deserializer.init(packageMetaData);
			model = deserializer.read(new ByteArrayInputStream(data), schemaName.name(), data.length, null);
			
			GeometryGenerator generator = new GeometryGenerator(bimServer);
			
			User user = session.get(uoid, OldQuery.getDefault());
			UserSettings userSettings = user.getUserSettings();
			RenderEnginePluginConfiguration defaultRenderEngine = userSettings.getDefaultRenderEngine();
			if (defaultRenderEngine == null) {
				throw new BimBotsException("No default render engine has been selected for this user");
			}
			
			RenderEnginePool pool = bimServer.getRenderEnginePools().getRenderEnginePool(model.getPackageMetaData().getSchema(), defaultRenderEngine.getPluginDescriptor().getPluginClassName(), new PluginConfiguration(defaultRenderEngine.getSettings()));
			
			generator.generateGeometry(pool, bimServer.getPluginManager(), null, model, -1, -1, false, null);
		} catch (PluginException e) {
			e.printStackTrace();
		} catch (DeserializeException e) {
			e.printStackTrace();
		} catch (BimserverDatabaseException e) {
			e.printStackTrace();
		} catch (GeometryGeneratingException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public IfcModelInterface getIfcModel() {
		return model;
	}
}
