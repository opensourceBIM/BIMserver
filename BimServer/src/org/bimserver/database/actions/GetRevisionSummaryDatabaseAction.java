package org.bimserver.database.actions;

import java.util.HashMap;
import java.util.Map;

import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.ifc.IfcModel;
import org.bimserver.models.ifc2x3.Ifc2x3Package;
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
	private Map<EClass, Integer> map = new HashMap<EClass, Integer>();

	public GetRevisionSummaryDatabaseAction(BimDatabaseSession bimDatabaseSession, AccessMethod accessMethod, long roid) {
		super(bimDatabaseSession, accessMethod);
		this.roid = roid;
	}

	@Override
	public RevisionSummary execute() throws UserException, BimDeadlockException, BimDatabaseException {
		RevisionSummary revisionSummary = StoreFactory.eINSTANCE.createRevisionSummary();
		revisionSummaryContainerEntities = StoreFactory.eINSTANCE.createRevisionSummaryContainer();
		revisionSummaryContainerEntities.setName("IFC Entities");
		revisionSummaryContainerRelations = StoreFactory.eINSTANCE.createRevisionSummaryContainer();
		revisionSummaryContainerRelations.setName("IFC Relations");
		revisionSummaryContainerPrimitives = StoreFactory.eINSTANCE.createRevisionSummaryContainer();
		revisionSummaryContainerPrimitives.setName("IFC Primitives");
		revisionSummaryContainerOther = StoreFactory.eINSTANCE.createRevisionSummaryContainer();
		revisionSummaryContainerOther.setName("Rest");
		Revision revision = getVirtualRevision(roid);
		for (ConcreteRevision subRevision : revision.getConcreteRevisions()) {
			for (EClass eClass : getDatabaseSession().getClasses()) {
				int count = getDatabaseSession().getCount(eClass, new IfcModel(), subRevision.getProject().getId(), subRevision.getId());
				add(revisionSummary, eClass, count);
			}
		}
		for (EClass eClass : map.keySet()) {
			RevisionSummaryContainer subMap = null;
			if (Ifc2x3Package.eINSTANCE.getIfcObject().isSuperTypeOf(eClass)) {
				subMap = revisionSummaryContainerEntities;
			} else if (Ifc2x3Package.eINSTANCE.getIfcRelationship().isSuperTypeOf(eClass)) {
				subMap = revisionSummaryContainerRelations;
			} else if (Ifc2x3Package.eINSTANCE.getWrappedValue().isSuperTypeOf(eClass)) {
				subMap = revisionSummaryContainerPrimitives;
			} else {
				subMap = revisionSummaryContainerOther;
			}
			RevisionSummaryType createRevisionSummaryType = StoreFactory.eINSTANCE.createRevisionSummaryType();
			createRevisionSummaryType.setCount(map.get(eClass));
			createRevisionSummaryType.setName(eClass.getName());
			subMap.getTypes().add(createRevisionSummaryType);
		}
		return revisionSummary;
	}
	
	public void add(RevisionSummary revisionSummary, EClass eClass, int count) {
		if (count == 0) {
			return;
		}
		if (!map.containsKey(eClass)) {
			map.put(eClass, 0);
		}
		map.put(eClass, map.get(eClass) + 1);
	}
}