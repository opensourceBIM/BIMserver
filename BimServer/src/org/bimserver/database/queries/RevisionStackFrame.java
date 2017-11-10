package org.bimserver.database.queries;

/******************************************************************************
 * Copyright (C) 2009-2017  BIMserver.org
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

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.OldQuery;
import org.bimserver.models.store.ConcreteRevision;
import org.bimserver.models.store.Revision;
import org.bimserver.models.store.StorePackage;

public class RevisionStackFrame extends StackFrame {

	private Revision currentRevision;
	private Map<Integer, Long> pidRoidMap = new HashMap<>();
	private Iterator<ConcreteRevision> concreteRevisionIterator;
	private QueryObjectProvider queryObjectProvider;

	public RevisionStackFrame(QueryObjectProvider queryObjectProvider, long roid) throws BimserverDatabaseException {
		this.queryObjectProvider = queryObjectProvider;
		currentRevision = (Revision) queryObjectProvider.getDatabaseSession().get(StorePackage.eINSTANCE.getRevision(), roid, OldQuery.getDefault());
		pidRoidMap.put(currentRevision.getProject().getId(), currentRevision.getOid());
		concreteRevisionIterator = currentRevision.getConcreteRevisions().iterator();
	}

	@Override
	public boolean process() {
		if (!concreteRevisionIterator.hasNext()) {
			return true;
		}
		queryObjectProvider.push(new ConcreteRevisionStackFrame(queryObjectProvider, this.concreteRevisionIterator.next()));
		if (concreteRevisionIterator.hasNext()) {
			return false;
		}
		return true;
	}
}