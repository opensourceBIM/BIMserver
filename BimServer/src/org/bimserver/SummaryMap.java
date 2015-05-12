package org.bimserver;

/******************************************************************************
 * Copyright (C) 2009-2015  BIMserver.org
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
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************/

import java.util.Map;
import java.util.TreeMap;

import org.bimserver.database.BimserverDatabaseException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.emf.IdEObject;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.emf.PackageMetaData;
import org.bimserver.models.store.RevisionSummary;
import org.bimserver.models.store.RevisionSummaryContainer;
import org.bimserver.models.store.RevisionSummaryType;
import org.eclipse.emf.ecore.EClass;

public class SummaryMap {
	private final Map<EClass, Integer> summaryMap = new TreeMap<EClass, Integer>(new EClassNameComparator());
	private final PackageMetaData packageMetaData;

	public SummaryMap(IfcModelInterface model) throws BimserverDatabaseException {
		this.packageMetaData = model.getPackageMetaData();
		for (IdEObject idEObject : model.getValues()) {
			if (!summaryMap.containsKey(idEObject.eClass())) {
				summaryMap.put(idEObject.eClass(), 1);
			} else {
				summaryMap.put(idEObject.eClass(), summaryMap.get(idEObject.eClass()) + 1);
			}
		}
	}

	public SummaryMap(PackageMetaData packageMetaData) {
		this.packageMetaData = packageMetaData;
	}
	
	public SummaryMap(PackageMetaData packageMetaData, RevisionSummary revisionSummary) {
		this.packageMetaData = packageMetaData;
		for (RevisionSummaryContainer revisionSummaryContainer : revisionSummary.getList()) {
			for (RevisionSummaryType revisionSummaryType : revisionSummaryContainer.getTypes()) {
				summaryMap.put((EClass)packageMetaData.getEPackage().getEClassifier(revisionSummaryType.getName()), revisionSummaryType.getCount());
			}
		}
	}
	
	public void remove(EClass eClass, int count) {
		if (count == 0) {
			return;
		}
		if (!summaryMap.containsKey(eClass)) {
			// Interesting...
			summaryMap.put(eClass, 0);
		} else {
			summaryMap.put(eClass, summaryMap.get(eClass) - count);
		}
	}
	
	public void add(EClass eClass, int count) {
		if (count == 0) {
			return;
		}
		if (!summaryMap.containsKey(eClass)) {
			summaryMap.put(eClass, count);
		} else {
			summaryMap.put(eClass, summaryMap.get(eClass) + count);
		}
	}
	
	public RevisionSummary toRevisionSummary(DatabaseSession databaseSession) throws BimserverDatabaseException {
		RevisionSummary revisionSummary = databaseSession.create(RevisionSummary.class);
		RevisionSummaryContainer revisionSummaryContainerEntities = databaseSession.create(RevisionSummaryContainer.class);
		revisionSummaryContainerEntities.setName("IFC Entities");
		revisionSummary.getList().add(revisionSummaryContainerEntities);
		RevisionSummaryContainer revisionSummaryContainerRelations = databaseSession.create(RevisionSummaryContainer.class);
		revisionSummaryContainerRelations.setName("IFC Relations");
		revisionSummary.getList().add(revisionSummaryContainerRelations);
		RevisionSummaryContainer revisionSummaryContainerPrimitives = databaseSession.create(RevisionSummaryContainer.class);
		revisionSummaryContainerPrimitives.setName("IFC Primitives");
		revisionSummary.getList().add(revisionSummaryContainerPrimitives);
		RevisionSummaryContainer revisionSummaryContainerOther = databaseSession.create(RevisionSummaryContainer.class);
		revisionSummaryContainerOther.setName("Rest");
		revisionSummary.getList().add(revisionSummaryContainerOther);
		
		for (EClass eClass : summaryMap.keySet()) {
			RevisionSummaryContainer subMap = null;
			if (((EClass) packageMetaData.getEPackage().getEClassifier("IfcObject")).isSuperTypeOf(eClass)) {
				subMap = revisionSummaryContainerEntities;
			} else if (((EClass) packageMetaData.getEPackage().getEClassifier("IfcRelationship")).isSuperTypeOf(eClass)) {
				subMap = revisionSummaryContainerRelations;
			} else if (eClass.getEAnnotation("wrapped") != null) {
				subMap = revisionSummaryContainerPrimitives;
			} else {
				subMap = revisionSummaryContainerOther;
			}
			RevisionSummaryType createRevisionSummaryType = databaseSession.create(RevisionSummaryType.class);
			createRevisionSummaryType.setSchema(eClass.getEPackage().getName());
			createRevisionSummaryType.setCount(summaryMap.get(eClass));
			createRevisionSummaryType.setName(eClass.getName());
			subMap.getTypes().add(createRevisionSummaryType);
		}
		return revisionSummary;
	}

	public int count(EClass eClass) {
		if (summaryMap.containsKey(eClass)) {
			return summaryMap.get(eClass);
		}
		return 0;
	}
}