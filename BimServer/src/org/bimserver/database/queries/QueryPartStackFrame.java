package org.bimserver.database.queries;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.Query;
import org.bimserver.emf.PackageMetaData;
import org.bimserver.shared.Reusable;
import org.eclipse.emf.ecore.EClass;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class QueryPartStackFrame extends StackFrame {

	private Iterator<EClass> typeIterator;
	private QueryObjectProvider queryObjectProvider;
	private Query query;
	private PackageMetaData packageMetaData;
	private Reusable reusable;
	private ObjectNode partialQuery;
	private final Map<EClass, List<Long>> oids;
	private Set<String> guids;
	private Map<String, Object> properties;
	private ObjectNode inBoundingBox;

	public QueryPartStackFrame(QueryObjectProvider queryObjectProvider, PackageMetaData packageMetaData, Query query, ObjectNode partialQuery, Reusable reusable) throws BimserverDatabaseException, QueryException {
		this.queryObjectProvider = queryObjectProvider;
		this.packageMetaData = packageMetaData;
		this.query = query;
		this.partialQuery = partialQuery;
		this.reusable = reusable;
		if (partialQuery.has("type")) {
			String type = partialQuery.get("type").asText();
			if (type.equals("Object")) {
				typeIterator = query.getOidCounters().keySet().iterator();
			} else {
				EClass typeClass = packageMetaData.getEClassIncludingDependencies(type);
				Set<EClass> eClasses = new HashSet<EClass>();
				eClasses.add(typeClass);
				if (partialQuery.has("includeAllSubtypes") && partialQuery.get("includeAllSubtypes").asBoolean()) {
					eClasses.addAll(packageMetaData.getAllSubClasses((EClass)typeClass));
				}
				typeIterator = eClasses.iterator();
			}
		} else if (partialQuery.has("types")) {
			ArrayNode typesArray = (ArrayNode)partialQuery.get("types");
			Set<EClass> eClasses = new HashSet<EClass>();
			for (Iterator<JsonNode> iterator = typesArray.iterator(); iterator.hasNext();) {
				JsonNode jsonElement = iterator.next();
				EClass typeClass = packageMetaData.getEClassIncludingDependencies(jsonElement.asText());
				eClasses.add(typeClass);
				if (partialQuery.has("includeAllSubtypes") && partialQuery.get("includeAllSubtypes").asBoolean()) {
					eClasses.addAll(packageMetaData.getAllSubClasses((EClass)typeClass));
				}
			}
			typeIterator = eClasses.iterator();
		} else {
			typeIterator = null;
		}
		if (partialQuery.has("oid")) {
			oids = new HashMap<EClass, List<Long>>();
			long oid = partialQuery.get("oid").asLong();
			EClass eClass = queryObjectProvider.getDatabaseSession().getEClassForOid(oid);
			List<Long> list = new ArrayList<Long>();
			this.oids.put(eClass, list);
			list.add(oid);
		} else if (partialQuery.has("oids")) {
			this.oids = new HashMap<EClass, List<Long>>();
			ArrayNode oids = (ArrayNode) partialQuery.get("oids");
			if (oids.size() == 0) {
				throw new QueryException("oids parameter of type array is of size 0");
			}
			for (int i=0; i<oids.size(); i++) {
				long oid = oids.get(i).asLong();
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
		if (partialQuery.has("guids")) {
			this.guids = new HashSet<>();
			ArrayNode guidsArray = (ArrayNode)partialQuery.get("guids");
			for (int i=0; i<guidsArray.size(); i++) {
				String guid = guidsArray.get(i).asText();
				this.guids.add(guid);
			}
		} else if (partialQuery.has("guid")) {
			this.guids = new HashSet<>();
			this.guids.add(partialQuery.get("guid").asText());
		}
		if (partialQuery.has("properties")) {
			ObjectNode properties = (ObjectNode) partialQuery.get("properties");
			this.properties = new HashMap<String, Object>();
			Iterator<Entry<String, JsonNode>> fields = properties.fields();
			while (fields.hasNext()) {
				Entry<String, JsonNode> entry = fields.next();
				JsonNode value = entry.getValue();
				if (value.isValueNode()) {
					this.properties.put(entry.getKey(), value.asBoolean());
				}
			}
		}
		if (partialQuery.has("inBoundingBox")) {
			inBoundingBox = (ObjectNode) partialQuery.get("inBoundingBox");
		}
	}

	@Override
	public boolean process() throws BimserverDatabaseException, QueryException {
		if (typeIterator == null) {
			return true;
		}
		if (typeIterator.hasNext()) {
			EClass eClass = typeIterator.next();
			if (oids != null) {
				queryObjectProvider.push(new QueryOidsAndTypesStackFrame(queryObjectProvider, eClass, query, partialQuery, packageMetaData, reusable, oids.get(eClass)));
			} else if (guids != null) {
				queryObjectProvider.push(new QueryGuidsAndTypesStackFrame(queryObjectProvider, eClass, query, partialQuery, packageMetaData, reusable, guids));
			} else if (properties != null) {
				queryObjectProvider.push(new QueryPropertiesAndTypesStackFrame(queryObjectProvider, eClass, query, partialQuery, packageMetaData, reusable, properties));
			} else if (inBoundingBox != null) {
				queryObjectProvider.push(new QueryBoundingBoxStackFrame(queryObjectProvider, eClass, query, partialQuery, packageMetaData, reusable, inBoundingBox));
			} else {
				queryObjectProvider.push(new QueryTypeStackFrame(queryObjectProvider, eClass, query, packageMetaData, reusable, partialQuery));
			}
			return false;
		}
		return true;
	}
}