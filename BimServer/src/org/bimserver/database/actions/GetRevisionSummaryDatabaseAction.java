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

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.ConcreteRevision;
import org.bimserver.models.store.Revision;
import org.bimserver.models.store.RevisionSummary;
import org.bimserver.models.store.RevisionSummaryContainer;
import org.bimserver.models.store.RevisionSummaryType;
import org.bimserver.models.store.StoreFactory;
import org.bimserver.shared.exceptions.UserException;
import org.eclipse.emf.ecore.EClass;

public class GetRevisionSummaryDatabaseAction extends BimDatabaseAction<RevisionSummary> {

	private final long roid;
	private RevisionSummaryContainer revisionSummaryContainerEntities;
	private RevisionSummaryContainer revisionSummaryContainerRelations;
	private RevisionSummaryContainer revisionSummaryContainerPrimitives;
	private RevisionSummaryContainer revisionSummaryContainerOther;
	
	private Map<EClass, Integer> map = new TreeMap<EClass, Integer>(new Comparator<EClass>() {
		@Override
		public int compare(EClass o1, EClass o2) {
			return o1.getName().compareTo(o2.getName());
		}
	});

	public GetRevisionSummaryDatabaseAction(DatabaseSession databaseSession, AccessMethod accessMethod, long roid) {
		super(databaseSession, accessMethod);
		this.roid = roid;
	}

	@Override
	public RevisionSummary execute() throws UserException, BimserverLockConflictException, BimserverDatabaseException {
		Revision revision = getRevisionByRoid(roid);
		if (revision.getConcreteRevisions().size() == 1 && revision.getConcreteRevisions().get(0).getSummary() != null) {
			return revision.getConcreteRevisions().get(0).getSummary();
		} else {
			for (ConcreteRevision concreteRevision : revision.getConcreteRevisions()) {
				if (concreteRevision.getSummary() != null) {
					merge(concreteRevision.getSummary());
				}
			}
		}
		return createSummary();
	}
	
	private RevisionSummary createSummary() {
		RevisionSummary revisionSummary = StoreFactory.eINSTANCE.createRevisionSummary();
		revisionSummaryContainerEntities = StoreFactory.eINSTANCE.createRevisionSummaryContainer();
		revisionSummaryContainerEntities.setName("IFC Entities");
		revisionSummary.getList().add(revisionSummaryContainerEntities);
		revisionSummaryContainerRelations = StoreFactory.eINSTANCE.createRevisionSummaryContainer();
		revisionSummaryContainerRelations.setName("IFC Relations");
		revisionSummary.getList().add(revisionSummaryContainerRelations);
		revisionSummaryContainerPrimitives = StoreFactory.eINSTANCE.createRevisionSummaryContainer();
		revisionSummaryContainerPrimitives.setName("IFC Primitives");
		revisionSummary.getList().add(revisionSummaryContainerPrimitives);
		revisionSummaryContainerOther = StoreFactory.eINSTANCE.createRevisionSummaryContainer();
		revisionSummaryContainerOther.setName("Rest");
		revisionSummary.getList().add(revisionSummaryContainerOther);
		for (EClass eClass : map.keySet()) {
			RevisionSummaryContainer subMap = null;
			if (Ifc2x3tc1Package.eINSTANCE.getIfcObject().isSuperTypeOf(eClass)) {
				subMap = revisionSummaryContainerEntities;
			} else if (Ifc2x3tc1Package.eINSTANCE.getIfcRelationship().isSuperTypeOf(eClass)) {
				subMap = revisionSummaryContainerRelations;
			} else if (eClass.getEAnnotation("wrapped") != null) {
				subMap = revisionSummaryContainerPrimitives;
			} else {
				subMap = revisionSummaryContainerOther;
			}
			RevisionSummaryType createRevisionSummaryType = StoreFactory.eINSTANCE.createRevisionSummaryType();
			createRevisionSummaryType.setSchema(eClass.getEPackage().getName());
			createRevisionSummaryType.setCount(map.get(eClass));
			createRevisionSummaryType.setName(eClass.getName());
			subMap.getTypes().add(createRevisionSummaryType);
		}
		return revisionSummary;
	}

	private void merge(RevisionSummary add) throws BimserverDatabaseException {
		for (RevisionSummaryContainer summaryContainer : add.getList()) {
			for (RevisionSummaryType revisionSummaryType : summaryContainer.getTypes()) {
				if (!map.containsKey(getDatabaseSession().getEClass(revisionSummaryType.getSchema(), revisionSummaryType.getName()))) {
					map.put(getDatabaseSession().getEClass(revisionSummaryType.getSchema(), revisionSummaryType.getName()), revisionSummaryType.getCount());
				} else {
					map.put(getDatabaseSession().getEClass(revisionSummaryType.getSchema(), revisionSummaryType.getName()), map.get(getDatabaseSession().getEClass(revisionSummaryType.getSchema(), revisionSummaryType.getName())) + revisionSummaryType.getCount());
				}
			}
		}
	}
}