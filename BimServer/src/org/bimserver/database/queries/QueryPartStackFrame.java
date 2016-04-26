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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.queries.om.InBoundingBox;
import org.bimserver.database.queries.om.QueryPart;
import org.bimserver.shared.QueryContext;
import org.bimserver.shared.QueryException;
import org.eclipse.emf.ecore.EClass;

public class QueryPartStackFrame extends StackFrame {

	private Iterator<EClass> typeIterator;
	private QueryObjectProvider queryObjectProvider;
	private QueryContext reusable;
	private QueryPart partialQuery;
	private final Map<EClass, List<Long>> oids;
	private final Set<String> guids;
	private Map<String, Object> properties;
	private InBoundingBox inBoundingBox;

	public QueryPartStackFrame(QueryObjectProvider queryObjectProvider, QueryPart partialQuery, QueryContext reusable) throws BimserverDatabaseException, QueryException {
		this.queryObjectProvider = queryObjectProvider;
		this.partialQuery = partialQuery;
		this.reusable = reusable;
		if (partialQuery.hasOids()) {
			Set<Long> oidsList = partialQuery.getOids();
			this.oids = new HashMap<EClass, List<Long>>();
			if (oidsList.size() == 0) {
				throw new QueryException("\"oids\" parameter of type array is of size 0");
			}
			Iterator<Long> iterator = oidsList.iterator();
			while (iterator.hasNext()) {
				long oid = iterator.next();
				EClass eClass = queryObjectProvider.getDatabaseSession().getEClassForOid(oid);
				List<Long> list = this.oids.get(eClass);
				if (list == null) {
					list = new ArrayList<Long>();
					this.oids.put(eClass, list);
				}
				list.add(oid);
			}
		} else {
			oids = null;
		}
		if (!partialQuery.hasTypes()) {
			if (oids == null) {
				typeIterator = reusable.getOidCounters().keySet().iterator();
			} else {
				typeIterator = oids.keySet().iterator();
			}
		} else {
			typeIterator = partialQuery.getTypes().iterator();
		}
		if (this.partialQuery.getGuids() != null) {
			this.guids = partialQuery.getGuids();
		} else {
			guids = null;
		}
		this.properties = partialQuery.getProperties();
		this.inBoundingBox = partialQuery.getInBoundingBox();
	}

	@Override
	public boolean process() throws BimserverDatabaseException, QueryException {
		if (typeIterator == null) {
			return true;
		}
		if (typeIterator.hasNext()) {
			EClass eClass = typeIterator.next();
			if (oids != null) {
				List<Long> oids2 = oids.get(eClass);
				if (oids2 != null) {
					queryObjectProvider.push(new QueryOidsAndTypesStackFrame(queryObjectProvider, eClass, partialQuery, reusable, oids2));
				}
			} else if (guids != null) {
				queryObjectProvider.push(new QueryGuidsAndTypesStackFrame(queryObjectProvider, eClass, partialQuery, reusable, guids));
			} else if (properties != null) {
				queryObjectProvider.push(new QueryPropertiesAndTypesStackFrame(queryObjectProvider, eClass, partialQuery, reusable, properties));
			} else if (inBoundingBox != null) {
				queryObjectProvider.push(new QueryBoundingBoxStackFrame(queryObjectProvider, eClass, partialQuery, reusable, inBoundingBox));
			} else {
				queryObjectProvider.push(new QueryTypeStackFrame(queryObjectProvider, eClass, reusable, partialQuery));
			}
			return false;
		}
		return true;
	}
}