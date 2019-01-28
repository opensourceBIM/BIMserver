//package org.bimserver.database.queries;

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
