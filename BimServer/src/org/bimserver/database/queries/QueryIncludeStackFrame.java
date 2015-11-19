package org.bimserver.database.queries;

import java.util.List;
import org.bimserver.BimserverDatabaseException;
import org.bimserver.emf.PackageMetaData;
import org.bimserver.emf.QueryInterface;
import org.bimserver.shared.HashMapVirtualObject;
import org.bimserver.shared.Reusable;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EStructuralFeature;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class QueryIncludeStackFrame extends DatabaseReadingStackFrame {

	private EStructuralFeature feature;
	private JsonNode include;
	private boolean processed = false;
	private short cid = -1;

	public QueryIncludeStackFrame(QueryObjectProvider queryObjectProvider, QueryInterface query, ObjectNode jsonQuery, PackageMetaData packageMetaData, Reusable reusable, JsonNode include, HashMapVirtualObject currentObject) throws QueryException, BimserverDatabaseException {
		super(packageMetaData, reusable, queryObjectProvider, query, jsonQuery);
		this.include = getRealInclude(include);
		this.currentObject = currentObject;
		
		if (this.include.has("field")) {
			String fieldName = this.include.get("field").asText();
			if (fieldName.equals("RelatingStructure")) {
				System.out.println();
			}
			feature = currentObject.eClass().getEStructuralFeature(fieldName);
			if (feature == null) {
				throw new QueryException("No field \"" + fieldName + "\" found on object of type " + currentObject.eClass().getName());
			}
			if (feature instanceof EAttribute) {
				throw new QueryException("Field \"" + fieldName + "\" is an attribute, these are always included");
			}
		}
		if (this.include.has("type")) {
			String type = this.include.get("type").asText();
			cid = queryObjectProvider.getDatabaseSession().getCidForClassName(getPackageMetaData().getSchema().name().toLowerCase(), type);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean process() throws BimserverDatabaseException, QueryException {
		if (processed) {
			return true;
		} else {
			processed = true;
			Object value = currentObject.eGet(feature);
			if (value != null) {
				if (feature.isMany()) {
					List<Long> list = (List<Long>)value;
					for (long refOid : list) {
						if (cid == -1 || cid == (short)refOid) {
							if (!getQueryObjectProvider().hasRead(refOid)) {
								getQueryObjectProvider().push(new FollowReferenceStackFrame(getQueryObjectProvider(), refOid, getPackageMetaData(), getReusable(), getQuery(), (ObjectNode) include, getJsonQuery()));
							}
						}
					}
				} else {
					long refOid = (Long) value;
					if (cid == -1 || cid == (short)refOid) {
						if (!getQueryObjectProvider().hasRead(refOid)) {
							getQueryObjectProvider().push(new FollowReferenceStackFrame(getQueryObjectProvider(), refOid, getPackageMetaData(), getReusable(), getQuery(), (ObjectNode) include, getJsonQuery()));
						}
					}
				}
			}
			return false;
		}
	}
	
	@Override
	public String toString() {
		return getClass().getSimpleName() + " " + currentObject.eClass().getName() + "." + feature.getName();
	}
}