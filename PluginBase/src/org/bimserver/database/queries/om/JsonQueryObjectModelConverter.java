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

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.bimserver.database.queries.om.Include.TypeDef;
import org.bimserver.emf.PackageMetaData;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class JsonQueryObjectModelConverter {
	private static final Map<String, Include> CACHED_DEFINES = java.util.Collections.synchronizedMap(new HashMap<>());
	private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
	private static final int LATEST_VERSION = 2;
	private boolean copyExternalDefines = false;
	private PackageMetaData packageMetaData;

	public JsonQueryObjectModelConverter(PackageMetaData packageMetaData) {
		this.packageMetaData = packageMetaData;
	}
	
	public ObjectNode toJson(Query query) {
		ObjectNode queryNode = OBJECT_MAPPER.createObjectNode();
		Map<String, Include> defines = query.getDefines();
		ObjectNode definesNode = OBJECT_MAPPER.createObjectNode();
		queryNode.set("defines", definesNode);
		queryNode.put("doublebuffer", query.isDoubleBuffer());
		for (String key : defines.keySet()) {
			Include include = defines.get(key);
			definesNode.set(key, dumpInclude(include));
		}
		if (query.getSpecialQueryType() != null) {
			queryNode.put("specialQueryType", query.getSpecialQueryType().name());
		}
		ArrayNode queryPartsNode = OBJECT_MAPPER.createArrayNode();
		queryNode.set("queries", queryPartsNode);
		for (QueryPart queryPart : query.getQueryParts()) {
			ObjectNode queryPartNode = OBJECT_MAPPER.createObjectNode();
			if (queryPart.hasTypes()) {
				ArrayNode typesNode = OBJECT_MAPPER.createArrayNode();
				queryPartNode.set("types", typesNode);
				for (TypeDef type : queryPart.getTypes()) {
					if (type.isIncludeSubTypes()) {
						ObjectNode typeDefNode = OBJECT_MAPPER.createObjectNode();
						typeDefNode.put("name", type.geteClass().getName());
						typeDefNode.put("includeAllSubTypes", type.isIncludeSubTypes());
						if (type.hasExcludes()) {
							ArrayNode exludeNodes = OBJECT_MAPPER.createArrayNode();
							for (EClass excl : type.getExcluded()) {
								exludeNodes.add(excl.getName());
							}
							typeDefNode.set("exclude", exludeNodes);
						}
						typesNode.add(typeDefNode);
					} else {
						typesNode.add(type.geteClass().getName());
					}
				}
			}
			if (queryPart.getMinimumReuseThreshold() != -1) {
				queryPartNode.put("reuseLowerThreshold", queryPart.getMinimumReuseThreshold());
			}
			if (queryPart.hasOids()) {
				ArrayNode oidsNode = OBJECT_MAPPER.createArrayNode();
				queryPartNode.set("oids", oidsNode);
				for (long oid : queryPart.getOids()) {
					oidsNode.add(oid);
				}
			}
			if (queryPart.hasInBoundingBox()) {
				ObjectNode inBoundingBoxNode = OBJECT_MAPPER.createObjectNode();
				if (!Double.isNaN(queryPart.getInBoundingBox().getX())) {
					inBoundingBoxNode.put("x", queryPart.getInBoundingBox().getX());
				}
				if (!Double.isNaN(queryPart.getInBoundingBox().getY())) {
					inBoundingBoxNode.put("y", queryPart.getInBoundingBox().getY());
				}
				if (!Double.isNaN(queryPart.getInBoundingBox().getZ())) {
					inBoundingBoxNode.put("z", queryPart.getInBoundingBox().getZ());
				}
				if (!Double.isNaN(queryPart.getInBoundingBox().getWidth())) {
					inBoundingBoxNode.put("width", queryPart.getInBoundingBox().getWidth());
				}
				if (!Double.isNaN(queryPart.getInBoundingBox().getHeight())) {
					inBoundingBoxNode.put("height", queryPart.getInBoundingBox().getHeight());
				}
				if (!Double.isNaN(queryPart.getInBoundingBox().getDepth())) {
					inBoundingBoxNode.put("depth", queryPart.getInBoundingBox().getDepth());
				}
				inBoundingBoxNode.put("partial", queryPart.getInBoundingBox().isPartial());
				inBoundingBoxNode.put("densityLowerThreshold", queryPart.getInBoundingBox().getDensityLowerThreshold());
				inBoundingBoxNode.put("densityUpperThreshold", queryPart.getInBoundingBox().getDensityUpperThreshold());
				queryPartNode.set("inBoundingBox", inBoundingBoxNode);
			}
			if (queryPart.hasIncludes() || queryPart.hasIncludesToResolve() || queryPart.hasReferences()) {
				ArrayNode includesNode = OBJECT_MAPPER.createArrayNode();
				queryPartNode.set("includes", includesNode);
				if (queryPart.hasIncludes()) {
					for (Include include : queryPart.getIncludes()) {
						ObjectNode includeNode = dumpInclude(include);
						includesNode.add(includeNode);
					}
				}
				if (queryPart.hasIncludesToResolve()) {
					for (String name : queryPart.getIncludesToResolve()) {
						includesNode.add(name);
					}
				}
				if (queryPart.hasReferences()) {
					for (Reference reference : queryPart.getReferences()) {
						includesNode.add(reference.getName());
					}
				}
			}
			
			if (queryPart.hasTiles()) {
				Tiles tiles = queryPart.getTiles();
				ObjectNode tilesNode = OBJECT_MAPPER.createObjectNode();
				tilesNode.put("maxDepth", tiles.getMaxDepth());
				tilesNode.put("densityUpperThreshold", tiles.getMinimumReuseThreshold());
				tilesNode.put("densityLowerThreshold", tiles.getMaximumThreshold());
				tilesNode.put("reuseLowerThreshold", tiles.getMinimumReuseThreshold());
				if (!tiles.getGeometryIdsToReuse().isEmpty()) {
					ArrayNode reuseNodes = OBJECT_MAPPER.createArrayNode();
					for (long reuseId : tiles.getGeometryIdsToReuse()) {
						reuseNodes.add(reuseId);
					}
					tilesNode.set("geometryDataToReuse", reuseNodes);
				}
				ArrayNode tileIdsNode = OBJECT_MAPPER.createArrayNode();
				for (Integer id : tiles.getTileIds()) {
					tileIdsNode.add(id);
				}
				tilesNode.set("ids", tileIdsNode);
				queryNode.set("tiles", tilesNode);
			}
			queryPartsNode.add(queryPartNode);
		}
		
		if (query.getGeometrySettings() != null) {
			queryNode.set("loaderSettings", query.getGeometrySettings());
		}
		
		return queryNode;
	}

	private ObjectNode dumpInclude(Include include) {
		ObjectNode includeNode = OBJECT_MAPPER.createObjectNode();
		
		ArrayNode typesNode = OBJECT_MAPPER.createArrayNode();
		if (include.hasTypes()) {
			for (TypeDef type : include.getTypes()) {
				ObjectNode typeDefNode = OBJECT_MAPPER.createObjectNode();
				typeDefNode.put("name", type.geteClass().getName());
				typeDefNode.put("includeAllSubTypes", type.isIncludeSubTypes());
				if (type.getExcluded() != null) {
					ArrayNode excludesNode = OBJECT_MAPPER.createArrayNode();
					for (EClass eClass : type.getExcluded()) {
						excludesNode.add(eClass.getName());
					}
					typeDefNode.set("exlude", excludesNode);
				}
				typesNode.add(typeDefNode);
			}
			includeNode.set("types", typesNode);
		}
		
		if (include.hasFields()) {
			ArrayNode fieldsNode = OBJECT_MAPPER.createArrayNode();
			for (EReference eReference : include.getFields()) {
				fieldsNode.add(eReference.getName());
			}
			includeNode.set("fields", fieldsNode);
		}
		if (include.hasDirectFields()) {
			ArrayNode fieldsNode = OBJECT_MAPPER.createArrayNode();
			for (EReference eReference : include.getFieldsDirect()) {
				fieldsNode.add(eReference.getName());
			}
			includeNode.set("fieldsDirect", fieldsNode);
		}
		
		if (include.hasIncludes() || include.hasIncludesToResolve() || include.hasReferences()) {
			ArrayNode includes = OBJECT_MAPPER.createArrayNode();
			includeNode.set("includes", includes);
			if (include.hasIncludes()) {
				for (Include nextInclude : include.getIncludes()) {
					includes.add(dumpInclude(nextInclude));
				}
			}
			if (include.hasIncludesToResolve()) {
				for (String nextInclude : include.getIncludesToResolve()) {
					includes.add(nextInclude);
				}
			}
			if (include.hasReferences()) {
				for (Reference reference : include.getReferences()) {
					includes.add(reference.getName());
				}
			}
		}

		if (include.hasOutputTypes()) {
			throw new RuntimeException("Not implemented");
		}
		return includeNode;
	}
	
	public Query parseJson(String queryName, ObjectNode fullQuery) throws QueryException {
		Query query = new Query(queryName, packageMetaData);
		query.setOriginalJson(fullQuery);
		int version = LATEST_VERSION;
		if (fullQuery.has("version")) {
			version = fullQuery.get("version").asInt();
		}
		if (version != LATEST_VERSION) {
			throw new QueryException("Only version " + LATEST_VERSION + " supported by this version of BIMserver");
		}
		query.setVersion(version);
		query.setDoubleBuffer(fullQuery.has("doublebuffer") ? fullQuery.get("doublebuffer").asBoolean() : true);
		if (fullQuery.has("defines")) {
			JsonNode defines = fullQuery.get("defines");
			if (defines instanceof ObjectNode) {
				parseDefines(query, (ObjectNode)fullQuery.get("defines"));
			} else {
				throw new QueryException("\"defines\" must be of type object");
			}
		}
		if (fullQuery.has("specialQueryType")) {
			query.setSpecialQueryType(SpecialQueryType.valueOf(fullQuery.get("specialQueryType").asText()));
		}
		if (fullQuery.has("loaderSettings")) {
			query.setGeometrySettings((ObjectNode) fullQuery.get("loaderSettings"));
		}
		if (fullQuery.has("queries")) {
			JsonNode queriesNode = fullQuery.get("queries");
			if (queriesNode instanceof ArrayNode) {
				ArrayNode queries = (ArrayNode) fullQuery.get("queries");
				if (queries.size() == 0) {
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
		// First pass, get all the name and create stub includes, using two passing to allow the usage of includes defined later in the structure
		while (fieldNames.hasNext()) {
			String fieldName = fieldNames.next();
			JsonNode defineNode = jsonNode.get(fieldName);
			if (defineNode instanceof ObjectNode) {
				Include include = new Include(packageMetaData);
				query.addDefine(fieldName, include);
			} else {
				throw new QueryException("\"defines\"[" + fieldName + "] must be of type object");
			}
		}
		// Second pass, actually construct the includes
		fieldNames = jsonNode.fieldNames();
		while (fieldNames.hasNext()) {
			String fieldName = fieldNames.next();
			JsonNode defineNode = jsonNode.get(fieldName);
			ObjectNode define = (ObjectNode)defineNode;
			parseInclude(query, define, query.getDefine(fieldName), null);
		}
	}
	
	private Include parseInclude(Query query, ObjectNode jsonNode, Include include, CanInclude parentInclude) throws QueryException {
		if (include == null) {
			include = new Include(packageMetaData);
		}
		if (!jsonNode.has("type") && !jsonNode.has("types")) {
			for (EClass eClass : packageMetaData.getAllClasses()) {
				include.addType(eClass, false);
			}

//			throw new QueryException("includes require a \"type\" or \"types\" field " + jsonNode);
		}
		if (jsonNode.has("type")) {
			JsonNode typeNode = jsonNode.get("type");
			parseTypeNode(include, -1, typeNode);
		}
		if (jsonNode.has("includeAllFields") && jsonNode.get("includeAllFields").asBoolean()) {
			include.setIncludeAllFields(true);
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
					parseTypeNode(include, i, typeNode);
				}
			} else {
				throw new QueryException("\"types\" must be of type array");
			}
		}
		if (jsonNode.has("outputType")) {
			JsonNode typeNode = jsonNode.get("outputType");
			parseOutputTypeNode(include, -1, typeNode);
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
					parseOutputTypeNode(include, i, typeNode);
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
		if (jsonNode.has("fieldsDirect")) {
			JsonNode fieldsNode = jsonNode.get("fieldsDirect");
			if (fieldsNode instanceof ArrayNode) {
				ArrayNode fields = (ArrayNode)fieldsNode;
				for (int i=0; i<fields.size(); i++) {
					JsonNode fieldNode = fields.get(i);
					if (fieldNode.isTextual()) {
						include.addFieldDirect(fieldNode.asText());
					} else {
						throw new QueryException("\"fieldsDirect\"[" + i + "] must be of type string");
					}
				}
			} else {
				throw new QueryException("\"fieldsDirect\" must be of type array");
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
		
		if (jsonNode.has("exclude")) {
			include.setExclude(jsonNode.get("exclude").asBoolean());
		}
		
		Iterator<String> fieldNames = jsonNode.fieldNames();
		while (fieldNames.hasNext()) {
			String fieldName = fieldNames.next();
			if (fieldName.equals("includeAllFields") || fieldName.contentEquals("outputType") || fieldName.contentEquals("outputTypes") || fieldName.contentEquals("fieldsDirect") || fieldName.contentEquals("exclude") || fieldName.contentEquals("field") || fieldName.contentEquals("fields") || fieldName.equals("type") || fieldName.equals("types") || fieldName.equals("oid") || fieldName.equals("oids") || fieldName.equals("guid") || fieldName.equals("guids") || fieldName.equals("name") || fieldName.equals("names") || fieldName.equals("properties") || fieldName.equals("inBoundingBox") || fieldName.equals("include") || fieldName.equals("includes") || fieldName.equalsIgnoreCase("includeAllSubtypes") || fieldName.equals("classifications")) {
				// fine
			} else {
				throw new QueryException("Unknown field: \"" + fieldName + "\"");
			}
		}
		
		return include;
	}

	private void parseTypeNode(CanInclude include, int i, JsonNode typeNode) throws QueryException {
		String identifier = i == -1 ? "type" : "\\types\"[" + i + "]";
		if (typeNode.isTextual()) {
			EClass eClass = packageMetaData.getEClassIncludingDependencies(typeNode.asText());
			if (eClass == null) {
				throw new QueryException("Type " + typeNode.asText() + " not found");
			}
			include.addType(eClass, false);
		} else if (typeNode.isObject()) {
			if (!typeNode.has("name")) {
				throw new QueryException(identifier + " object must have a \"name\" property");
			}
			EClass eClass = packageMetaData.getEClassIncludingDependencies(typeNode.get("name").asText());
			
			Set<EClass> excludes = null;
			if (typeNode.has("exclude")) {
				if (!typeNode.get("exclude").isArray()) {
					throw new QueryException("\"exclude\" must be an array");
				}
				excludes = new LinkedHashSet<>();
				ArrayNode excludeNodes = (ArrayNode) typeNode.get("exclude");
				for (JsonNode excludeNode : excludeNodes) {
					excludes.add(packageMetaData.getEClassIncludingDependencies(excludeNode.asText()));
				}
			}
			
			include.addType(eClass, typeNode.has("includeAllSubTypes") ? typeNode.get("includeAllSubTypes").asBoolean() : false, excludes);
			Iterator<String> fieldNames = typeNode.fieldNames();
			while (fieldNames.hasNext()) {
				String fieldName = fieldNames.next();
				if (!fieldName.equals("name") && !fieldName.equals("includeAllSubTypes") && !fieldName.equals("exclude")) {
					throw new QueryException(identifier + " object cannot contain \"" + fieldName + "\" field");
				}
			}
		} else {
			throw new QueryException(identifier + " field must be of type string or of type object, is " + typeNode.toString());
		}
	}

	private void parseOutputTypeNode(CanInclude include, int i, JsonNode typeNode) throws QueryException {
		String identifier = i == -1 ? "outputType" : "\\outputTypes\"[" + i + "]";
		if (typeNode.isTextual()) {
			EClass eClass = packageMetaData.getEClassIncludingDependencies(typeNode.asText());
			if (eClass == null) {
				throw new QueryException("Type " + typeNode.asText() + " not found");
			}
			include.addOutputType(eClass, false);
		} else if (typeNode.isObject()) {
			if (!typeNode.has("name")) {
				throw new QueryException(identifier + " object must have a \"name\" property");
			}
			EClass eClass = packageMetaData.getEClassIncludingDependencies(typeNode.get("name").asText());
			
			Set<EClass> excludes = null;
			if (typeNode.has("exclude")) {
				if (!typeNode.get("exclude").isArray()) {
					throw new QueryException("\"exclude\" must be an array");
				}
				excludes = new LinkedHashSet<>();
				ArrayNode excludeNodes = (ArrayNode) typeNode.get("exclude");
				for (JsonNode excludeNode : excludeNodes) {
					excludes.add(packageMetaData.getEClassIncludingDependencies(excludeNode.asText()));
				}
			}
			
			include.addOutputType(eClass, typeNode.has("includeAllSubTypes") ? typeNode.get("includeAllSubTypes").asBoolean() : false, excludes);
			Iterator<String> fieldNames = typeNode.fieldNames();
			while (fieldNames.hasNext()) {
				String fieldName = fieldNames.next();
				if (!fieldName.equals("name") && !fieldName.equals("includeAllSubTypes") && !fieldName.equals("exclude")) {
					throw new QueryException(identifier + " object cannot contain \"" + fieldName + "\" field");
				}
			}
		} else {
			throw new QueryException(identifier + " field must be of type string or of type object, is " + typeNode.toString());
		}
	}

	// TODO thread safety and cache invalidation on file updates
	public Include getDefineFromFile(String includeName, boolean useCaching) throws QueryException {
		Include include = null;
		if (useCaching) {
			include = CACHED_DEFINES.get(includeName);
		}
		if (include != null) {
			return include;
		}
		String namespaceString = includeName.substring(0, includeName.indexOf(":"));
		String singleIncludeName = includeName.substring(includeName.indexOf(":") + 1);
		URL resource;
		try {
			resource = getClass().getClassLoader().loadClass("org.bimserver.database.queries.StartFrame").getResource("json/" + namespaceString + ".json");
			if (resource == null) {
				throw new QueryException("Could not find '" + namespaceString + "' namespace in predefined queries");
			}
		} catch (ClassNotFoundException e1) {
			throw new QueryException("Could not find '" + namespaceString + "' namespace in predefined queries");
		}
		OBJECT_MAPPER.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
		try {
			ObjectNode predefinedQuery = OBJECT_MAPPER.readValue(resource, ObjectNode.class);
			Query query = parseJson(namespaceString, predefinedQuery);
			Include define = query.getDefine(singleIncludeName);
			if (copyExternalDefines) {
				define = define.copy();
			}
			if (define == null) {
				throw new QueryException("Could not find '" + singleIncludeName + "' in defines in namespace " + query.getName());
			}
			if (useCaching) {
				CACHED_DEFINES.put(includeName, define);
			}
			return define;
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
			parentInclude.addInclude(parseInclude(query, innerInclude, null, parentInclude));
		} else if (includeNode.isTextual()) {
			String includeName = includeNode.asText();
			if (includeName.contains(":")) {
				parentInclude.addIncludeReference(getDefineFromFile(includeName, true), includeName);
			} else {
				Include otherInclude = query.getDefine(includeName);
				if (otherInclude == null) {
					throw new QueryException("Cannot find define \"" + includeName + "\"");
				}
				parentInclude.addIncludeReference(otherInclude, includeName);
			}
		} else {
			throw new QueryException("\"include\" must be of type object or string");
		}
	}

	private void parseJsonQuery(Query query, ObjectNode objectNode) throws QueryException {
		QueryPart queryPart = new QueryPart(packageMetaData);
		if (objectNode.has("type")) {
			JsonNode typeNode = objectNode.get("type");
			parseTypeNode(queryPart, -1, typeNode);
//			if (typeNode.isTextual()) {
//				String type = typeNode.asText();
//				addType(objectNode, queryPart, type, false, null);
//			} else if (typeNode.isObject()) {
//				ObjectNode typeDef = (ObjectNode) typeNode;
//				if (!typeDef.has("name")) {
//					throw new QueryException("Missing name");
//				}
//				List<String> stringList = null;
//				if (typeDef.has("exclude")) {
//					stringList = new ArrayList<>();
//					ArrayNode excludeNodes = (ArrayNode) typeDef.get("exclude");
//					for (JsonNode excludeNode : excludeNodes) {
//						stringList.add(excludeNode.asText());
//					}
//				}
//				addType(objectNode, queryPart, typeDef.get("name").asText(), typeDef.has("includeAllSubTypes") && typeDef.get("includeAllSubTypes").asBoolean(), stringList);
//			} else {
//				throw new QueryException("\"type\" must be of type string");
//			}
		}
		if (objectNode.has("types")) {
			JsonNode typesNode = objectNode.get("types");
			if (typesNode instanceof ArrayNode) {
				ArrayNode types = (ArrayNode)typesNode;
				for (int i=0; i<types.size(); i++) {
					JsonNode typeNode = types.get(i);
					parseTypeNode(queryPart, i, typeNode);
//					if (typeNode.isTextual()) {
//						String type = typeNode.asText();
//						addType(objectNode, queryPart, type, false, null);
//					} else if (typeNode.isObject()) {
//						ObjectNode typeDef = (ObjectNode) typeNode;
//						List<String> stringList = null;
//						if (typeDef.has("exlude")) {
//							stringList = new ArrayList<>();
//							ArrayNode excludeNodes = (ArrayNode) typeDef.get("exclude");
//							for (JsonNode excludeNode : excludeNodes) {
//								stringList.add(excludeNode.asText());
//							}
//						}
//						addType(objectNode, queryPart, typeDef.get("name").asText(), typeDef.has("includeAllSubTypes") && typeDef.get("includeAllSubTypes").asBoolean(), stringList);
//					} else {
//						throw new QueryException("\"types\"[" + i + "] must be of type string");
//					}
				}
			} else {
				throw new QueryException("\"types\" must be of type array");
			}
		}
		if (objectNode.has("reuseLowerThreshold")) {
			queryPart.setMinimumReuseThreshold(objectNode.get("reuseLowerThreshold").asInt());
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
						throw new QueryException("\"oids\"[" + i + "] must be of type number (" + oidNode + ")");
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
		if (objectNode.has("name")) {
			JsonNode nameNode = objectNode.get("name");
			if (nameNode.isTextual()) {
				queryPart.addName(nameNode.asText());
			} else {
				throw new QueryException("\"name\" must be of type string");
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
		if (objectNode.has("names")) {
			JsonNode namesNode = objectNode.get("names");
			if (namesNode instanceof ArrayNode) {
				ArrayNode names = (ArrayNode)namesNode;
				for (int i=0; i<names.size(); i++) {
					JsonNode nameNode = names.get(i);
					if (nameNode.isTextual()) {
						queryPart.addName(nameNode.asText());
					} else {
						throw new QueryException("\"names\"[" + i + "] must be of type string");
					}
				}
			} else {
				throw new QueryException("\"names\" must be of type array");
			}
		}
		if (objectNode.has("properties")) {
			JsonNode propertiesNode = objectNode.get("properties");
			if (propertiesNode instanceof ObjectNode) {
				ObjectNode properties = (ObjectNode) objectNode.get("properties");
				parseProperties(queryPart, properties);
			} else {
				throw new QueryException("\"properties\" must be of type object");
			}
		}
		if (objectNode.has("classifications")) {
			JsonNode classificationsNode = (JsonNode) objectNode.get("classifications");
			if (classificationsNode instanceof ArrayNode) {
				ArrayNode arrayNode = (ArrayNode)classificationsNode;
				for (int i=0; i<arrayNode.size(); i++) {
					JsonNode classificationNode = arrayNode.get(i);
					if (classificationNode.isTextual()) {
						queryPart.addClassification(classificationNode.asText());
					} else {
						throw new QueryException("\"classification[" + i + "]\" must be of type string");
					}
				}
			} else {
				throw new QueryException("\"classifications\" must be of type array");
			}
		}
		if (objectNode.has("inBoundingBox")) {
			JsonNode boundingBoxNode = objectNode.get("inBoundingBox");
			if (boundingBoxNode instanceof ObjectNode) {
				ObjectNode boundingBox = (ObjectNode) boundingBoxNode;
				InBoundingBox inBoundingBox = null;
				if (boundingBox.has("x") && boundingBox.has("y") && boundingBox.has("z") && boundingBox.has("width") && boundingBox.has("height") && boundingBox.has("depth")) {
					double x = checkFloat(boundingBox, "x");
					double y = checkFloat(boundingBox, "y");
					double z = checkFloat(boundingBox, "z");
					double width = checkFloat(boundingBox, "width");
					double height = checkFloat(boundingBox, "height");
					double depth = checkFloat(boundingBox, "depth");
					inBoundingBox = new InBoundingBox(x, y, z, width, height, depth);
				} else {
					inBoundingBox = new InBoundingBox();
				}
				if (boundingBox.has("densityLowerThreshold")) {
					inBoundingBox.setDensityLowerThreshold((float) boundingBox.get("densityLowerThreshold").asDouble());
				}
				if (boundingBox.has("densityUpperThreshold")) {
					inBoundingBox.setDensityUpperThreshold((float) boundingBox.get("densityUpperThreshold").asDouble());
				}
				if (boundingBox.has("partial")) {
					inBoundingBox.setPartial(boundingBox.get("partial").asBoolean());
				}
				if (boundingBox.has("useCenterPoint")) {
					inBoundingBox.setUseCenterPoint(boundingBox.get("useCenterPoint").asBoolean());
				}
				if (boundingBox.has("excludeOctants")) {
					inBoundingBox.setExcludeOctants(boundingBox.get("excludeOctants").asBoolean());
				}
				queryPart.setInBoundingBox(inBoundingBox);
			} else {
				throw new QueryException("\"inBoundingBox\" should be of type object");
			}
		}
		if (objectNode.has("tiles")) {
			Tiles tiles = new Tiles();
			ObjectNode tilesNode = (ObjectNode) objectNode.get("tiles");
			ArrayNode tileIdsNode = (ArrayNode) tilesNode.get("ids");
			for (JsonNode jsonNode : tileIdsNode) {
				tiles.add(jsonNode.asInt());
			}
			if (tilesNode.has("densityUpperThreshold")) {
				tiles.setMinimumThreshold((float) tilesNode.get("densityUpperThreshold").asDouble());
			}
			if (tilesNode.has("densityLowerThreshold")) {
				tiles.setMaximumThreshold((float) tilesNode.get("densityLowerThreshold").asDouble());
			}
			if (tilesNode.has("reuseLowerThreshold")) {
				tiles.setMinimumReuseThreshold(tilesNode.get("reuseLowerThreshold").asInt());
			}
			if (tilesNode.has("geometryDataToReuse") && !tilesNode.get("geometryDataToReuse").isNull()) {
				ArrayNode geometryDataToReuse = (ArrayNode) tilesNode.get("geometryDataToReuse");
				for (JsonNode node : geometryDataToReuse) {
					tiles.addGeometryIdToReuse(node.asLong());
				}
			}
			if (tilesNode.has("maxDepth")) {
				tiles.setMaxDepth(tilesNode.get("maxDepth").asInt());
			}
			queryPart.setTiles(tiles);
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
		
		if (objectNode.has("loaderSettings")) {
			query.setGeometrySettings((ObjectNode)objectNode.get("loaderSettings"));
		}
		
		Iterator<String> fieldNames = objectNode.fieldNames();
		while (fieldNames.hasNext()) {
			String fieldName = fieldNames.next();
			if (fieldName.equals("includeAllFields") || fieldName.equals("type") || fieldName.equals("types") || fieldName.equals("oid") || fieldName.equals("oids") || fieldName.equals("guid") || fieldName.equals("guids") || fieldName.equals("name") || fieldName.equals("names") || fieldName.equals("properties") || fieldName.equals("inBoundingBox") || fieldName.equals("include") || fieldName.equals("includes") || fieldName.equalsIgnoreCase("includeAllSubtypes") || fieldName.equals("classifications") || fieldName.equals("doublebuffer") || fieldName.equals("version")  || fieldName.equals("loaderSettings") || fieldName.equals("tiles") || fieldName.equals("reuseLowerThreshold") || fieldName.contentEquals("specialQueryType")) {
				// fine
			} else {
				throw new QueryException("Unknown field: \"" + fieldName + "\"");
			}
		}
		
		query.addQueryPart(queryPart);
	}

	private void parseProperties(QueryPart queryPart, ObjectNode properties) throws QueryException {
		Iterator<Entry<String, JsonNode>> fields = properties.fields();
		while (fields.hasNext()) {
			Entry<String, JsonNode> entry = fields.next();
			String propertySetName = entry.getKey();
			JsonNode value = entry.getValue();
			if (value.isObject()) {
				ObjectNode set = (ObjectNode)value;
				Iterator<Entry<String, JsonNode>> propertySetFields = set.fields();
				while (propertySetFields.hasNext()) {
					Entry<String, JsonNode> propertyEntry = propertySetFields.next();
					JsonNode propertyValue = propertyEntry.getValue();
					
					if (propertyValue.isValueNode()) {
						if (propertyValue.getNodeType() == JsonNodeType.BOOLEAN) {
							queryPart.addProperty(propertySetName, propertyEntry.getKey(), propertyValue.asBoolean());
						} else if (propertyValue.getNodeType() == JsonNodeType.NUMBER) {
							queryPart.addProperty(propertySetName, propertyEntry.getKey(), propertyValue.asDouble());
						} else if (propertyValue.getNodeType() == JsonNodeType.STRING) {
							queryPart.addProperty(propertySetName, propertyEntry.getKey(), propertyValue.asText());
						} else if (propertyValue.getNodeType() == JsonNodeType.NULL) {
							queryPart.addProperty(propertySetName, propertyEntry.getKey(), null);
						}
					} else {
						throw new QueryException("property \"" + propertyEntry.getKey() + "\" type not supported");
					}
				}				
			} else {
				throw new QueryException("Query language has changed, propertyset name required now");
			}
		}
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

	private void addType(ObjectNode objectNode, CanInclude queryPart, String type, boolean includeAllSubTypes, List<String> excluded) throws QueryException {
		if (type.equals("Object")) {
			// no type filter
			return;
		}
		EClass eClass = packageMetaData.getEClassIncludingDependencies(type);
		if (eClass == null) {
			throw new QueryException("Type \"" + type + "\" not found");
		}
		Set<EClass> excludedEClasses = null;
		if (excluded != null) {
			excludedEClasses = new HashSet<>();
			for (String excl : excluded) {
				excludedEClasses.add(packageMetaData.getEClassIncludingDependencies(excl));
			}
		}
		queryPart.addType(eClass, includeAllSubTypes, excludedEClasses);
	}
	
	public void setCopyExternalDefines(boolean copyExternalDefines) {
		this.copyExternalDefines = copyExternalDefines;
	}
}