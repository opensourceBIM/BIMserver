package org.bimserver.database.actions;

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
import java.util.ArrayList;

/******************************************************************************
 * Copyright (C) 2009-2018  BIMserver.org
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

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.bimserver.BimServer;
import org.bimserver.BimserverDatabaseException;
import org.bimserver.GenerateGeometryResult;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.queries.QueryObjectProvider;
import org.bimserver.database.queries.QueryTypeStackFrame;
import org.bimserver.database.queries.om.Include;
import org.bimserver.database.queries.om.Query;
import org.bimserver.database.queries.om.QueryException;
import org.bimserver.database.queries.om.QueryPart;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.emf.PackageMetaData;
import org.bimserver.geometry.Density;
import org.bimserver.models.geometry.Bounds;
import org.bimserver.models.geometry.GeometryFactory;
import org.bimserver.models.geometry.Vector3f;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.Checkout;
import org.bimserver.models.store.ConcreteRevision;
import org.bimserver.models.store.DensityCollection;
import org.bimserver.models.store.Project;
import org.bimserver.models.store.Revision;
import org.bimserver.models.store.StoreFactory;
import org.bimserver.models.store.StorePackage;
import org.bimserver.models.store.User;
import org.bimserver.shared.HashMapVirtualObject;
import org.bimserver.shared.exceptions.UserException;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

public abstract class GenericCheckinDatabaseAction extends BimDatabaseAction<ConcreteRevision>{

	private BimServer bimServer;

	public GenericCheckinDatabaseAction(BimServer bimServer, DatabaseSession databaseSession, AccessMethod accessMethod) {
		super(databaseSession, accessMethod);
		this.bimServer = bimServer;
	}

	protected void checkCheckSum(Project project, IfcModelInterface model) throws UserException {
		ConcreteRevision lastConcreteRevision = project.getLastConcreteRevision();
		if (lastConcreteRevision != null) {
			int revisionId = -1;
			for (Revision revision : lastConcreteRevision.getRevisions()) {
				if (revision.getProject() == project) {
					revisionId = revision.getId();
				}
			}
			byte[] revisionChecksum = lastConcreteRevision.getChecksum();
			if (revisionChecksum != null && model.getModelMetaData().getChecksum() != null) {
				if (Arrays.equals(revisionChecksum, model.getModelMetaData().getChecksum())) {
					throw new UserException("Uploaded model is the same as last revision (" + revisionId + "), duplicate model not stored");
				}
			}
		}
	}
	
	public CreateRevisionResult createNewConcreteRevision(DatabaseSession session, long size, Project project, User user, String comment) throws BimserverDatabaseException, BimserverLockConflictException {
		CreateRevisionResult result = new CreateRevisionResult();
		ConcreteRevision concreteRevision = getDatabaseSession().create(ConcreteRevision.class);
		concreteRevision.setSize(size);
		Date date = new Date();
		concreteRevision.setDate(date);
		concreteRevision.setId(project.getConcreteRevisions().size() + 1);
		concreteRevision.setUser(user);
		concreteRevision.setProject(project);
		project.setLastConcreteRevision(concreteRevision);
		Revision newRevision = createNewVirtualRevision(session, project, concreteRevision, comment, date, user, size);

		for (Checkout checkout : project.getCheckouts()) {
			if (checkout.getUser() == user) {
				checkout.setActive(false);
				session.store(checkout);
			}
		}

		project.setLastRevision(newRevision);
		Project parent = project.getParent();
		result.addRevision(newRevision);
		while (parent != null) {
			Revision revision = getDatabaseSession().create(Revision.class);
			result.addRevision(revision);
			revision.setComment("generated for subproject " + project.getName() + ", revision " + concreteRevision.getId() + ", by " + user.getName());
			revision.setDate(date);
			revision.setUser(getSystemUser());
			revision.setProject(parent);
			if (parent.getLastRevision() != null) {
				Revision lastRevision = parent.getLastRevision();
				for (ConcreteRevision oldRevision : lastRevision.getConcreteRevisions()) {
					if (oldRevision.getProject() != project && oldRevision.getProject() != parent) {
						revision.getConcreteRevisions().add(oldRevision);
						revision.setSize((revision.getSize() == null ? 0 : revision.getSize()) + oldRevision.getSize());
						session.store(revision);
						session.store(oldRevision);
					}
				}
			}
			revision.getConcreteRevisions().add(concreteRevision);
			revision.setSize((revision.getSize() == null ? 0 : revision.getSize()) + concreteRevision.getSize());
			revision.setLastConcreteRevision(concreteRevision);
			if (parent.getLastRevision() == null) {
				revision.setId(1);
			} else {
				revision.setId(parent.getLastRevision().getId() + 1);
			}
			parent.setLastRevision(revision);
			session.store(revision);
			session.store(parent);
			parent = parent.getParent();
		}
		session.store(project);
		session.store(concreteRevision);
		result.setConcreteRevision(concreteRevision);
		return result;
	}

	private Revision createNewVirtualRevision(DatabaseSession session, Project project, ConcreteRevision concreteRevision, String comment, Date date, User user, long size)
			throws BimserverLockConflictException, BimserverDatabaseException {
		Revision revision = session.create(Revision.class);
		revision.setLastConcreteRevision(concreteRevision);
		revision.setComment(comment);
		revision.setDate(date);
		revision.setUser(user);
		revision.setSize(size);
		revision.setId(project.getRevisions().size() + 1);
		revision.getConcreteRevisions().add(concreteRevision);
		revision.setProject(project);
		return revision;
	}
	
	protected void generateDensityAndBounds(CreateRevisionResult result, GenerateGeometryResult generateGeometry, ConcreteRevision concreteRevision) throws BimserverDatabaseException {
		for (Revision revision : result.getRevisions()) {
			Bounds newBounds = GeometryFactory.eINSTANCE.createBounds();
			Vector3f min = GeometryFactory.eINSTANCE.createVector3f();
			min.setX(Double.MAX_VALUE);
			min.setY(Double.MAX_VALUE);
			min.setZ(Double.MAX_VALUE);
			Vector3f max = GeometryFactory.eINSTANCE.createVector3f();
			max.setX(-Double.MAX_VALUE);
			max.setY(-Double.MAX_VALUE);
			max.setZ(-Double.MAX_VALUE);
			newBounds.setMin(min);
			newBounds.setMax(max);

			Bounds newBoundsMm = GeometryFactory.eINSTANCE.createBounds();
			Vector3f minMm = GeometryFactory.eINSTANCE.createVector3f();
			minMm.setX(Double.MAX_VALUE);
			minMm.setY(Double.MAX_VALUE);
			minMm.setZ(Double.MAX_VALUE);
			Vector3f maxMm = GeometryFactory.eINSTANCE.createVector3f();
			maxMm.setX(-Double.MAX_VALUE);
			maxMm.setY(-Double.MAX_VALUE);
			maxMm.setZ(-Double.MAX_VALUE);
			newBoundsMm.setMin(minMm);
			newBoundsMm.setMax(maxMm);
			
			Bounds newBoundsu = GeometryFactory.eINSTANCE.createBounds();
			Vector3f minu = GeometryFactory.eINSTANCE.createVector3f();
			minu.setX(Double.MAX_VALUE);
			minu.setY(Double.MAX_VALUE);
			minu.setZ(Double.MAX_VALUE);
			Vector3f maxu = GeometryFactory.eINSTANCE.createVector3f();
			maxu.setX(-Double.MAX_VALUE);
			maxu.setY(-Double.MAX_VALUE);
			maxu.setZ(-Double.MAX_VALUE);
			newBoundsu.setMin(minu);
			newBoundsu.setMax(maxu);

			Bounds newBoundsuMm = GeometryFactory.eINSTANCE.createBounds();
			Vector3f minuMm = GeometryFactory.eINSTANCE.createVector3f();
			minuMm.setX(Double.MAX_VALUE);
			minuMm.setY(Double.MAX_VALUE);
			minuMm.setZ(Double.MAX_VALUE);
			Vector3f maxuMm = GeometryFactory.eINSTANCE.createVector3f();
			maxuMm.setX(-Double.MAX_VALUE);
			maxuMm.setY(-Double.MAX_VALUE);
			maxuMm.setZ(-Double.MAX_VALUE);
			newBoundsuMm.setMin(minuMm);
			newBoundsuMm.setMax(maxuMm);
			
			revision.setBounds(newBounds);
			revision.setBoundsUntransformed(newBoundsu);
			revision.setBoundsMm(newBoundsMm);
			revision.setBoundsUntransformedMm(newBoundsuMm);
			
			for (ConcreteRevision concreteRevision2 : revision.getConcreteRevisions()) {
				Vector3f min2 = concreteRevision2.getBounds().getMin();
				Vector3f max2 = concreteRevision2.getBounds().getMax();

				float mm = concreteRevision2.getMultiplierToMm();
				
				if (min2.getX() < min.getX()) {
					min.setX(min2.getX());
				}
				if (min2.getY() < min.getY()) {
					min.setY(min2.getY());
				}
				if (min2.getZ() < min.getZ()) {
					min.setZ(min2.getZ());
				}
				if (max2.getX() > max.getX()) {
					max.setX(max2.getX());
				}
				if (max2.getY() > max.getY()) {
					max.setY(max2.getY());
				}
				if (max2.getZ() > max.getZ()) {
					max.setZ(max2.getZ());
				}

				if (min2.getX() * mm < minMm.getX()) {
					minMm.setX(min2.getX() * mm);
				}
				if (min2.getY() * mm < minMm.getY()) {
					minMm.setY(min2.getY() * mm);
				}
				if (min2.getZ() * mm < minMm.getZ()) {
					minMm.setZ(min2.getZ() * mm);
				}
				if (max2.getX() * mm > maxMm.getX()) {
					maxMm.setX(max2.getX() * mm);
				}
				if (max2.getY() * mm > maxMm.getY()) {
					maxMm.setY(max2.getY() * mm);
				}
				if (max2.getZ() * mm > maxMm.getZ()) {
					maxMm.setZ(max2.getZ() * mm);
				}
				
				Vector3f min2u = concreteRevision2.getBoundsUntransformed().getMin();
				Vector3f max2u = concreteRevision2.getBoundsUntransformed().getMax();
				if (min2u.getX() < minu.getX()) {
					minu.setX(min2u.getX());
				}
				if (min2u.getY() < minu.getY()) {
					minu.setY(min2u.getY());
				}
				if (min2u.getZ() < minu.getZ()) {
					minu.setZ(min2u.getZ());
				}
				if (max2u.getX() > maxu.getX()) {
					maxu.setX(max2u.getX());
				}
				if (max2u.getY() > maxu.getY()) {
					maxu.setY(max2u.getY());
				}
				if (max2u.getZ() > maxu.getZ()) {
					maxu.setZ(max2u.getZ());
				}
				
				if (min2u.getX() * mm < minuMm.getX()) {
					minuMm.setX(min2u.getX() * mm);
				}
				if (min2u.getY() * mm < minuMm.getY()) {
					minuMm.setY(min2u.getY() * mm);
				}
				if (min2u.getZ() * mm < minuMm.getZ()) {
					minuMm.setZ(min2u.getZ() * mm);
				}
				if (max2u.getX() * mm > maxuMm.getX()) {
					maxuMm.setX(max2u.getX() * mm);
				}
				if (max2u.getY() * mm > maxuMm.getY()) {
					maxuMm.setY(max2u.getY() * mm);
				}
				if (max2u.getZ() * mm> maxuMm.getZ()) {
					maxuMm.setZ(max2u.getZ() * mm);
				}
			}
		}
		
		DensityCollection densityCollection = getDatabaseSession().create(DensityCollection.class);
		concreteRevision.eSet(StorePackage.eINSTANCE.getConcreteRevision_DensityCollection(), densityCollection);
		
		List<org.bimserver.models.store.Density> newList = new ArrayList<>();
		for (Density density : generateGeometry.getDensities()) {
			org.bimserver.models.store.Density dbDensity = StoreFactory.eINSTANCE.createDensity();
			dbDensity.setType(density.getType());
			dbDensity.setDensity(density.getDensityValue());
			dbDensity.setGeometryInfoId(density.getGeometryInfoId());
			dbDensity.setTrianglesBelow(density.getNrPrimitives());
			dbDensity.setVolume(density.getVolume());
			newList.add(dbDensity);
		}
		newList.sort(new Comparator<org.bimserver.models.store.Density>(){
			@Override
			public int compare(org.bimserver.models.store.Density o1, org.bimserver.models.store.Density o2) {
				return Float.compare(o1.getDensity(), o2.getDensity());
			}});
		densityCollection.getDensities().addAll(newList);
		
		// TODO copy code to other 3 places, better deduplicate this code
		
		// For all revisions created, we need to repopulate the density arrays and make sure those are sorted
		for (Revision rev : result.getRevisions()) {
			long nrTriangles = 0;
			densityCollection = getDatabaseSession().create(DensityCollection.class);
			rev.eSet(StorePackage.eINSTANCE.getRevision_DensityCollection(), densityCollection);
			List<org.bimserver.models.store.Density> newList2 = new ArrayList<>();
			for (ConcreteRevision concreteRevision2 : rev.getConcreteRevisions()) {
				for (org.bimserver.models.store.Density density : concreteRevision2.getDensityCollection().getDensities()) {
					newList2.add(density);
					nrTriangles += density.getTrianglesBelow();
				}
			}
			densityCollection.getDensities().clear();
			newList2.sort(new Comparator<org.bimserver.models.store.Density>(){
				@Override
				public int compare(org.bimserver.models.store.Density o1, org.bimserver.models.store.Density o2) {
					return Float.compare(o1.getDensity(), o2.getDensity());
				}});
			densityCollection.getDensities().addAll(newList2);
			rev.eSet(StorePackage.eINSTANCE.getRevision_NrPrimitives(), nrTriangles);
		}
	}
	
	@SuppressWarnings("unchecked")
	protected void fixInverses(PackageMetaData packageMetaData, long newRoid, Map<EClass, Integer> summaryMap) throws QueryException, JsonParseException, JsonMappingException, IOException, BimserverDatabaseException {
		// TODO remove cache, this is essentially a big part of the model in memory again
		Map<Long, HashMapVirtualObject> cache = new HashMap<Long, HashMapVirtualObject>();
		Query query = new Query("Inverses fixer", packageMetaData);
		
		int nrTypes = 0;
		Set<EClass> uniqueTypes = new HashSet<>();
		for (EClass eClass : summaryMap.keySet()) {
			if (packageMetaData.hasInverses(eClass)) {
				QueryPart queryPart = query.createQueryPart();
				queryPart.addType(eClass, true);
				uniqueTypes.add(eClass);
				nrTypes++;
				for (EReference eReference : packageMetaData.getAllHasInverseReferences(eClass)) {
					Include include = queryPart.createInclude();
					include.addType(eClass, true);
					include.addField(eReference.getName());
				}
			}
		}
		
		QueryObjectProvider queryObjectProvider = new QueryObjectProvider(getDatabaseSession(), bimServer, query, Collections.singleton(newRoid), packageMetaData);
		HashMapVirtualObject next = queryObjectProvider.next();
		EClass lastEClass = null;
		int currentType = 0;
		while (next != null) {
			if (next.eClass() != lastEClass && uniqueTypes.contains(next.eClass()) && queryObjectProvider.getStackFrame() instanceof QueryTypeStackFrame) {
				lastEClass = next.eClass();
				currentType++;
				setProgress("Generating inverses", (100 * currentType / nrTypes));
			}
			if (packageMetaData.hasInverses(next.eClass())) {
				for (EReference eReference : packageMetaData.getAllHasInverseReferences(next.eClass())) {
					Object reference = next.eGet(eReference);
					if (reference != null) {
						if (eReference.isMany()) {
							List<Long> references = (List<Long>)reference;
							for (Long refOid : references) {
								fixInverses(packageMetaData, newRoid, cache, next, eReference, refOid);
							}
						} else {
							fixInverses(packageMetaData, newRoid, cache, next, eReference, (Long)reference);
						}
					}
				}
			}
			next = queryObjectProvider.next();
		}
		
		setProgress("Storing data", -1);
		
		for (HashMapVirtualObject referencedObject : cache.values()) {
			referencedObject.saveOverwrite();
		}
	}
	
	private void fixInverses(PackageMetaData packageMetaData, long newRoid, Map<Long, HashMapVirtualObject> cache, HashMapVirtualObject next, EReference eReference, long refOid)
			throws JsonParseException, JsonMappingException, IOException, QueryException, BimserverDatabaseException {
		HashMapVirtualObject referencedObject = cache.get(refOid);
		if (referencedObject == null) {
			referencedObject = getByOid(packageMetaData, getDatabaseSession(), newRoid, refOid);
			if (referencedObject == null) {
				throw new BimserverDatabaseException("Referenced object with oid " + refOid + " (" + getDatabaseSession().getEClassForOid(refOid).getName() + ")" + ", referenced from " + next.eClass().getName() + " not found");
			}
			cache.put(refOid, referencedObject);
		}
		EReference oppositeReference = packageMetaData.getInverseOrOpposite(referencedObject.eClass(), eReference);
		if (oppositeReference == null) {
			if (eReference.getName().equals("RelatedElements") && referencedObject.eClass().getName().equals("IfcSpace")) {
				// Ignore, IfcSpace should have  a field called RelatedElements, but it doesn't.
			} else {
//				LOGGER.error("No opposite " + eReference.getName() + " found");
			}
		} else {
			if (oppositeReference.isMany()) {
				Object existingList = referencedObject.eGet(oppositeReference);
				if (existingList != null) {
					int currentSize = ((List<?>)existingList).size();
					referencedObject.setListItemReference(oppositeReference, currentSize, next.eClass(), next.getOid(), 0);
				} else {
					referencedObject.setListItemReference(oppositeReference, 0, next.eClass(), next.getOid(), 0);
				}
			} else {
				referencedObject.setReference(oppositeReference, next.getOid(), 0);
			}
		}
	}
	
	public HashMapVirtualObject getByOid(PackageMetaData packageMetaData, DatabaseSession databaseSession, long roid, long oid) throws JsonParseException, JsonMappingException, IOException, QueryException, BimserverDatabaseException {
		Query query = new Query("test", packageMetaData);
		QueryPart queryPart = query.createQueryPart();
		queryPart.addOid(oid);
		QueryObjectProvider queryObjectProvider = new QueryObjectProvider(databaseSession, bimServer, query, Collections.singleton(roid), packageMetaData);
		HashMapVirtualObject first = queryObjectProvider.next();
		return first;
	}
	
	public BimServer getBimServer() {
		return bimServer;
	}
}