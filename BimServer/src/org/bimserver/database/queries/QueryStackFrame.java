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
import java.util.Iterator;

import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.queries.om.Query;
import org.bimserver.database.queries.om.QueryException;
import org.bimserver.database.queries.om.QueryPart;
import org.bimserver.database.queries.om.SpecialQueryType;
import org.bimserver.shared.QueryContext;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

public class QueryStackFrame extends StackFrame {

	private Iterator<QueryPart> queryIterator;
	private QueryObjectProvider queryObjectProvider;
	private QueryContext reusable;
	private Query query;

	public QueryStackFrame(QueryObjectProvider queryObjectProvider, QueryContext reusable) throws JsonParseException, JsonMappingException, IOException {
		this.queryObjectProvider = queryObjectProvider;
		this.reusable = reusable;
		this.query = queryObjectProvider.getQuery();
		queryIterator = query.getQueryParts().iterator();
	}

	@Override
	public boolean process() throws BimserverDatabaseException, QueryException {
		if (query.getSpecialQueryType() != null) {
			if (query.getSpecialQueryType() == SpecialQueryType.ALL) {
				queryObjectProvider.push(new AllStackFrame(queryObjectProvider, reusable));
				return true;
			} else if (query.getSpecialQueryType() == SpecialQueryType.NONE) {
				return true;
			}
		}
		if (queryIterator.hasNext()) {
			QueryPart next = queryIterator.next();
			queryObjectProvider.push(new QueryPartStackFrame(queryObjectProvider, next, reusable));
		}
		return !queryIterator.hasNext();
	}
}
