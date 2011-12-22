package org.bimserver.database.actions;

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
import org.bimserver.ifc.compare.Compare;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.CompareIdentifier;
import org.bimserver.models.store.CompareResult;
import org.bimserver.models.store.CompareType;
import org.bimserver.plugins.ObjectIDMException;
import org.bimserver.plugins.objectidms.ObjectIDM;
import org.bimserver.plugins.serializers.IfcModelInterface;
import org.bimserver.shared.exceptions.UserException;

public class CompareDatabaseAction extends BimDatabaseAction<CompareResult> {

	private final long actingUoid;
	private final long roid1;
	private final long roid2;
	private final CompareType sCompareType;
	private final CompareIdentifier sCompareIdentifier;
	private final BimServer bimServer;

	public CompareDatabaseAction(BimServer bimServer, BimDatabaseSession bimDatabaseSession, AccessMethod accessMethod, long actingUoid, long roid1, long roid2, CompareType sCompareType, CompareIdentifier sCompareIdentifier) {
		super(bimDatabaseSession, accessMethod);
		this.bimServer = bimServer;
		this.actingUoid = actingUoid;
		this.roid1 = roid1;
		this.roid2 = roid2;
		this.sCompareType = sCompareType;
		this.sCompareIdentifier = sCompareIdentifier;
	}

	@Override
	public CompareResult execute() throws UserException, BimDeadlockException, BimDatabaseException {
		ObjectIDM objectIDM;
		try {
			objectIDM = bimServer.getPluginManager().requireObjectIDM();
		} catch (ObjectIDMException e) {
			throw new UserException(e);
		}
		Compare compare = new Compare(objectIDM);
		CompareResult compareResults = null;//bimServer.getCompareCache().getCompareResults(roid1, roid2, sCompareType, sCompareIdentifier);
		if (compareResults == null) {
			IfcModelInterface model1 = new DownloadDatabaseAction(bimServer, getDatabaseSession(), getAccessMethod(), roid1, -1, actingUoid, null).execute();
			IfcModelInterface model2 = new DownloadDatabaseAction(bimServer, getDatabaseSession(), getAccessMethod(), roid2, -1, actingUoid, null).execute();
			if (sCompareIdentifier == CompareIdentifier.GUID_ID) {
				compareResults = compare.compareOnGuids(model1, model2, sCompareType);
			} else if (sCompareIdentifier == CompareIdentifier.NAME_ID) {
				compareResults = compare.compareOnNames(model1, model2, sCompareType);
			}
			bimServer.getCompareCache().storeResults(roid1, roid2, sCompareType, sCompareIdentifier, compareResults);
		}
		return compareResults;
	}
}