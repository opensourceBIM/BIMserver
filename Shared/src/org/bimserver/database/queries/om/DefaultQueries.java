package org.bimserver.database.queries.om;

import org.bimserver.emf.PackageMetaData;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class DefaultQueries {
	public static Query all(PackageMetaData packageMetaData) {
		Query query = new Query(packageMetaData);
		QueryPart part = query.createQueryPart();
		part.setIncludeAllFields(true);
		return query;
	}
	
	public static String allAsString() {
		ObjectMapper objectMapper = new ObjectMapper();
		
		ObjectNode result = objectMapper.createObjectNode();
		result.put("includeAllFields", true);
		
		return result.toString();
	}
}