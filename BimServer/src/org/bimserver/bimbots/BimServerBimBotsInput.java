package org.bimserver.bimbots;

import org.bimserver.BimServer;
import org.bimserver.BimserverDatabaseException;
import org.bimserver.GeometryGeneratingException;
import org.bimserver.GeometryGenerator;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.OldQuery;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.models.store.RenderEnginePluginConfiguration;
import org.bimserver.models.store.User;
import org.bimserver.models.store.UserSettings;
import org.bimserver.plugins.PluginConfiguration;
import org.bimserver.plugins.SchemaName;
import org.bimserver.renderengine.RenderEnginePool;
import org.bimserver.shared.exceptions.PluginException;

public class BimServerBimBotsInput extends BimBotsInput {

	private IfcModelInterface model;

	public BimServerBimBotsInput(BimServer bimServer, long uoid, SchemaName schemaName, byte[] data, IfcModelInterface model) throws BimBotsException {
		super(schemaName, data);
		this.model = model;
		
		try (DatabaseSession session = bimServer.getDatabase().createSession()) {
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
