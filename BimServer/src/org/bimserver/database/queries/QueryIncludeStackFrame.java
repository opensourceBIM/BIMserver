package org.bimserver.database.queries;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.actions.DatabaseReadingStackFrame;
import org.bimserver.emf.PackageMetaData;
import org.bimserver.emf.QueryInterface;
import org.bimserver.shared.HashMapVirtualObject;
import org.bimserver.shared.Reusable;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EStructuralFeature;

import com.google.gson.JsonObject;

public class QueryIncludeStackFrame extends DatabaseReadingStackFrame implements StackFrame {

	private HashMapVirtualObject currentObject;
	private EStructuralFeature feature;
	private JsonObject include;
	private QueryInterface currentDatabaseQuery;
	private JsonObject jsonQuery;

	public QueryIncludeStackFrame(QueryObjectProvider queryObjectProvider, QueryInterface currentDatabaseQuery, JsonObject jsonQuery, PackageMetaData packageMetaData, Reusable reusable, JsonObject include,
			HashMapVirtualObject currentObject) throws QueryException {
		super(packageMetaData, reusable, queryObjectProvider);
		this.currentDatabaseQuery = currentDatabaseQuery;
		this.jsonQuery = jsonQuery;
		this.include = include;
		this.currentObject = currentObject;
		if (include.has("field")) {
			String fieldName = include.get("field").getAsString();
			feature = currentObject.eClass().getEStructuralFeature(fieldName);
			if (feature == null) {
				throw new QueryException("No field \"" + fieldName + "\" found on object of type " + currentObject.eClass().getName());
			}
			if (feature instanceof EAttribute) {
				throw new QueryException("Field \"" + fieldName + "\" is an attribute, these are always included");
			}
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public Set<StackFrame> process() throws BimserverDatabaseException, QueryException {
		Object value = currentObject.eGet(feature);
		JsonObject nextInclude = include.has("include") ? include.get("include").getAsJsonObject() : null;
		if (value != null) {
			if (feature.isMany()) {
				List<Long> list = (List<Long>)value;
				Set<StackFrame> result = new HashSet<>();
				for (Long refOid : list) {
					if (!getQueryObjectProvider().hasRead(refOid)) {
						result.add(new FollowReferenceStackFrame(getQueryObjectProvider(), refOid, getPackageMetaData(), getReusable(), currentDatabaseQuery, nextInclude, jsonQuery));
					}
				}
				return result;
			} else {
				long refOid = (Long) value;
				if (!getQueryObjectProvider().hasRead(refOid)) {
					return Collections.<StackFrame>singleton(new FollowReferenceStackFrame(getQueryObjectProvider(), refOid, getPackageMetaData(), getReusable(), currentDatabaseQuery, nextInclude, jsonQuery));
				}
			}
		}
		return null;
	}
	
	@Override
	public String toString() {
		return getClass().getSimpleName() + " " + currentObject.eClass().getName() + "." + feature.getName();
	}
}