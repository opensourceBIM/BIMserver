//package org.bimserver.database.queries;
//
//import java.io.IOException;
//import java.util.Iterator;
//import java.util.List;
//
//import org.bimserver.BimserverDatabaseException;
//import org.bimserver.emf.PackageMetaData;
//import org.bimserver.emf.QueryInterface;
//import org.bimserver.shared.HashMapVirtualObject;
//import org.bimserver.shared.Reusable;
//import org.eclipse.emf.ecore.EReference;
//
//import com.fasterxml.jackson.core.JsonParseException;
//import com.fasterxml.jackson.databind.JsonMappingException;
//import com.fasterxml.jackson.databind.JsonNode;
//import com.fasterxml.jackson.databind.node.ObjectNode;
//
//public class FollowAllReferencesStackFrame extends DatabaseReadingStackFrame {
//
//	private HashMapVirtualObject initialObject;
//	private Iterator<EReference> referencesIterator;
//	private JsonNode include;
//
//	public FollowAllReferencesStackFrame(QueryObjectProvider queryObjectProvider, PackageMetaData packageMetaData, Reusable reusable, QueryInterface query, ObjectNode jsonQuery, HashMapVirtualObject currentObject, JsonNode include) {
//		super(packageMetaData, reusable, queryObjectProvider, query, jsonQuery);
//		initialObject = currentObject;
//		this.include = include;
//		referencesIterator = initialObject.eClass().getEAllReferences().iterator();
//	}
//
//	@Override
//	boolean process() throws BimserverDatabaseException, QueryException, JsonParseException, JsonMappingException, IOException {
//		EReference eReference = referencesIterator.next();
//		Object value = initialObject.eGet(eReference);
//		if (value != null) {
//			if (eReference.isMany()) {
//				List<Long> refOids = (List<Long>)value;
//				for (Long refOid : refOids) {
//					getQueryObjectProvider().push(new FollowReferenceStackFrame(getQueryObjectProvider(), refOid, getPackageMetaData(), getReusable(), getQuery(), include, getJsonQuery()));
//				}
//			} else {
//				Long refOid = (Long)value;
//				getQueryObjectProvider().push(new FollowReferenceStackFrame(getQueryObjectProvider(), refOid, getPackageMetaData(), getReusable(), getQuery(), include, getJsonQuery()));
//			}
//		}
//		return !referencesIterator.hasNext();
//	}
//}
