package org.bimserver.database.queries;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.queries.om.Include;
import org.bimserver.database.queries.om.QueryPart;
import org.bimserver.emf.PackageMetaData;
import org.bimserver.emf.QueryInterface;
import org.bimserver.shared.HashMapVirtualObject;
import org.bimserver.shared.Reusable;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;

public class QueryIncludeStackFrame extends DatabaseReadingStackFrame {

	private Set<Short> outputFilterCids;
	private Iterator<EStructuralFeature> featureIterator;
	private Include include;

	public QueryIncludeStackFrame(QueryObjectProvider queryObjectProvider, QueryInterface query, PackageMetaData packageMetaData, Reusable reusable, Include include, HashMapVirtualObject currentObject, QueryPart queryPart) throws QueryException, BimserverDatabaseException {
		super(packageMetaData, reusable, queryObjectProvider, query, queryPart);
		this.include = include;
		this.currentObject = currentObject;
		
		List<EStructuralFeature> features = new ArrayList<EStructuralFeature>();
		features = include.getFields();
		if (features.isEmpty()) {
			setDone(true);
		}
		featureIterator = features.iterator();
		if (include.getOutputTypes() != null) {
			this.outputFilterCids = new HashSet<>();
			for (EClass eClass : include.getOutputTypes()) {
				short cid = queryObjectProvider.getDatabaseSession().getCidOfEClass(eClass);
				outputFilterCids.add(cid);
			}
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean process() throws BimserverDatabaseException, QueryException {
		EStructuralFeature feature = featureIterator.next();
		Object value = currentObject.eGet(feature);
		if (value != null) {
			if (feature.isMany()) {
				List<Long> list = (List<Long>)value;
				for (long refOid : list) {
					processReference(refOid);
				}
			} else {
				long refOid = (Long) value;
				processReference(refOid);
			}
		}
		
		return !featureIterator.hasNext();
	}

	private void processReference(long refOid) {
		if (outputFilterCids == null || outputFilterCids.contains((short)refOid)) {
//			if (!getQueryObjectProvider().hasRead(refOid)) {
				getQueryObjectProvider().push(new FollowReferenceStackFrame(getQueryObjectProvider(), refOid, getPackageMetaData(), getReusable(), getQuery(), currentObject.eClass(), getQueryPart(), include));
//			}
		}
	}
}