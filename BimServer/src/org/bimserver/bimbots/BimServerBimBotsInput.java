package org.bimserver.bimbots;

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

import org.bimserver.BimServer;
import org.bimserver.BimserverDatabaseException;
import org.bimserver.GeometryGeneratingException;
import org.bimserver.GeometryGenerator;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.OldQuery;
import org.bimserver.database.OperationType;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.emf.IfcModelInterfaceException;
import org.bimserver.models.store.RenderEnginePluginConfiguration;
import org.bimserver.models.store.User;
import org.bimserver.models.store.UserSettings;
import org.bimserver.plugins.ObjectAlreadyExistsException;
import org.bimserver.renderengine.RenderEnginePool;
import org.bimserver.shared.exceptions.PluginException;

public class BimServerBimBotsInput extends BimBotsInput {

	private IfcModelInterface model;

	public BimServerBimBotsInput(BimServer bimServer, long uoid, String schemaName, byte[] data, IfcModelInterface model, boolean generateGeometry) throws BimBotsException {
		super(schemaName, data);
		this.model = model;
		
		try (DatabaseSession session = bimServer.getDatabase().createSession(OperationType.READ_ONLY)) {
			User user = session.get(uoid, OldQuery.getDefault());
			UserSettings userSettings = user.getUserSettings();
			RenderEnginePluginConfiguration defaultRenderEngine = userSettings.getDefaultRenderEngine();
			if (defaultRenderEngine == null) {
				throw new BimBotsException("No default render engine has been selected for this user", BimBotDefaultErrorCode.NO_RENDER_ENGINE);
			}

			if (generateGeometry) {
				GeometryGenerator generator = new GeometryGenerator(bimServer);
				RenderEnginePool pool = bimServer.getRenderEnginePools().getRenderEnginePool(model.getPackageMetaData().getSchema(), defaultRenderEngine.getPluginDescriptor().getPluginClassName(), bimServer.getPluginSettingsCache().getPluginSettings(defaultRenderEngine.getOid()));
				generator.generateGeometry(pool, bimServer.getPluginManager(), null, model, -1, -1, false, null);
			}
		} catch (PluginException e) {
			e.printStackTrace();
		} catch (BimserverDatabaseException e) {
			e.printStackTrace();
		} catch (GeometryGeneratingException e) {
			e.printStackTrace();
		} catch (ObjectAlreadyExistsException e) {
			e.printStackTrace();
		} catch (IfcModelInterfaceException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public IfcModelInterface getIfcModel() {
		return model;
	}
}
