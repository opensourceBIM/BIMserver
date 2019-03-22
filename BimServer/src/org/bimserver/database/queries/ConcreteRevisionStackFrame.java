package org.bimserver.database.queries;

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

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.OidCounters;
import org.bimserver.database.actions.AbstractDownloadDatabaseAction;
import org.bimserver.emf.PackageMetaData;
import org.bimserver.models.store.ConcreteRevision;
import org.bimserver.shared.QueryContext;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

public class ConcreteRevisionStackFrame extends StackFrame {

	private final QueryObjectProvider queryObjectProvider;
	private final PackageMetaData packageMetaData;
	private final QueryContext queryContext;
	
	// TODO make not static (use factory somewhere), and check concurrency
	private static final Map<Long, OidCounters> reusableQueryContexts = new HashMap<>();

	public ConcreteRevisionStackFrame(QueryObjectProvider queryObjectProvider, ConcreteRevision concreteRevision, long roid) {
		this.queryObjectProvider = queryObjectProvider;
		int highestStopId = AbstractDownloadDatabaseAction.findHighestStopRid(concreteRevision.getProject(), concreteRevision);
		packageMetaData = queryObjectProvider.getMetaDataManager().getPackageMetaData(concreteRevision.getProject().getSchema());

		queryContext = new QueryContext(queryObjectProvider.getDatabaseSession(), packageMetaData, concreteRevision.getProject().getId(), concreteRevision.getId(), roid, concreteRevision.getOid(), highestStopId);
		if (concreteRevision.getOidCounters() != null) {
			synchronized (getClass()) {
				if (reusableQueryContexts.containsKey(concreteRevision.getOid())) {
					queryContext.setOidCounters(reusableQueryContexts.get(concreteRevision.getOid()));
				} else {
					try {
						OidCounters updateOidCounters = updateOidCounters(concreteRevision, queryObjectProvider.getDatabaseSession());
						queryContext.setOidCounters(updateOidCounters);
						reusableQueryContexts.put(concreteRevision.getOid(), updateOidCounters);
					} catch (BimserverDatabaseException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
	
	public static void clearCache(long croid) {
		reusableQueryContexts.remove(croid);
	}
	
	private OidCounters updateOidCounters(ConcreteRevision subRevision, DatabaseSession databaseSession) throws BimserverDatabaseException {
		if (subRevision.getOidCounters() != null) {
			return new OidCounters(databaseSession, subRevision.getOidCounters());
		}
		return null;
	}

	@Override
	public boolean process() throws BimserverDatabaseException, JsonParseException, JsonMappingException, IOException {
		queryObjectProvider.push(new QueryStackFrame(queryObjectProvider, queryContext));
		return true;
	}
}