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

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.queries.om.InBoundingBox;
import org.bimserver.database.queries.om.Include;
import org.bimserver.database.queries.om.Include.TypeDef;
import org.bimserver.database.queries.om.Properties;
import org.bimserver.database.queries.om.QueryException;
import org.bimserver.database.queries.om.QueryPart;
import org.bimserver.database.queries.om.Tiles;
import org.bimserver.shared.QueryContext;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;

public class QueryPartStackFrame extends StackFrame {

	private Iterator<EClass> typeIterator;
	private QueryObjectProvider queryObjectProvider;
	private QueryContext reusable;
	private QueryPart partialQuery;
	private final Map<EClass, List<Long>> oids;
	private final Set<String> guids;
	private final Set<String> names;
	private Map<String, Properties> properties;
	private InBoundingBox inBoundingBox;
	private Set<String> classifications;
	private Tiles tiles;

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
			for (List<Long> list : this.oids.values()) {
				Collections.sort(list);
			}
		} else {
			oids = null;
		}
		if (!partialQuery.hasTypes()) {
			if (oids == null) {
				if (reusable.getOidCounters() == null) {
					// TODO not efficient, should make sure there are always oid counters (also after low-level changes)
					typeIterator = reusable.getPackageMetaData().getAllClasses().iterator();
				} else {
					typeIterator = reusable.getOidCounters().keySet().iterator();
				}
			} else {
				typeIterator = oids.keySet().iterator();
			}
		} else {
			Set<EClass> set = new HashSet<>();
			for (TypeDef typeDef : partialQuery.getTypes()) {
				set.add(typeDef.geteClass());
				if (typeDef.isIncludeSubTypes()) {
					if (typeDef.hasExcludes()) {
						for (EClass eClass : reusable.getPackageMetaData().getAllSubClasses(typeDef.geteClass())) {
							if (!typeDef.excludes(eClass)) {
								set.add(eClass);
							}
						}
					} else {
						set.addAll(reusable.getPackageMetaData().getAllSubClasses(typeDef.geteClass()));
					}
				}
			}
			typeIterator = set.iterator();
		}
		if (this.partialQuery.getGuids() != null) {
			this.guids = partialQuery.getGuids();
		} else {
			guids = null;
		}
		if (this.partialQuery.getNames() != null) {
			this.names = partialQuery.getNames();
		} else {
			names = null;
		}
		this.properties = partialQuery.getProperties();
		this.classifications = partialQuery.getClassifications();
		this.inBoundingBox = partialQuery.getInBoundingBox();
		this.tiles = partialQuery.getTiles();
	}

	@Override
	public boolean process() throws BimserverDatabaseException, QueryException {
		if (typeIterator == null) {
			return true;
		}
		if (tiles != null) {
			List<Long> oids = new ArrayList<>();
			List<Long> oidsFiltered = new ArrayList<>();

			tiles.getTilingInterface().queryOids(oids, oidsFiltered, reusable.getCroid(), null, tiles);

			if (!oids.isEmpty()) {
				queryObjectProvider.push(new QueryOidsStackFrame(queryObjectProvider, partialQuery, reusable, oids));
			}
			if (!oidsFiltered.isEmpty()) {
				QueryPart filteredQueryPart = createFilteredQueryPart(partialQuery);
				queryObjectProvider.push(new QueryOidsStackFrame(queryObjectProvider, filteredQueryPart, reusable, oidsFiltered));
			}
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
			} else if (names != null) {
				queryObjectProvider.push(new QueryNamesAndTypesStackFrame(queryObjectProvider, eClass, partialQuery, reusable, names));
			} else if (properties != null) {
				queryObjectProvider.push(new QueryPropertiesAndTypesStackFrame(queryObjectProvider, eClass, partialQuery, reusable, properties));
			} else if (classifications != null) {
				queryObjectProvider.push(new QueryClassificationsAndTypesStackFrame(queryObjectProvider, eClass, partialQuery, reusable, classifications));
			} else if (inBoundingBox != null) {
				queryObjectProvider.push(new QueryBoundingBoxStackFrame(queryObjectProvider, eClass, partialQuery, reusable, inBoundingBox));
			} else {
				queryObjectProvider.push(new QueryTypeStackFrame(queryObjectProvider, eClass, reusable, partialQuery));
			}
			return false;
		}
		return true;
	}
	
	private QueryPart createFilteredQueryPart(QueryPart input) throws QueryException {
		QueryPart result = new QueryPart(input.getPackageMetaData());
		for (TypeDef typeDef : input.getTypes()) {
			result.addType(typeDef);
		}
		for (Include include : input.getIncludes()) {
			createFilteredInclude(result, include);
		}
		return result;
	}

	private void createFilteredInclude(QueryPart result, Include include) throws QueryException {
		Include newInclude = result.createInclude();
		for (TypeDef typeDef : include.getTypes()) {
			newInclude.addType(typeDef);
		}
		for (EReference field : include.getFields()) {
			newInclude.addField(field);
		}
		for (Include include2 : include.getIncludes()) {
			newInclude.addInclude(createFilteredInclude(include2));
		}
	}

	private Include createFilteredInclude(Include inputInclude) throws QueryException {
		Include newInclude = new Include(inputInclude.getPackageMetaData());
		for (TypeDef typeDef : inputInclude.getTypes()) {
			newInclude.addType(typeDef);
		}
		if (inputInclude.hasFields()) {
			for (EReference field : inputInclude.getFields()) {
				if (field.getName().equals("data")) {
					// Skip, this is the actual filtering
					return newInclude;
				}
				newInclude.addField(field);
			}
		}
		if (inputInclude.hasIncludes()) {
			for (Include include2 : inputInclude.getIncludes()) {
				newInclude.addInclude(createFilteredInclude(include2));
			}
		}
		return newInclude;
	}
}