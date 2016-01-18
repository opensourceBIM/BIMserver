package org.bimserver.database.queries.om;

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
import java.net.URL;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.bimserver.emf.PackageMetaData;
import org.bimserver.shared.QueryException;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class JsonQueryObjectModelConverter {
	private PackageMetaData packageMetaData;

	public JsonQueryObjectModelConverter(PackageMetaData packageMetaData) {
		this.packageMetaData = packageMetaData;
	}
	
	public ObjectNode toJson(Query query) {
		ObjectMapper objectMapper = new ObjectMapper();
		ObjectNode queryNode = objectMapper.createObjectNode();
		Map<String, Include> defines = query.getDefines();
		ObjectNode definesNode = objectMapper.createObjectNode();
		queryNode.set("defines", definesNode);
		for (String key : defines.keySet()) {
			ObjectNode includeNode = objectMapper.createObjectNode();
			Include include = defines.get(key);
			ArrayNode fieldsNode = objectMapper.createArrayNode();
			for (EReference eReference : include.getFields()) {
				fieldsNode.add(eReference.getName());
			}
			definesNode.set(key, includeNode);
		}
		ArrayNode queryPartsNode = objectMapper.createArrayNode();
		queryNode.set("queries", queryPartsNode);
		for (QueryPart queryPart : query.getQueryParts()) {
			ObjectNode queryPartNode = objectMapper.createObjectNode();
			if (queryPart.hasTypes()) {
				ArrayNode typesNode = objectMapper.createArrayNode();
				queryPartNode.set("types", typesNode);
				for (EClass type : queryPart.getTypes()) {
					typesNode.add(type.getName());
				}
			}
			if (queryPart.hasOids()) {
				ArrayNode oidsNode = objectMapper.createArrayNode();
				queryPartNode.set("oids", oidsNode);
				for (long oid : queryPart.getOids()) {
					oidsNode.add(oid);
				}
			}
			queryPartsNode.add(queryPartNode);
		}
		return queryNode;
	}
	
	public Query parseJson(String queryName, ObjectNode fullQuery) throws QueryException {
		Query query = new Query(queryName, packageMetaData);
		if (fullQuery.has("defines")) {
			JsonNode defines = fullQuery.get("defines");
			if (defines instanceof ObjectNode) {
				parseDefines(query, (ObjectNode)fullQuery.get("defines"));
			} else {
				throw new QueryException("\"defines\" must be of type object");
			}
		}
		if (fullQuery.has("queries")) {
			JsonNode queriesNode = fullQuery.get("queries");
			if (queriesNode instanceof ArrayNode) {
				ArrayNode queries = (ArrayNode) fullQuery.get("queries");
				if (queries.size() == 0) {
					throw new QueryException("\"queries\" must contain at least one query");
				}
				for (int i=0; i<queries.size(); i++) {
					parseJsonQuery(query, (ObjectNode)queries.get(i));
				}
			} else {
				throw new QueryException("\"queries\" must be of type array");
			}
		} else if (fullQuery.has("query")) {
			JsonNode queryNode = fullQuery.get("query");
			if (queryNode instanceof ObjectNode) {
				parseJsonQuery(query, (ObjectNode) fullQuery.get("query"));
			} else {
				throw new QueryException("\"query\" must be of type object");
			}
		} else if (!fullQuery.has("defines")) {
			parseJsonQuery(query, fullQuery);
		}
		return query;
	}

	private void parseDefines(Query query, ObjectNode jsonNode) throws QueryException {
		Iterator<String> fieldNames = jsonNode.fieldNames();
		int i=0;
		// First pass, get all the name and create stub includes, using two passing to allow the usage of includes defined later in the structure
		while (fieldNames.hasNext()) {
			String fieldName = fieldNames.next();
			JsonNode defineNode = jsonNode.get(fieldName);
			if (defineNode instanceof ObjectNode) {
				Include include = new Include(packageMetaData);
				query.addDefine(fieldName, include);
			} else {
				throw new QueryException("\"defines\"[" + i + "] must be of type object");
			}
			i++;
		}
		// Second pass, actually construct the includes
		fieldNames = jsonNode.fieldNames();
		while (fieldNames.hasNext()) {
			String fieldName = fieldNames.next();
			JsonNode defineNode = jsonNode.get(fieldName);
			ObjectNode define = (ObjectNode)defineNode;
			parseInclude(query, define, query.getDefine(fieldName));
		}
	}
	
	private Include parseInclude(Query query, ObjectNode jsonNode, Include include) throws QueryException {
		if (include == null) {
			include = new Include(packageMetaData);
		}
		if (!jsonNode.has("type") && !jsonNode.has("types")) {
			throw new QueryException("includes require a \"type\" or \"types\" field " + jsonNode);
		}
		if (jsonNode.has("type")) {
			JsonNode typeNode = jsonNode.get("type");
			if (typeNode.isTextual()) {
				EClass eClass = packageMetaData.getEClassIncludingDependencies(typeNode.asText());
				if (eClass == null) {
					throw new QueryException("Cannot find type \"" + typeNode.asText() + "\"");
				}
				include.addType(eClass, false);
			} else {
				throw new QueryException("\"type\" field mst be of type string");
			}
		}
		if (jsonNode.has("types")) {
			JsonNode typesNode = jsonNode.get("types");
			if (typesNode instanceof ArrayNode) {
				ArrayNode types = (ArrayNode)typesNode;
				if (types.size() == 0) {
					throw new QueryException("\"types\" must have a least one element");
				}
				for (int i=0; i<types.size(); i++) {
					JsonNode typeNode = types.get(i);
					if (typeNode.isTextual()) {
						EClass eClass = packageMetaData.getEClass(typeNode.asText());
						include.addType(eClass, false);
					} else {
						throw new QueryException("\"types\"[" + i + "] field mst be of type string");
					}
				}
			} else {
				throw new QueryException("\"types\" must be of type array");
			}
		}
		if (jsonNode.has("outputType")) {
			JsonNode typeNode = jsonNode.get("outputType");
			if (typeNode.isTextual()) {
				EClass eClass = packageMetaData.getEClassIncludingDependencies(typeNode.asText());
				include.addOutputType(eClass);
			} else {
				throw new QueryException("\"outputType\" field mst be of type string");
			}
		}
		if (jsonNode.has("outputTypes")) {
			JsonNode typesNode = jsonNode.get("outputTypes");
			if (typesNode instanceof ArrayNode) {
				ArrayNode types = (ArrayNode)typesNode;
				if (types.size() == 0) {
					throw new QueryException("\"outputTypes\" must have a least one element");
				}
				for (int i=0; i<types.size(); i++) {
					JsonNode typeNode = types.get(i);
					if (typeNode.isTextual()) {
						EClass eClass = packageMetaData.getEClass(typeNode.asText());
						include.addOutputType(eClass);
					} else {
						throw new QueryException("\"outputTypes\"[" + i + "] field mst be of type string");
					}
				}
			} else {
				throw new QueryException("\"outputTypes\" must be of type array");
			}
		}
		if (jsonNode.has("field")) {
			JsonNode fieldNode = jsonNode.get("field");
			if (fieldNode.isTextual()) {
				include.addField(fieldNode.asText());
			} else {
				throw new QueryException("\"field\" must be of type string");
			}
		}
		if (jsonNode.has("fields")) {
			JsonNode fieldsNode = jsonNode.get("fields");
			if (fieldsNode instanceof ArrayNode) {
				ArrayNode fields = (ArrayNode)fieldsNode;
				for (int i=0; i<fields.size(); i++) {
					JsonNode fieldNode = fields.get(i);
					if (fieldNode.isTextual()) {
						include.addField(fieldNode.asText());
					} else {
						throw new QueryException("\"fields\"[" + i + "] must be of type string");
					}
				}
			} else {
				throw new QueryException("\"fields\" must be of type array");
			}
		}
		if (jsonNode.has("include")) {
			JsonNode includeNode = jsonNode.get("include");
			processSubInclude(query, include, includeNode);
		}
		if (jsonNode.has("includes")) {
			JsonNode includesNode = jsonNode.get("includes");
			if (includesNode instanceof ArrayNode) {
				ArrayNode includes = (ArrayNode)includesNode;
				for (int i=0; i<includes.size(); i++) {
					processSubInclude(query, include, includes.get(i));
				}
			} else {
				throw new QueryException("\"includes\" must be of type array");
			}
		}
		return include;
	}

	public Include getDefineFromFile(String includeName) throws QueryException {
		String namespaceString = includeName.substring(0, includeName.indexOf(":"));
		String singleIncludeName = includeName.substring(includeName.indexOf(":") + 1);
		URL resource = getClass().getResource("../json/" + namespaceString + ".json");
		if (resource == null) {
			throw new QueryException("Could not find '" + namespaceString + "' namespace in predefined queries");
		}
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
		try {
			ObjectNode predefinedQuery = objectMapper.readValue(resource, ObjectNode.class);
			JsonQueryObjectModelConverter converter = new JsonQueryObjectModelConverter(packageMetaData);
			Query namespace = converter.parseJson(includeName, predefinedQuery);
			Include define2 = namespace.getDefine(singleIncludeName);
			if (define2 == null) {
				throw new QueryException("Could not find '" + singleIncludeName + "' in defines in namespace " + namespace.getName());
			}
			return define2;
		} catch (JsonParseException e) {
			throw new QueryException(e);
		} catch (JsonMappingException e) {
			throw new QueryException(e);
		} catch (IOException e) {
			throw new QueryException(e);
		}
	}
	
	private void processSubInclude(Query query, CanInclude parentInclude, JsonNode includeNode) throws QueryException {
		if (includeNode instanceof ObjectNode) {
			ObjectNode innerInclude = (ObjectNode)includeNode;
			parentInclude.addInclude(parseInclude(query, innerInclude, null));
		} else if (includeNode.isTextual()) {
			String includeName = includeNode.asText();
			if (includeName.contains(":")) {
				parentInclude.addInclude(getDefineFromFile(includeName));
			} else {
				Include otherInclude = query.getDefine(includeName);
				if (otherInclude == null) {
					throw new QueryException("Cannot find define \"" + includeName + "\"");
				}
				parentInclude.addInclude(otherInclude);
			}
		} else {
			throw new QueryException("\"include\" must be of type object or string");
		}
	}

	private void parseJsonQuery(Query query, ObjectNode objectNode) throws QueryException {
		QueryPart queryPart = new QueryPart(packageMetaData);
		if (objectNode.has("type")) {
			JsonNode typeNode = objectNode.get("type");
			if (typeNode.isTextual()) {
				String type = typeNode.asText();
				addType(objectNode, queryPart, type);
			} else {
				throw new QueryException("\"type\" must be of type string");
			}
		}
		if (objectNode.has("types")) {
			JsonNode typesNode = objectNode.get("types");
			if (typesNode instanceof ArrayNode) {
				ArrayNode types = (ArrayNode)typesNode;
				for (int i=0; i<types.size(); i++) {
					JsonNode typeNode = types.get(i);
					if (typeNode.isTextual()) {
						String type = typeNode.asText();
						addType(objectNode, queryPart, type);
					} else {
						throw new QueryException("\"types\"[" + i + "] must be of type string");
					}
				}
			} else {
				throw new QueryException("\"types\" must be of type array");
			}
		}
		if (objectNode.has("includeAllFields") && objectNode.get("includeAllFields").asBoolean()) {
			queryPart.setIncludeAllFields(true);
		}
		if (objectNode.has("oid")) {
			JsonNode oidNode = objectNode.get("oid");
			if (oidNode.isNumber()) {
				queryPart.addOid(oidNode.asLong());
			} else {
				throw new QueryException("\"oid\" must be of type number");
			}
		}
		if (objectNode.has("oids")) {
			JsonNode oidsNode = objectNode.get("oids");
			if (oidsNode instanceof ArrayNode) {
				ArrayNode oids = (ArrayNode)oidsNode;
				for (int i=0; i<oids.size(); i++) {
					JsonNode oidNode = oids.get(i);
					if (oidNode.isNumber()) {
						queryPart.addOid(oidNode.asLong());
					} else {
						throw new QueryException("\"oids\"[" + i + "] must be of type number");
					}
				}
			} else {
				throw new QueryException("\"oids\" must be of type array");
			}
		}
		if (objectNode.has("guid")) {
			JsonNode guidNode = objectNode.get("guid");
			if (guidNode.isTextual()) {
				queryPart.addGuid(guidNode.asText());
			} else {
				throw new QueryException("\"guid\" must be of type string");
			}
		}
		if (objectNode.has("guids")) {
			JsonNode guidsNode = objectNode.get("guids");
			if (guidsNode instanceof ArrayNode) {
				ArrayNode guids = (ArrayNode)guidsNode;
				for (int i=0; i<guids.size(); i++) {
					JsonNode guidNode = guids.get(i);
					if (guidNode.isTextual()) {
						queryPart.addGuid(guidNode.asText());
					} else {
						throw new QueryException("\"guids\"[" + i + "] must be of type string");
					}
				}
			} else {
				throw new QueryException("\"guids\" must be of type array");
			}
		}
		if (objectNode.has("properties")) {
			JsonNode propertiesNode = objectNode.get("properties");
			if (propertiesNode instanceof ObjectNode) {
				ObjectNode properties = (ObjectNode) objectNode.get("properties");
				Iterator<Entry<String, JsonNode>> fields = properties.fields();
				while (fields.hasNext()) {
					Entry<String, JsonNode> entry = fields.next();
					JsonNode value = entry.getValue();
					if (value.isValueNode()) {
						queryPart.addProperty(entry.getKey(), value.asBoolean());
					} else {
						throw new QueryException("property \"" + entry.getKey() + "\" type not supported");
					}
				}
			} else {
				throw new QueryException("\"properties\" must be of type object");
			}
		}
		if (objectNode.has("inBoundingBox")) {
			JsonNode boundingBoxNode = objectNode.get("inBoundingBox");
			if (boundingBoxNode instanceof ObjectNode) {
				ObjectNode boundingBox = (ObjectNode) boundingBoxNode;
				double x = checkFloat(boundingBox, "x");
				double y = checkFloat(boundingBox, "y");
				double z = checkFloat(boundingBox, "z");
				double width = checkFloat(boundingBox, "width");
				double height = checkFloat(boundingBox, "height");
				double depth = checkFloat(boundingBox, "depth");
				queryPart.setInBoundingBox(new InBoundingBox(x, y, z, width, height, depth));
			} else {
				throw new QueryException("\"inBoundingBox\" should be of type object");
			}
		}

		if (objectNode.has("include")) {
			JsonNode includeNode = objectNode.get("include");
			processSubInclude(query, queryPart, includeNode);
		}
		if (objectNode.has("includes")) {
			JsonNode includesNode = objectNode.get("includes");
			if (includesNode instanceof ArrayNode) {
				ArrayNode includes = (ArrayNode)includesNode;
				for (int i=0; i<includes.size(); i++) {
					JsonNode include = includes.get(i);
					processSubInclude(query, queryPart, include);
				}
			} else {
				throw new QueryException("\"includes\" should be of type array");
			}
		}
		
		if (objectNode.has("fields")) {
			JsonNode fieldsNode = objectNode.get("fields");
			
		}

		Iterator<String> fieldNames = objectNode.fieldNames();
		while (fieldNames.hasNext()) {
			String fieldName = fieldNames.next();
			if (fieldName.equals("includeAllFields") || fieldName.equals("type") || fieldName.equals("types") || fieldName.equals("oid") || fieldName.equals("oids") || fieldName.equals("guid") || fieldName.equals("guids") || fieldName.equals("properties") || fieldName.equals("inBoundingBox") || fieldName.equals("include") || fieldName.equals("includes") || fieldName.equals("includeAllSubtypes")) {
				// fine
			} else {
				throw new QueryException("Unknown field: \"" + fieldName + "\"");
			}
		}
		
		query.addQueryPart(queryPart);
	}
	
	private double checkFloat(ObjectNode node, String key) throws QueryException {
		if (!node.has(key)) {
			throw new QueryException("\"" + key + "\" not found on \"inBoundingBox\"");
		}
		JsonNode jsonNode = node.get(key);
		if (jsonNode.isNumber()) {
			return jsonNode.asDouble();
		} else {
			throw new QueryException("\"" + key + "\" should be of type number");
		}
	}

	private void addType(ObjectNode objectNode, QueryPart queryPart, String type) throws QueryException {
		if (type.equals("Object")) {
			// no type filter
			return;
		}
		EClass eClass = packageMetaData.getEClassIncludingDependencies(type);
		if (eClass == null) {
			throw new QueryException("Type \"" + type + "\" not found");
		}
		queryPart.addType(eClass, objectNode.has("includeAllSubtypes") && objectNode.get("includeAllSubtypes").asBoolean());
	}
}