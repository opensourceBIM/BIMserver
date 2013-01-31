package org.bimserver;

import java.util.Map;
import java.util.TreeMap;

import org.bimserver.database.BimserverDatabaseException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.emf.IdEObject;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package;
import org.bimserver.models.store.RevisionSummary;
import org.bimserver.models.store.RevisionSummaryContainer;
import org.bimserver.models.store.RevisionSummaryType;
import org.bimserver.models.store.StorePackage;
import org.eclipse.emf.ecore.EClass;

public class SummaryMap {
	private final Map<EClass, Integer> summaryMap = new TreeMap<EClass, Integer>(new EClassNameComparator());

	public SummaryMap(IfcModelInterface model) throws BimserverDatabaseException {
		for (IdEObject idEObject : model.getValues()) {
			if (!summaryMap.containsKey(idEObject.eClass())) {
				summaryMap.put(idEObject.eClass(), 1);
			} else {
				summaryMap.put(idEObject.eClass(), summaryMap.get(idEObject.eClass()) + 1);
			}
		}
	}
	
	public SummaryMap(RevisionSummary revisionSummary) {
		for (RevisionSummaryContainer revisionSummaryContainer : revisionSummary.getList()) {
			for (RevisionSummaryType revisionSummaryType : revisionSummaryContainer.getTypes()) {
				summaryMap.put((EClass)Ifc2x3tc1Package.eINSTANCE.getEClassifier(revisionSummaryType.getName()), revisionSummaryType.getCount());
			}
		}
	}
	
	public SummaryMap() {
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
		RevisionSummary revisionSummary = databaseSession.create(StorePackage.eINSTANCE.getRevisionSummary());
		RevisionSummaryContainer revisionSummaryContainerEntities = databaseSession.create(StorePackage.eINSTANCE.getRevisionSummaryContainer());
		revisionSummaryContainerEntities.setName("IFC Entities");
		revisionSummary.getList().add(revisionSummaryContainerEntities);
		RevisionSummaryContainer revisionSummaryContainerRelations = databaseSession.create(StorePackage.eINSTANCE.getRevisionSummaryContainer());
		revisionSummaryContainerRelations.setName("IFC Relations");
		revisionSummary.getList().add(revisionSummaryContainerRelations);
		RevisionSummaryContainer revisionSummaryContainerPrimitives = databaseSession.create(StorePackage.eINSTANCE.getRevisionSummaryContainer());
		revisionSummaryContainerPrimitives.setName("IFC Primitives");
		revisionSummary.getList().add(revisionSummaryContainerPrimitives);
		RevisionSummaryContainer revisionSummaryContainerOther = databaseSession.create(StorePackage.eINSTANCE.getRevisionSummaryContainer());
		revisionSummaryContainerOther.setName("Rest");
		revisionSummary.getList().add(revisionSummaryContainerOther);
		
		for (EClass eClass : summaryMap.keySet()) {
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
			RevisionSummaryType createRevisionSummaryType = databaseSession.create(StorePackage.eINSTANCE.getRevisionSummaryType());
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