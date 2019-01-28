package org.bimserver.database.queries.om;

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

import org.bimserver.emf.PackageMetaData;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class DefaultQueries {
	private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
	
	public static Query all(PackageMetaData packageMetaData) {
		Query query = new Query(packageMetaData);
		QueryPart part = query.createQueryPart();
		part.setIncludeAllFields(true);
		return query;
	}
	
	public static String allAsString() {
		ObjectNode result = OBJECT_MAPPER.createObjectNode();
		result.put("includeAllFields", true);
		
		return result.toString();
	}
}