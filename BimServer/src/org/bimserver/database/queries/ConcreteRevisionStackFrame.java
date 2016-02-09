package org.bimserver.database.queries;

/******************************************************************************
 * Copyright (C) 2009-2016  BIMserver.org
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
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.actions.AbstractDownloadDatabaseAction;
import org.bimserver.emf.PackageMetaData;
import org.bimserver.models.store.ConcreteRevision;
import org.bimserver.models.store.Revision;
import org.bimserver.shared.QueryContext;
import org.eclipse.emf.ecore.EClass;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

public class ConcreteRevisionStackFrame extends StackFrame {

	private QueryObjectProvider queryObjectProvider;
	private PackageMetaData packageMetaData;
	private QueryContext reusable;
	
	// TODO make not static (use factory somewhere), and check concurrency
	private static final Map<Long, Map<EClass, Long>> reusableQueryContexts = new HashMap<>();

	public ConcreteRevisionStackFrame(QueryObjectProvider queryObjectProvider, ConcreteRevision concreteRevision) {
		this.queryObjectProvider = queryObjectProvider;
		int highestStopId = AbstractDownloadDatabaseAction.findHighestStopRid(concreteRevision.getProject(), concreteRevision);
		packageMetaData = queryObjectProvider.getMetaDataManager().getPackageMetaData(concreteRevision.getProject().getSchema());
		Revision revision = concreteRevision.getRevisions().get(0);

		reusable = new QueryContext(queryObjectProvider.getDatabaseSession(), packageMetaData, concreteRevision.getProject().getId(), concreteRevision.getId(), revision.getOid(), highestStopId);
		synchronized (getClass()) {
//			if (reusableQueryContexts.containsKey(concreteRevision.getOid())) {
//				System.out.println("Reusing for " + concreteRevision.getOid());
//				reusable.setOidCounters(reusableQueryContexts.get(concreteRevision.getOid()));
//			} else {
//				System.out.println("Creating new for " + concreteRevision.getOid());
				Map<EClass, Long> updateOidCounters = updateOidCounters(concreteRevision, queryObjectProvider.getDatabaseSession());
				reusable.setOidCounters(updateOidCounters);
//				reusableQueryContexts.put(concreteRevision.getOid(), updateOidCounters);
//			}
		}
	}
	
	private Map<EClass, Long> updateOidCounters(ConcreteRevision subRevision, DatabaseSession databaseSession) {
		if (subRevision.getOidCounters() != null) {
			Map<EClass, Long> oidCounters = new HashMap<>();
			ByteBuffer buffer = ByteBuffer.wrap(subRevision.getOidCounters());
			for (int i=0; i<buffer.capacity() / 10; i++) {
				short cid = buffer.getShort();
				long oid = buffer.getLong();
				EClass eClass = databaseSession.getEClass(cid);
				oidCounters.put(eClass, oid);
			}
			return oidCounters;
		}
		return null;
	}

	@Override
	public boolean process() throws BimserverDatabaseException, JsonParseException, JsonMappingException, IOException {
		queryObjectProvider.push(new QueryStackFrame(queryObjectProvider, reusable));
		return true;
	}
}