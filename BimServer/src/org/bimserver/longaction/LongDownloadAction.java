package org.bimserver.longaction;

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

import org.bimserver.BimServer;
import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.database.actions.BimDatabaseAction;
import org.bimserver.database.actions.DownloadByGuidsDatabaseAction;
import org.bimserver.database.actions.DownloadByOidsDatabaseAction;
import org.bimserver.database.actions.DownloadDatabaseAction;
import org.bimserver.database.actions.DownloadOfTypeDatabaseAction;
import org.bimserver.database.actions.DownloadProjectsDatabaseAction;
import org.bimserver.database.query.conditions.AttributeCondition;
import org.bimserver.database.query.conditions.Condition;
import org.bimserver.database.query.literals.StringLiteral;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.ActionState;
import org.bimserver.models.store.GuidanceProvider;
import org.bimserver.models.store.LongActionState;
import org.bimserver.models.store.Serializer;
import org.bimserver.models.store.StoreFactory;
import org.bimserver.models.store.StorePackage;
import org.bimserver.plugins.guidanceproviders.GuidanceProviderPlugin;
import org.bimserver.plugins.serializers.IfcModelInterface;

public class LongDownloadAction extends LongDownloadOrCheckoutAction {

	private BimDatabaseAction<? extends IfcModelInterface> action;
	private BimDatabaseSession session;

	public LongDownloadAction(BimServer bimServer, DownloadParameters downloadParameters, long currentUoid, AccessMethod accessMethod) {
		super(bimServer, downloadParameters, accessMethod, currentUoid);
	}

	public void execute() {
		state = ActionState.STARTED;
		try {
			executeAction(action, downloadParameters, session, false);
 		} catch (Exception e) {
			LOGGER.error("", e);
		} finally {
			if (session != null) {
				session.close();
			}
		}
		state = ActionState.FINISHED;
	}

	public void init() {
		if (getBimServer().getDiskCacheManager().contains(downloadParameters)) {
			return;
		}
		org.bimserver.plugins.guidanceproviders.GuidanceProvider guidanceProvider = null;
		session = getBimServer().getDatabase().createReadOnlySession();
		try {
			Condition condition = new AttributeCondition(StorePackage.eINSTANCE.getSerializer_Name(), new StringLiteral(downloadParameters.getSerializerName()));
			Serializer serializer = session.querySingle(condition, Serializer.class, false, null);
			if (serializer != null) {
				GuidanceProvider gp = serializer.getGuidanceProvider();
				if (gp != null) {
					GuidanceProviderPlugin guidanceProviderPlugin = getBimServer().getPluginManager().getGuidanceProviderByName(gp.getClassName());
					guidanceProvider = guidanceProviderPlugin.getGuidanceProvider();
				}
			}
		} catch (BimDatabaseException e) {
			e.printStackTrace();
		} catch (BimDeadlockException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		session = getBimServer().getDatabase().createReadOnlySession();
		switch (downloadParameters.getDownloadType()) {
		case DOWNLOAD_REVISION:
			action = new DownloadDatabaseAction(getBimServer(), session, accessMethod, downloadParameters.getRoid(), currentUoid, guidanceProvider);
			break;
		case DOWNLOAD_BY_OIDS:
			action = new DownloadByOidsDatabaseAction(getBimServer(), session, accessMethod, downloadParameters.getRoids(), downloadParameters.getOids(), currentUoid, guidanceProvider);
			break;
		case DOWNLOAD_BY_GUIDS:
			action = new DownloadByGuidsDatabaseAction(getBimServer(), session, accessMethod, downloadParameters.getRoids(), downloadParameters.getGuids(), currentUoid, guidanceProvider);
			break;
		case DOWNLOAD_OF_TYPE:
			action = new DownloadOfTypeDatabaseAction(getBimServer(), session, accessMethod, downloadParameters.getRoid(), downloadParameters.getClassName(), currentUoid, guidanceProvider);
			break;
		case DOWNLOAD_PROJECTS:
			action = new DownloadProjectsDatabaseAction(getBimServer(), session, accessMethod, downloadParameters.getRoids(), currentUoid, guidanceProvider);
			break;
		}
	}

	@Override
	public synchronized LongActionState getState() {
		LongActionState ds = StoreFactory.eINSTANCE.createLongActionState();
		if (action == null) {
			ds.setState(state);
			ds.setProgress(100);
			return ds;
		}
		switch (downloadParameters.getDownloadType()) {
		case DOWNLOAD_REVISION:
			ds.setProgress(((DownloadDatabaseAction) action).getProgress());
			break;
		case DOWNLOAD_BY_OIDS:
			ds.setProgress(((DownloadByOidsDatabaseAction) action).getProgress());
			break;
		case DOWNLOAD_BY_GUIDS:
			ds.setProgress(((DownloadByGuidsDatabaseAction) action).getProgress());
			break;
		case DOWNLOAD_OF_TYPE:
			ds.setProgress(((DownloadOfTypeDatabaseAction) action).getProgress());
			break;
		case DOWNLOAD_PROJECTS:
			ds.setProgress(((DownloadProjectsDatabaseAction) action).getProgress());
			break;
		}
		ds.setState(state);
		if (state == ActionState.FINISHED) {
			ds.setProgress(100);
		}
		return ds;
	}

	@Override
	public String getDescription() {
		return "Download";
	}

	@Override
	public DownloadParameters getKey() {
		return downloadParameters;
	}
}